package edu.sgu.bookingsystem.model;

import java.sql.Date;
import java.util.List;
import java.lang.Object;


public class Booking {
	private long bookingID;
	private Schedule schedule;
	private Customer customer;
	private Date bookingDate;
	private Date dateStart;
	private String description;
	private int status;
	private List<Integer> seatList;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getBookingID() {
		return bookingID;
	}
	public void setBookingID(long bookingID) {
		this.bookingID = bookingID;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Integer> getSeatList() {
		return seatList;
	}
	
	public void setSeatList(List<Integer> seatList) {
		this.seatList = seatList;
	}
	public Booking(long bookingID, Schedule schedule, Customer customer, Date bookingDate, Date dateStart,
			String description, int status, List<Integer> seatList) {
		super();
		this.bookingID = bookingID;
		this.schedule = schedule;
		this.customer = customer;
		this.bookingDate = bookingDate;
		this.dateStart = dateStart;
		this.description = description;
		this.status = status;
		this.seatList = seatList;
	}
}
