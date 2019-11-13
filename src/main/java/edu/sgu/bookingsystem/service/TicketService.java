package edu.sgu.bookingsystem.service;

import java.util.List;

import edu.sgu.bookingsystem.model.SeatModel;
import edu.sgu.bookingsystem.model.TicketModel;
import edu.sgu.bookingsystem.paging.Pageble;

public interface TicketService {
	List<TicketModel> findAll(Pageble pageble);
	
	List<TicketModel> findSeatByBookingId(long bookingId); 
	
	TicketModel save(TicketModel ticketModel);
	TicketModel updateapi(TicketModel updateTicket);
	void delete(long[] ids);
	
	int getTotalItem();
	
	TicketModel findOne(long id);
	TicketModel findByBookingId(long bookingId,  int seat);
	
	List<TicketModel> findSeatByStatus();
	 List<TicketModel> findAllAvailabeSeat(long busId);

	void cancelTicket(long[] ids, int[] seats);
	
	TicketModel findBySeat(long busId, int seat);
	
	TicketModel updateTicket(TicketModel updateTicket);
}
