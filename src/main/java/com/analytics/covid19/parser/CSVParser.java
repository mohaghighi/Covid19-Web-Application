
package com.analytics.covid19.parser;

/**
 *
 * @author Mo
 */


import com.analytics.covid19.source.DataSource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Vector;
import org.springframework.stereotype.Component;

public class CSVParser implements DataParser{
    
    private DataSource csvSource;
    
    public CSVParser(DataSource csvSource){
        this.csvSource=csvSource;
    }
    
    
    //Parse CSV Data into a MAP with Country -> Data for all dates as <String,String[]> Key-values
    public SortedMap<String,ArrayList<String>> parseKeyVals(){ 
    
        String LineContent;
        
        // key = country (from columns 1 per row) -> value = entire data set for the row
        SortedMap<String,ArrayList<String>> SearchByCountry = new TreeMap<>();
        
        try (BufferedReader buffer = new BufferedReader(new FileReader(csvSource.getSource()))) {

            while ((LineContent = buffer.readLine()) != null) {
                //String[] column = LineContent.split(",");
                //skipping commas between double-quotes 
                String[] column =skipQC(LineContent);
                ArrayList<String> columnAL = new ArrayList(Arrays.asList(column));
                if(column[0].length()<1){
                    //assigning a new name for countries with name-region-, if no region name-na-
                    SearchByCountry.put(column[1].toLowerCase(), columnAL);
                }else{
                    SearchByCountry.put(column[1].toLowerCase()+"-"+column[0].toLowerCase(), columnAL);
                }
            }
        } catch (IOException e) {
                e.printStackTrace();
        }
        SearchByCountry.remove("country/region-province/state");
        return SearchByCountry;
       
    }
    
    //skipping commas in double-quotes 
    public String[] skipQC(String arg){
        
        StringBuilder stbuilder = new StringBuilder(arg);
        boolean insideQuotes = false;
        
        for (int currentIndex = 0; currentIndex < stbuilder.length(); currentIndex++) {
                char currentChar = stbuilder.charAt(currentIndex);
                
                if (currentChar == '\"') insideQuotes = !insideQuotes;
                
                if (currentChar == ',' && insideQuotes) {
                    stbuilder.setCharAt(currentIndex, ' '); //replace the comma with space
                }
        }
        return stbuilder.toString().replaceAll("\"", "").split(",");
    }

    //getting all indeces for the dates (top row) in the CSV file
    public ArrayList<String> getDatesIndeces(){
        
        ArrayList<String> DateList =new ArrayList<String>();
        String LineContent;
        
        try (BufferedReader buffer = new BufferedReader(new FileReader(csvSource.getSource()))) {

            LineContent = buffer.readLine();
            String[] column = LineContent.split(",");
            
            for(int i=4;i<column.length;i++){
                DateList.add(column[i].toLowerCase().replace("/", "-"));
            }

        } catch (IOException e) {
                e.printStackTrace();
        }
        return DateList;
    }
    
    //getting the index of a particular date from the first row with "/" instead of "-"
    public int getDateIndex(String Date){
        
        ArrayList<String> DateList =new ArrayList<>();
        String LineContent;
        
        try (BufferedReader buffer = new BufferedReader(new FileReader(csvSource.getSource()))) {

            LineContent = buffer.readLine();
            String[] column = LineContent.split(",");
            
            //to skip the first 4 rows 
            for(int i=4;i<column.length;i++){
                DateList.add(column[i].toLowerCase());
            }

        } catch (IOException e) {
                e.printStackTrace();
        }
        return DateList.indexOf(Date);
    }
    
    public ArrayList<LocalDate> convertDates(ArrayList<String> arg){
        
        ArrayList<LocalDate> dateTable =new ArrayList<>();
        DateTimeFormatter Formatter = DateTimeFormatter.ofPattern("M-d-yy");
        //DateTimeFormatter outFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
        
        arg.forEach((i) -> {
            dateTable.add(LocalDate.parse(i, Formatter));
        });
        return dateTable;
    }
    
}
