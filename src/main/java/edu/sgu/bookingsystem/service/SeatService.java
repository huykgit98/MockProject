package edu.sgu.bookingsystem.service;

import java.util.List;

import edu.sgu.bookingsystem.model.SeatModel;
import edu.sgu.bookingsystem.model.TicketModel;
import edu.sgu.bookingsystem.paging.Pageble;

public interface SeatService {
	List<SeatModel> findAll(Pageble pageble);
	int getTotalItem();
	
	public <T> List<SeatModel> findByText(T text);
	
	SeatModel findOne(long id);
	
	SeatModel findBySeat(long busId, int seat);
	
	List<SeatModel> findAllCustomer();
	
	SeatModel update(SeatModel updateSeat);
	
	SeatModel updateSeatStatus(SeatModel updateSeat);
	
	List<SeatModel> findAllStatus();
	
	SeatModel updateSeat(SeatModel updateSeat);
}
