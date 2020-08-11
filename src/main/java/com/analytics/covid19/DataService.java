
package com.analytics.covid19;

import com.analytics.covid19.JPA.CountryRepository;
import com.analytics.covid19.data.Country;
import com.analytics.covid19.data.Data;
import com.analytics.covid19.source.CSVSource;
import com.analytics.covid19.parser.DataParser;
import com.analytics.covid19.parser.CSVParser;
import com.analytics.covid19.source.URLSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mo
 */

@Component
public class DataService {
    
    //private String CSVPath="/Users/Mo/Covid-19/global.csv";
    //private String CSVPath="./global.csv";
    private CSVParser csvParser;
    
     
    //private String CSVPath_death="/Users/Mo/Covid-19/global_death.csv";
    private String CSVPath = "https://github.com/CSSEGISandData/COVID-19/raw/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    
    
    public DataService(){
        
        //csvParser=new CSVParser(new CSVSource(CSVPath));
        csvParser=new CSVParser(new URLSource(CSVPath));
    }

    public String getCSVPath() {
        return CSVPath;
    }

    public void setCSVPath(String CSVPath) {
        this.CSVPath = CSVPath;
    }
    
    public SortedMap<String,Country> BuildDatabase(){
        
        //Key->Value Map collection for Country->Dataset
        SortedMap<String,Country> DataSet = LoadDataFromSource(csvParser);
        return DataSet;
    }
    
    private SortedMap<String,Country> LoadDataFromSource(DataParser dataParser){
        
        SortedMap<String, ArrayList<String>> inputDataSet = dataParser.parseKeyVals();
        SortedMap<String, Country> outputDataSet=new TreeMap<>();
        
        Iterator<Map.Entry<String,ArrayList<String>>> itr = inputDataSet.entrySet().iterator(); 
        
            while(itr.hasNext()) 
            { 
                String[] Header=new String[4];
                Map.Entry<String, ArrayList<String>> entry=itr.next();
                
                for(int i=0;i<4;i++){
                    Header[i]=entry.getValue().get(i);
                }
                
                ArrayList<Data> dataSet=makeDataSet(Header[0],new ArrayList(entry.getValue().subList(4, entry.getValue().size())),Header[1]);
                
;               Country tempCountry=new Country(entry.getKey(),Header[1],Header[0],Header[2],Header[3],dataSet);
                outputDataSet.put(entry.getKey(), tempCountry);
            }
            
            return outputDataSet;
    }
    
    public ArrayList<Data> makeDataSet(String Region, ArrayList<String> oldData,String RealName){
        
        ArrayList<Data> newList=new ArrayList<>();
        ArrayList<LocalDate> DatesTable=getDatesTable();
        
        for(int i=0;i<DatesTable.size();i++){
            newList.add(new Data(DatesTable.get(i),Integer.parseInt(oldData.get(i)),RealName,Region));
        }
        return newList;
    }
    
    public ArrayList<LocalDate> getDatesTable(){
        
        return csvParser.convertDates(csvParser.getDatesIndeces());
        
    }


}
