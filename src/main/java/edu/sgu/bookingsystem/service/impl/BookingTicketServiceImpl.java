package edu.sgu.bookingsystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.sgu.bookingsystem.dao.BookingTicketDAO;
import edu.sgu.bookingsystem.dao.impl.BookingTicketDAOImpl;
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
	
//	public static void main(String[] args) {
//	BookingTicketService bkservice = new BookingTicketServiceImpl();
//	List<Ticket> items=bkservice.getTicketInfo("Sài Gòn", "Cà Mau", "2019-10-22", "20:00:00");
//	System.out.println(items.size());
//	for(Ticket i:items){
//	System.out.println(i.getStartPlace());
//	System.out.println(i.getFinishPlace());
//	System.out.println(i.getDateStart());
//	System.out.println(i.getTimeStart());
//	System.out.println(i.getSeat());
//	System.out.println("");
//
//	}
//
//}
	
}
