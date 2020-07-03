
package com.analytics.covid19.REST;

import com.analytics.covid19.data.Country;
import com.analytics.covid19.data.Data;
import com.analytics.covid19.DataService;
import com.analytics.covid19.JPA.CountryRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
import java.util.SortedMap;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mo
 */


@RestController
public class SearchData {
    
    @Autowired
    private DataService dataService;
    private SortedMap<String,Country> dataBase;
    
    @Autowired
    private CountryRepository DataRepo;
    
    public SearchData(){
         dataService=new DataService();
         dataBase=dataService.BuildDatabase();
    }
    
    @Transactional
    @Bean
    public void popDataBase(){
         DataRepo.saveAll(new ArrayList(dataBase.values()));
    }
    
    private Country getDataBase(String countryName){
        //commeneted out to switch to JPA instead of in-memory
        //return dataBase.get(countryName.toLowerCase());
        return DataRepo.findByName(countryName);
    }
    
    private Country[] getDataBase(){
        
        Country[] countries=new Country[DataRepo.findAll().size()];
        return DataRepo.findAll().toArray(countries);
    }
    
    private ArrayList<Country> getDataBaseList(){
        return new ArrayList(DataRepo.findAll());
    }
    
    ///------------------------- String REST/Get Request -------------------------------
    
    @GetMapping("/hello/")
    public String getCountry() {
        return "hello world! \r\n";
    }
    
    @GetMapping("/get/source/")
    public String getSource() {
        return dataService.getCSVPath();
    }
    
    @GetMapping("/get/country/{countryName}")
    public Country getCountry(@PathVariable String countryName) {
        return getDataBase(countryName);
    }
    
    @GetMapping("/get/country/data/{countryName}")
    public Data[] getDataByCountry(@PathVariable String countryName) {
        
        return getDataByCountry(new Request(countryName));
    }
    
    @GetMapping("/get/country/data/dates/{countryName},{fromDate},{toDate}")
    public Data[] getDataFromDateToDate(@PathVariable String countryName,@PathVariable String fromDate,@PathVariable String toDate){
        
        return getDataFromDateToDate(new Request(countryName,convertDate(fromDate),convertDate(toDate)));
    }
    
    @GetMapping("/get/country/data/date/{countryName},{date}")
    public Data getCountryDataByDate(@PathVariable String countryName,@PathVariable String date){
     
        return getCountryDataByDate(new Request(countryName,convertDate(date)));
    }
    
    @GetMapping("get/data/date/{date}")
    public Data[] getAllDataByDate(@PathVariable String date){
        return getAllDataByDate(new Request(convertDate(date)));
    }
    
    @GetMapping("/country/list/")
    public String[] getCountryList(){
        
        String[] countriesNames= new String[getDataBase().length];
        for(int i=0;i<getDataBaseList().size();i++){
            countriesNames[i]=getDataBaseList().get(i).getName();
        }
        
        return countriesNames;
    }
    
    @GetMapping("/country/all/")
    public Country[] getAllCountries(){
        
        return getDataBase();
    }
    
    @GetMapping("/dates/")
    public LocalDate[] getAllDates(){
        LocalDate[] dates =new LocalDate[dataService.getDatesTable().size()];
        return dataService.getDatesTable().toArray(dates);
    }
    
    ///------------------------- Object REST/Post Request -------------------------------
    /// Take/Return Objects 
    
    @RequestMapping(value="/country/",method = RequestMethod.POST)
    public Country getCountry(@RequestBody Request request){
        
        return getDataBase(request.getCountryName());
    }
    
    @RequestMapping(value="/country/data/",method = RequestMethod.POST)
    public Data[] getDataByCountry(@RequestBody Request request){
        
        Data[] data=new Data[getDataBase(request.getCountryName()).getDataSet().size()];
        return getDataBase(request.getCountryName()).getDataSet().toArray(data);
    }
    
    @RequestMapping(value="/country/data/date/",method = RequestMethod.POST)
    public Data getCountryDataByDate(@RequestBody Request request){
        
        return getDataBase(request.getCountryName()).getDataForDate(request.getFromDate());
    }
    
    @RequestMapping(value="/country/data/dates/",method = RequestMethod.POST)
    public Data[] getDataFromDateToDate(@RequestBody Request request){
        
        return getDataFromDatetoDate(getDataBase(request.getCountryName()),request.getFromDate(),request.getToDate());
    }
    
    @RequestMapping(value="/data/date/",method = RequestMethod.POST)
    public Data[] getAllDataByDate(@RequestBody Request request){
        return getAllDataByDate(request.getFromDate());
    }
    
    //++++++++++++++ non-REST Methods +++++++++++++++
    
    //dataset of a given country in arralist string
    public ArrayList<String> getDataByCountry(Country country) {

        ArrayList<String> temp=new ArrayList<>();
        
        for(Data i:country.getDataSet()){
            temp.add(String.valueOf(i.getStat()));
        }
        return temp;
    }

    //data for a given country on a specific date 
    public Data getDataByCountryByDate(Country country, LocalDate date){
        
        return country.getDataForDate(date);
    }
    
    //all countries' data for a date in DATA return and LocalDate param
    public Data[] getAllDataByDate(LocalDate date){
        
        ArrayList<Data> temp=new ArrayList<>(); 
        Data[] temp_data;
        
        for(Country country:getDataBase()){
            temp.add(country.getDataForDate(date));
        }

        temp_data=new Data[temp.size()];
        temp_data=temp.toArray(temp_data);
        return temp_data;
            
    }
    
    public Data[] getDataFromDatetoDate(Country country,LocalDate from,LocalDate to){
            
         int numOfDays=(int)(from.until(to, DAYS));
         
         if(numOfDays>-1){
             
             Data[] data=new Data[numOfDays];
             for(int i=0;i<numOfDays;i++){
                 data[i]=getDataByCountryByDate(country,from.plusDays(i));
             }
             return data;
         }else{
             return null;
         }
    }
    
    public LocalDate convertDate(String arg){
        
        
        try{
        DateTimeFormatter Formatter = DateTimeFormatter.ofPattern("M-d-yy");
            return LocalDate.parse(arg, Formatter);
        }catch(Exception ex){
            System.out.println("Date Not Valid");
            return null;
        }
    }
    
    public boolean isDateValid(LocalDate date){
        return dataService.getDatesTable().contains(date);
    }

    
  
}
