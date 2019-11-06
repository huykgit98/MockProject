package edu.sgu.bookingsystem.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ticket {
	String typeName;
	String numberPlate;
	int seatNum;
	double price;
	String startPlace;
	String finishPlace;
	String dateStart;
	String timeStart;
	long bookingID;
	long cusID;
	int status;
	int seat;
	
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public long getBookingID() {
		return bookingID;
	}

	public void setBookingID(long bookingID) {
		this.bookingID = bookingID;
	}

	public long getCusID() {
		return cusID;
	}

	public void setCusID(long cusID) {
		this.cusID = cusID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public Ticket(String typeName, String numberPlate, int seatNum, double price, String startPlace, String finishPlace,
			String dateStart, String timeStart, long bookingID, long cusID, int status, int seat) {
		super();
		this.typeName = typeName;
		this.numberPlate = numberPlate;
		this.seatNum = seatNum;
		this.price = price;
		this.startPlace = startPlace;
		this.finishPlace = finishPlace;
		this.dateStart = dateStart;
		this.timeStart = timeStart;
		this.bookingID = bookingID;
		this.cusID = cusID;
		this.status = status;
		this.seat = seat;
	}
	
	
//	public static void main(String[] args) {
//		 LocalDate today = LocalDate.now();
//	        System.out.println("Current Date = " + today);
//	        LocalDate day = LocalDate.of(1998, 01, 01);
//	        System.out.println("Current Date = " + day);
//	        LocalTime as = LocalTime.of(20, 00, 00);
//	        System.out.println("Current Date = " + as);
//	        System.out.println("Date = " + String.valueOf(day));
//
//	        
//	}
}
