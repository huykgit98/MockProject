package edu.sgu.bookingsystem.dao.impl;

import java.time.LocalDate;
import java.util.List;

import edu.sgu.bookingsystem.dao.BookingTicketDAO;
import edu.sgu.bookingsystem.model.Booking;

public class BookingTicketDAOImpl implements BookingTicketDAO {

	@Override
	public int insertBooking(Booking booking) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Booking> getTicketBookedAvailableByStartDate(LocalDate date, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cancelBooking(Booking bookingWeb) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Booking> getBookedByCusIDPage(int customer_ID, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> searchBooking(String search, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking getBookingByDateStartScheduleSeat(Booking booking) {
		// TODO Auto-generated method stub
		return null;
	}

}
