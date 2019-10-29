package edu.sgu.bookingsystem.model;

public class BusType {
	private long id;
	private String typeName;
	private String description;
	public BusType(long id, String typeName, String description) {
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
