package edu.sgu.bookingsystem.dao;

import java.util.ArrayList;

import edu.sgu.bookingsystem.model.Ticket;

public interface BookedTicketDao {
	ArrayList<Ticket>  getAllTicket(long  id);
	ArrayList<Ticket> detailTicket();
	Ticket getIdBooking(long idCustomer,long idBooking);
}
