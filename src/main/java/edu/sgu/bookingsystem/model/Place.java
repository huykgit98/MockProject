package edu.sgu.bookingsystem.model;

public class Place {
	private long id;
	private String placeName;
	public Place() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Place(long id, String placeName) {
		super();
		this.id = id;
		this.placeName = placeName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	
}
