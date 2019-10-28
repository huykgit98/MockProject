package edu.sgu.bookingsystem.model;

public class BusType {
	private int id;
	private String typeName;
	private String description;
	public BusType(int id, String typeName, String description) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.description = description;
	}
	public BusType(String typeName) {
		super();
		this.typeName = typeName;
	}
	public BusType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
