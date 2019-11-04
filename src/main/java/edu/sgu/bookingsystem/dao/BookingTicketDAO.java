package edu.sgu.bookingsystem.dao;

import java.time.LocalDate;
import java.util.List;

import edu.sgu.bookingsystem.model.Booking;

public interface BookingTicketDAO {
	//
	
	int insertBooking(Booking booking);
	
	//
	List<Booking> getTicketBookedAvailableByStartDate(LocalDate date,int page);
	
	//
	int cancelBooking(Booking bookingWeb);
	
	//
	List<Booking> getBookedByCusIDPage(int customer_ID, int page);
	//
	List<Booking> searchBooking(String search, int page);
	//
	Booking getBookingByDateStartScheduleSeat(Booking booking);
	
}
