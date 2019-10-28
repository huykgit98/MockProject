package edu.sgu.bookingsystem.model;

public class Place {
	private int id;
	private String placeName;
	public Place() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Place(int id, String placeName) {
		super();
		this.id = id;
		this.placeName = placeName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	
}
