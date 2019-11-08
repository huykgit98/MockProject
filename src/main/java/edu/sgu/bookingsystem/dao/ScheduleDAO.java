package edu.sgu.bookingsystem.dao;

import java.util.HashSet;
import java.util.List;

import edu.sgu.bookingsystem.model.Schedule;
import edu.sgu.bookingsystem.model.Ticket;

public interface ScheduleDAO {
	List<Schedule> getSchedule();
	HashSet<Schedule> getFinishPlaceByStartPlace(long startPlace);
	HashSet<Schedule> getTimeStartBySchedule(long startPlace, long finishPlace);
	
}
