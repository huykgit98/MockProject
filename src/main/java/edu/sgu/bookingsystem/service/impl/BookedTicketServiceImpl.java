package edu.sgu.bookingsystem.service.impl;

import java.util.ArrayList;

import edu.sgu.bookingsystem.dao.BookedTicketDao;
import edu.sgu.bookingsystem.dao.impl.BookedTicketDAOImpl;
import edu.sgu.bookingsystem.model.Ticket;
import edu.sgu.bookingsystem.service.BookedTicketService;

public class BookedTicketServiceImpl implements BookedTicketService {

	BookedTicketDao ticketDao = new BookedTicketDAOImpl();
	@Override
	public ArrayList<Ticket> getAllTicket(long id) {
		// TODO Auto-generated method stub
		ArrayList<Ticket> listTicket= new ArrayList<Ticket>();
		listTicket = ticketDao.getAllTicket(id);
		return listTicket;
	}
	@Override
	public Ticket getIdBooking(long idCustomer, long idBooking) {
		// TODO Auto-generated method stub
		return ticketDao.getIdBooking(idCustomer, idBooking);
	}
}
