package edu.sgu.bookingsystem.dao;


import java.util.ArrayList;
import java.util.List;

import edu.sgu.bookingsystem.model.Seat;
import edu.sgu.bookingsystem.model.Ticket;

public interface BookingTicketDAO {

	int insertBooking(Ticket ticket, String[] listSeatStringArr);
		
	int cancelBooking(long bookingID);
	
	List<Ticket> getTicketBookedByCustomer(long customerID);
		
	List<Ticket> getTicketInfo(String startPlace, String finishPlace, String dateStart, String timeStart);
	
	List<Ticket> getSeatsBySchedule(long startPlace, long finishPlace, String dateStart, String timeStart);

	ArrayList<Ticket>  getAllTicket(long  id);
	ArrayList<Ticket> detailTicket(long idCus,long idBook);
}
