package edu.ma.wa.nqueue.capstoneapp.Server;


public class MyLocation {


	private String name;

	private double longitude;
	private double latitude;
	
	public MyLocation(){
		longitude = 0;
		latitude = 0;
		name = "";
	}
	
	public MyLocation(String id, double lon, double lat){
		longitude = lon;
		latitude = lat;
		name = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
	public double getLongitude(){
		return longitude;
	}
	
	public double getLatitude(){
		return latitude;
	}	
	
	public void setLongitude(double l){
		longitude = l;
	}
	
	public void setLatitude(double l){
		 latitude = l;
	}

	
	
	
}
