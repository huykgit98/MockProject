package edu.sgu.bookingsystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.sgu.bookingsystem.dao.BookingTicketDAO;
import edu.sgu.bookingsystem.dao.impl.BookingTicketDAOImpl;
import edu.sgu.bookingsystem.model.Seat;
import edu.sgu.bookingsystem.model.Ticket;
import edu.sgu.bookingsystem.service.BookingTicketService;

public class BookingTicketServiceImpl implements BookingTicketService {
	BookingTicketDAO bookingticketdao = new BookingTicketDAOImpl();
	
	@Override
	public List<Ticket> getTicketInfo(String startPlace, String finishPlace, String dateStart, String timeStart) {
		List<Ticket> list = new ArrayList<Ticket>();
		list=bookingticketdao.getTicketInfo(startPlace, finishPlace, dateStart, timeStart);
		return list;
	}

	@Override
	public List<Ticket> getSeatsBySchedule(long startPlaceID, long finishPlaceID, String dateStart, String timeStart) {
		List<Ticket> list = new ArrayList<Ticket>();
		list=bookingticketdao.getSeatsBySchedule(startPlaceID, finishPlaceID, dateStart, timeStart);
		return list;
	}



	@Override
	public int insertTicket(Ticket ticket, String[] listSeatStringArr) {
		return bookingticketdao.insertBooking(ticket, listSeatStringArr);
	}

	@Override
	public ArrayList<Ticket> getAllTicket(long id) {
		ArrayList<Ticket> listTicket= new ArrayList<Ticket>();
		listTicket = bookingticketdao.getAllTicket(id);
		return listTicket;
	}

	@Override
	public ArrayList<Ticket> detailTicket(long idCus, long idBook) {
		ArrayList<Ticket> listTicket= new ArrayList<Ticket>();
		listTicket = bookingticketdao.detailTicket(idCus, idBook);
		return listTicket;
	}
	@Override
	public int cancelBooking(long bookingID) {
		return bookingticketdao.cancelBooking(bookingID);

	}
	
//	public static void main(String[] args) {
//	BookingTicketService bkservice = new BookingTicketServiceImpl();
//	List<Ticket> items=bkservice.getSeatsBySchedule(1, 7, "2019-11-11", "20:00:00");
//	System.out.println(items.size());
//	for(Ticket i:items){
//	//System.out.println(i.getStartPlace());
//	//System.out.println(i.getFinishPlace());
//	//System.out.println(i.getDateStart());
//	//System.out.println(i.getTimeStart());
//	System.out.println(i.getSeat());
//	System.out.println("");
//
//	}
//}
	public static void main(String[] args) {
	BookingTicketService bkservice = new BookingTicketServiceImpl();
	List<Ticket> items=bkservice.detailTicket(41, 6);
	System.out.println(items.size());
	for(Ticket i:items){
	//System.out.println(i.getStartPlace());
	//System.out.println(i.getFinishPlace());
	System.out.println(i.getNumberPlate());
	System.out.println(i.getPrice());
	System.out.println(i.getSeat());
	System.out.println("");

	}
}


	
}
