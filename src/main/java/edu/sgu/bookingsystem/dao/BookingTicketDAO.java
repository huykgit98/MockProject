package edu.sgu.bookingsystem.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import edu.sgu.bookingsystem.model.Booking;
import edu.sgu.bookingsystem.model.BookingTicket;
import edu.sgu.bookingsystem.model.Ticket;

public interface BookingTicketDAO {

	int insertBooking(Booking booking);
	
	List<BookingTicket> getTicketBookedAvailableByStartDate(LocalDate date,int page);
	
	int cancelBooking(BookingTicket BookingTicket);
	
	
	List<BookingTicket> getBookedByCusIDPage(int customer_ID, int page);
	
	List<BookingTicket> searchBooking(String search, int page);
	
	Booking getBookingByDateStartScheduleSeat(Booking booking);
	
	List<Ticket> getTicketInfo(String startPlace, String finishPlace, String dateStart, String timeStart);
	
}
