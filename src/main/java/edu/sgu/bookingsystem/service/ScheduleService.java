package edu.sgu.bookingsystem.service;

import java.util.HashSet;
import java.util.List;

import edu.sgu.bookingsystem.model.Schedule;

public interface ScheduleService {
	HashSet<Schedule> getFinishPlaceByStartPlace(long startPlace);
	HashSet<Schedule> getTimeStartBySchedule(long startPlace, long finishPlace);
	long getScheduleIDByStartPlaceFinishPlaceTimeStart(long startPlace, long finishPlace, String timeStart);

	
}
