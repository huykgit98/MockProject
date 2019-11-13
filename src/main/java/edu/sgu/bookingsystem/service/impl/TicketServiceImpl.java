package edu.sgu.bookingsystem.service.impl;

import java.util.List;

import javax.inject.Inject;

import edu.sgu.bookingsystem.dao.TicketDAO;
import edu.sgu.bookingsystem.dao.impl.TicketDAOImpl;
import edu.sgu.bookingsystem.model.SeatModel;
import edu.sgu.bookingsystem.model.TicketModel;
import edu.sgu.bookingsystem.paging.Pageble;
import edu.sgu.bookingsystem.service.TicketService;

public class TicketServiceImpl implements TicketService{
	
	
//	@Inject //servlet weld
//	private TicketDAO ticketDAO; //-> nhung vao controller
	
	private TicketDAO ticketDAO = new TicketDAOImpl();
		
	@Override
	//public List<TicketModel> findAll(Integer offset, Integer limit, String sortName, String sortBy) {
	public List<TicketModel> findAll(Pageble pageble) {
		return ticketDAO.findAll(pageble); //return ticketDAO.findAll(offset, limit, sortName, sortBy);
	}

	@Override
	public int getTotalItem() {
		return ticketDAO.getTotalItem();
	}

	@Override
	public List<TicketModel> findSeatByBookingId(long bookingId) {
		return ticketDAO.findSeatByBookingId(bookingId);
	}

	@Override
	public TicketModel save(TicketModel ticketModel) {
		Long ticketId = ticketDAO.save(ticketModel);
		return ticketDAO.findOne(ticketId);
	}

	@Override
	public TicketModel findOne(long id) {
		return ticketDAO.findOne(id);
	}
	@Override
	public TicketModel findByBookingId(long bookingId, int seat) {
		return ticketDAO.findByBookingId(bookingId, seat);
	}

	@Override
	public TicketModel updateapi(TicketModel updateTicket) {
		TicketModel oldTicket = ticketDAO.findOne(updateTicket.getBooking().getBookingID());
		
		ticketDAO.updateapi(updateTicket);
		//TicketModel newTicket = ticketDAO.findOne(updateTicket.getBookingID());
		return ticketDAO.findOne(updateTicket.getBooking().getBookingID());
	}

	@Override
	public List<TicketModel> findSeatByStatus() { //status = 0 -> find available seat
		return ticketDAO.findSeatByStatus();
	}
	@Override
	public List<TicketModel> findAllAvailabeSeat(long busId) {
		// TODO Auto-generated method stub
		return ticketDAO.findAllAvailabeSeat(busId);
	}
	
	@Override
	public void delete(long[] ids) {
		for (long id: ids)
		{
			ticketDAO.delete(id);
		}
		
	}

	@Override
	public void cancelTicket(long[] ids, int[] seats) {
		for (long id: ids)
		{
			for (int seat: seats)
			{
				ticketDAO.cancelTicket(id, seat);
			}
		}
		
	}

	@Override
	public TicketModel findBySeat(long busId, int seat) {
		// TODO Auto-generated method stub
		return ticketDAO.findBySeat(busId, seat);
	}

	@Override
	public TicketModel updateTicket(TicketModel updateTicket) {
		TicketModel oldTicket = ticketDAO.findOne(updateTicket.getBooking().getBookingID());
		
		ticketDAO.updateTicket(updateTicket);
		return ticketDAO.findOne(updateTicket.getBooking().getBookingID());
	}


	



}
