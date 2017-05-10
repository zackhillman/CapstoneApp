package edu.ma.wa.nqueue.capstoneapp;

/**
 * Created by drewh on 5/9/2017.
 */

public class Contact {

    private String name;       //Name of location
    private int latitude;      //Latitude coordinate
    private int longitude;     //Longitude coordinate

    //Default constructor
    public Contact(){
        name="";
        latitude=0;
        longitude=0;
    }

    public Contact(String n,int lat,int lon){
        name=n;
        latitude=lat;
        longitude=lon;
    }

    public String getName(){
        return name;
    }

    public int getLatitude(){
        return latitude;
    }

    public int getLongitude(){
        return longitude;
    }

    public void setName(String n){
        name=n;
    }

    public void setLatitude(int l){
        latitude=l;
    }

    public void setLongitude(int l){
        longitude=l;
    }
}
