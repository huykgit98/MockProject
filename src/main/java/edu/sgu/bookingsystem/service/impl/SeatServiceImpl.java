package edu.sgu.bookingsystem.service.impl;

import java.util.List;

import edu.sgu.bookingsystem.dao.SeatDAO;
import edu.sgu.bookingsystem.model.SeatModel;
import edu.sgu.bookingsystem.paging.Pageble;
import edu.sgu.bookingsystem.service.SeatService;
import edu.sgu.bookingsystem.dao.impl.SeatDAOImpl;

public class SeatServiceImpl implements SeatService{

	private SeatDAO seatDAO = new SeatDAOImpl();
	
	@Override
	public List<SeatModel> findAll(Pageble pageble) {
		// TODO Auto-generated method stub
		return seatDAO.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return seatDAO.getTotalItem();
	}

	@Override
	public <T> List<SeatModel> findByText(T text) {
		// TODO Auto-generated method stub
		return seatDAO.findByText(text);
	}

	@Override
	public SeatModel findOne(long id) {
		// TODO Auto-generated method stub
		return seatDAO.findOne(id);
	}

	@Override
	public SeatModel findBySeat(long busId, int seat) {
		// TODO Auto-generated method stub
		return seatDAO.findBySeat(busId, seat);
	}

	@Override
	public List<SeatModel> findAllCustomer() {
		// TODO Auto-generated method stub
		return seatDAO.findAllCustomer();
	}

	@Override
	public SeatModel update(SeatModel updateSeat) {
		SeatModel oldTicket = seatDAO.findOne(updateSeat.getBooking().getBookingID());
		
		seatDAO.update(updateSeat);
		//TicketModel newTicket = ticketDAO.findOne(updateTicket.getBookingID());
		return seatDAO.findOne(updateSeat.getBooking().getBookingID());
	}

	@Override
	public SeatModel updateSeatStatus(SeatModel updateSeat) {
		SeatModel  oldSeat = seatDAO.findOne(updateSeat.getBookingId());
		
		seatDAO.updateSeatStatus(updateSeat);
		return seatDAO.findOne(updateSeat.getBookingId());
	}

	@Override
	public List<SeatModel> findAllStatus() {
		return seatDAO.findAllStatus();
	}

	@Override
	public SeatModel updateSeat(SeatModel updateSeat) {
		SeatModel  oldSeat = seatDAO.findOne(updateSeat.getBookingId());
		
		seatDAO.updateSeat(updateSeat);
		return seatDAO.findOne(updateSeat.getBookingId());
	}

}
