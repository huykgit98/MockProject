package edu.sgu.bookingsystem.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import edu.sgu.bookingsystem.model.Booking;
import edu.sgu.bookingsystem.model.BookingTicket;
import edu.sgu.bookingsystem.model.Ticket;

public interface BookingTicketDAO {

	int insertBooking(Booking booking);
		
	int cancelBooking(BookingTicket BookingTicket);
	
	List<Ticket> getTicketBookedByCustomer(long customerID);
	
	//Booking getBookingByDateStartScheduleSeat(Booking booking);
	
	List<Ticket> getTicketInfo(String startPlace, String finishPlace, String dateStart, String timeStart);
	
	List<Ticket> getSeatsBySchedule(long startPlace, long finishPlace, String dateStart, String timeStart);

}
