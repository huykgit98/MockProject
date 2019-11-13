package edu.sgu.bookingsystem.dao;

import java.util.List;

import edu.sgu.bookingsystem.model.SeatModel;
import edu.sgu.bookingsystem.model.TicketModel;
import edu.sgu.bookingsystem.paging.Pageble;

public interface TicketDAO  extends GenericDAO<TicketModel>{
	
	List<TicketModel> findAll(Pageble pageble);
	
	List<TicketModel> findSeatByBookingId(long bookingId);
	
	Long save(TicketModel ticketModel);
	void updateapi(TicketModel ticketModel);
	void delete(long id);
	
	int getTotalItem();
	
	public TicketModel findOne(long id);
	public TicketModel findByBookingId(long bookingId, int seat);
	
	public TicketModel findOneForTicket(long id);
	
	List<TicketModel> findSeatByStatus();
	public List<TicketModel> findAllAvailabeSeat(long busId);

	void cancelTicket(long id, int seat);
	
	public TicketModel findBySeat(long busId, int seat);
	
	void updateTicket(TicketModel ticketModel);
}
