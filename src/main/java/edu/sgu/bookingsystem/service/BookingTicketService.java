package edu.sgu.bookingsystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.sgu.bookingsystem.model.Ticket;
import edu.sgu.bookingsystem.utils.MapSeat;
import edu.sgu.bookingsystem.model.Seat;

public interface BookingTicketService {
	List<Ticket> getTicketInfo(String startPlace, String finishPlace, String dateStart, String timeStart);
	List<Ticket> getSeatsBySchedule(long startPlaceID, long finishPlaceID, String dateStart, String timeStart);
	int insertTicket(Ticket ticket, String[] listSeatBooking);
	ArrayList<Ticket>  getAllTicket(long  id);
	ArrayList<Ticket> detailTicket(long idCus,long idBook);
	int cancelBooking(long bookingID);
	List<MapSeat> getSeatListBySchedule(long startPlaceID, long finishPlaceID, String dateStart, String timeStart);
	HashMap<String,String> getSeatListHashmapBySchedule(long startPlaceID, long finishPlaceID, String dateStart, String timeStart);

}
