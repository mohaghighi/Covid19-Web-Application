
package com.analytics.covid19.data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author Mo
 */

@Entity
public class Country implements Serializable {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private String RName=null;
    private String Region=null;
    private String Lat;
    private String Long;
    
    @Column( length = 10000 )
    private ArrayList<Data> DataSet=new ArrayList<>();

    
    public Country(){
        
    }
    
    public Country(String Name,String RName,String Region, String Lat, String Long,ArrayList<Data> DataSet){

        this.name=Name;
        this.RName=RName;
        this.Lat=Lat;
        this.Long=Long;
        this.DataSet=DataSet;
            if(Region.length()<2){
                this.Region=null;}else{
                this.Region=Region;
            }
    }
    
    public String getRegion() {
        return Region;
    }

    public String getLat() {
        return Lat;
    }

    public String getLong() {
        return Long;
    }

    public ArrayList<Data> getDataSet() {
        return DataSet;
    }
    
    public String getName() {
        return name;
    }
    
    public String getRName() {
        return RName;
    }
    
    public String getRealName(){
        
            return Region!=null ? RName+"-"+Region : RName;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public void setRName(String RName) {
        this.RName = RName;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public void setLat(String Lat) {
        this.Lat = Lat;
    }

    public void setLong(String Long) {
        this.Long = Long;
    }

    public void setDataSet(ArrayList<Data> DataSet) {
        this.DataSet = DataSet;
    }

    @Override
    public String toString() {
        return "Country{" + "ID=" + id + ", Name=" + name + ", RName=" + RName + ", Region=" + Region + ", Lat=" + Lat + ", Long=" + Long + ", DataSet=" + DataSet + '}';
    }
    
    
   
    public Data getDataForDate(int index){
        return DataSet.get(index);
    }
    
    public Data getDataForDate(LocalDate date){
        return getDataForDate(getDates().indexOf(date));
    }
    
    public ArrayList<LocalDate> getDates(){
        
        ArrayList<LocalDate> datesTable=new ArrayList<>();
        
        for(Data data:DataSet){
            datesTable.add(data.getDate());
        }
        return datesTable;
    }
    

}
