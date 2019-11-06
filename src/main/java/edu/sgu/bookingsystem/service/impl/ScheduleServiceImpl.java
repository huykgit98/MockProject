package edu.sgu.bookingsystem.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import edu.sgu.bookingsystem.dao.ScheduleDAO;
import edu.sgu.bookingsystem.dao.impl.ScheduleDAOImpl;
import edu.sgu.bookingsystem.model.Schedule;
import edu.sgu.bookingsystem.model.Ticket;
import edu.sgu.bookingsystem.service.ScheduleService;


public class ScheduleServiceImpl implements ScheduleService {
	ScheduleDAO scheduledao = new ScheduleDAOImpl();

	@Override
	public HashSet<Schedule> getFinishPlaceByStartPlace(String startPlace) {
		HashSet<Schedule> list = new HashSet<Schedule>();
		list=scheduledao.getFinishPlaceByStartPlace(startPlace);
		return list;
	}
//	public static void main(String[] args) {
//		ScheduleService Scheduledao = new ScheduleServiceImpl();
//	
//		HashSet<Schedule> items=Scheduledao.getFinishPlaceByStartPlace("S�i G�n");;
//	System.out.println(items.size());
//	for(Schedule i:items){
//	
//	System.out.println(i.getFinishPlace());
//	}
//	
//	}
}
