package edu.sgu.bookingsystem.dao;

import java.util.List;

import edu.sgu.bookingsystem.model.Booking;
import edu.sgu.bookingsystem.model.Time;

public interface TimeDAO {
	List<Time> getTimeByPlaceDateAmount(Time time);
	Booking getBusTypeBookedSeatsByPlaceTimeDate(Time time);

}
