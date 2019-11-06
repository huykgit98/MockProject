package edu.sgu.bookingsystem.service;

import java.util.HashSet;
import java.util.List;

import edu.sgu.bookingsystem.model.Schedule;

public interface ScheduleService {
	HashSet<Schedule> getFinishPlaceByStartPlace(String startPlace);

}
