package edu.sgu.bookingsystem.dao;


import java.util.List;

import edu.sgu.bookingsystem.model.Seat;
import edu.sgu.bookingsystem.model.Ticket;

public interface BookingTicketDAO {

	int insertBooking(Ticket ticket, String[] listSeatStringArr);
		
	int cancelBooking(Ticket ticket);
	
	List<Ticket> getTicketBookedByCustomer(long customerID);
		
	List<Ticket> getTicketInfo(String startPlace, String finishPlace, String dateStart, String timeStart);
	
	List<Ticket> getSeatsBySchedule(long startPlace, long finishPlace, String dateStart, String timeStart);

}
