package edu.sgu.bookingsystem.model;

import java.util.Date;
import java.util.List;

public class Schedule {
	private long id;
	private List<Bus> listBus;
	private Date timeStart;
	private long startPlace;
	private long finishPlace;
	private double price;
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Schedule(long id, List<Bus> listBus, Date timeStart, long startPlace, long finishPlace, double price) {
		super();
		this.id = id;
		this.listBus = listBus;
		this.timeStart = timeStart;
		this.startPlace = startPlace;
		this.finishPlace = finishPlace;
		this.price = price;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public long getStartPlace() {
		return startPlace;
	}
	public void setStartPlace(long startPlace) {
		this.startPlace = startPlace;
	}
	public long getFinishPlace() {
		return finishPlace;
	}
	public void setFinishPlace(long finishPlace) {
		this.finishPlace = finishPlace;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
