
package com.analytics.covid19.data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Mo
 */
public class Data implements Serializable {

    private LocalDate date;
    private int stat;
    private String NameRef;
    private String Region;

    public Data() {
        date = null;
        stat = 0;
        NameRef = "";
        Region = "";
    }

    public Data(LocalDate date, int stat, String NameRef, String Region) {
        this.date = date;
        this.stat = stat;
        this.NameRef = NameRef;
        this.Region = Region;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDateStr() {
        return date.toString();
    }

    public int getStat() {
        return stat;
    }

    public String getNameRef() {
        return NameRef;
    }

    public String getRegion() {
        return Region;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    public void setNameRef(String NameRef) {
        this.NameRef = NameRef;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }
    
    
    @Override
    public String toString() {
        return "Data{" + "date=" + date + ", stat=" + stat + ", NameRef=" + NameRef + '}';
    }

    
    
}
