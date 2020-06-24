
package com.analytics.covid19.REST;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Mo
 */
public class Request implements Serializable{
    
    private String countryName;
    private LocalDate fromDate,toDate;

    public Request(String countryName, LocalDate fromDate, LocalDate toDate) {
        this.countryName = countryName;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
    
    public Request(String countryName){
        this(countryName,null,null);
    }
    
    public Request(String countryName,LocalDate fromDate){
        this(countryName,fromDate,null);
    }
    
    public Request(LocalDate fromDate){
        this(null,fromDate,null);
    }
    
    public Request(){
        
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }
    
    
    
}
