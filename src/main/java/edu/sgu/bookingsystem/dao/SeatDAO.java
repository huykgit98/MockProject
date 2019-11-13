package edu.sgu.bookingsystem.dao;

import java.util.List;

import edu.sgu.bookingsystem.model.SeatModel;
import edu.sgu.bookingsystem.model.TicketModel;
import edu.sgu.bookingsystem.paging.Pageble;

public interface SeatDAO  extends GenericDAO<SeatModel>{
	
	List<SeatModel> findAll(Pageble pageble);
	int getTotalItem();
	
	public <T> List<SeatModel> findByText(T text);
	
	public SeatModel findOne(long id);
	
	public SeatModel findBySeat(long busId, int seat);
	
	List<SeatModel> findAllCustomer();
	
	List<SeatModel> findBooking();
	
	void update(SeatModel seatModel);
	
	void updateSeatStatus(SeatModel seatModel);
	
	List<SeatModel> findAllStatus();
	
	void updateSeat(SeatModel seatModel);
	
}
