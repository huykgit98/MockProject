package edu.sgu.bookingsystem.service;

import java.util.List;

import edu.sgu.bookingsystem.model.Ticket;

public interface BookingTicketService {
	List<Ticket> getTicketInfo(String startPlace, String finishPlace, String dateStart, String timeStart);
	List<Ticket> getSeatsBySchedule(long startPlaceID, long finishPlaceID, String dateStart, String timeStart);

}
