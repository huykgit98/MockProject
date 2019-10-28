package edu.sgu.bookingsystem.model;

import java.util.Date;
import java.util.List;

public class Schedule {
	private int id;
	private List<Bus> listBus;
	private Date timeStart;
	private String startPlace;
	private String finishPlace;
	private String price;
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Schedule(int id, List<Bus> listBus, Date timeStart, String startPlace, String finishPlace, String price) {
		super();
		this.id = id;
		this.listBus = listBus;
		this.timeStart = timeStart;
		this.startPlace = startPlace;
		this.finishPlace = finishPlace;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Bus> getListBus() {
		return listBus;
	}
	public void setListBus(List<Bus> listBus) {
		this.listBus = listBus;
	}
	public Date getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}
	public String getFinishPlace() {
		return finishPlace;
	}
	public void setFinishPlace(String finishPlace) {
		this.finishPlace = finishPlace;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
