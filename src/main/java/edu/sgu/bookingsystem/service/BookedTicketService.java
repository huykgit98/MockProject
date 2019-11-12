package edu.sgu.bookingsystem.service;

import java.util.ArrayList;

import edu.sgu.bookingsystem.model.Ticket;

public interface BookedTicketService {
	ArrayList<Ticket>  getAllTicket(long  id);
	Ticket getIdBooking(long idCustomer,long idBooking);
}
