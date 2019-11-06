package edu.sgu.bookingsystem.dao;

import java.util.HashSet;
import java.util.List;

import edu.sgu.bookingsystem.model.Schedule;

public interface ScheduleDAO {
	List<Schedule> getSchedule();
	HashSet<Schedule> getFinishPlaceByStartPlace(String startPlace);
}
