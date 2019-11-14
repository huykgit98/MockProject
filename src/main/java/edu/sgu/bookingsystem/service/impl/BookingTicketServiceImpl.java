package edu.sgu.bookingsystem.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

import edu.sgu.bookingsystem.dao.BookingTicketDAO;
import edu.sgu.bookingsystem.dao.impl.BookingTicketDAOImpl;
import edu.sgu.bookingsystem.model.Seat;
import edu.sgu.bookingsystem.model.Ticket;
import edu.sgu.bookingsystem.service.BookingTicketService;
import edu.sgu.bookingsystem.utils.MapSeat;

public class BookingTicketServiceImpl implements BookingTicketService {
	BookingTicketDAO bookingticketdao = new BookingTicketDAOImpl();
	
	@Override
	public List<Ticket> getTicketInfo(String startPlace, String finishPlace, String dateStart, String timeStart) {
		List<Ticket> list = new ArrayList<Ticket>();
		list=bookingticketdao.getTicketInfo(startPlace, finishPlace, dateStart, timeStart);
		return list;
	}

	@Override
	public List<Ticket> getSeatsBySchedule(long startPlaceID, long finishPlaceID, String dateStart, String timeStart) {
		List<Ticket> list = new ArrayList<Ticket>();
		list=bookingticketdao.getSeatsBySchedule(startPlaceID, finishPlaceID, dateStart, timeStart);
		
		return list;
	}

	@Override
	public List<MapSeat> getSeatListBySchedule(long startPlaceID, long finishPlaceID, String dateStart,
			String timeStart) {
		MapSeat mapSeat;
		List<Ticket> list = new ArrayList<Ticket>();
		List<MapSeat> listStringSeat = new ArrayList<MapSeat>();
		List<Integer> listIntSeat = new ArrayList<Integer>();
		list=bookingticketdao.getSeatsBySchedule(startPlaceID, finishPlaceID, dateStart, timeStart);
		for(Ticket i:list){

			listIntSeat.add(i.getSeat());
		}

		Hashtable<Integer, String> source = new Hashtable<Integer,String>();
		HashMap<Integer, String>  map = new HashMap(source);
		
		map.put(1, "1_1");
		map.put(2, "1_2");
		map.put(3, "1_4");
		map.put(4, "1_5");
		map.put(5, "2_1");
		map.put(6, "2_2");
		map.put(7, "2_4");
		map.put(8, "2_5");
		map.put(9, "3_1");
		map.put(10, "3_2");
		map.put(11, "3_4");
		map.put(12, "3_5");
		map.put(13, "4_1");
		map.put(14, "4_2");
		map.put(15, "4_4");
		map.put(16, "4_5");
		map.put(17, "5_1");
		map.put(18, "5_2");
		map.put(19, "5_3");
		map.put(20, "5_4");
		map.put(21, "5_5");
		for (Integer i : listIntSeat) { 
			//System.out.println(i);
		    if (map.containsKey(i)) {
		    	listStringSeat.add(new MapSeat(map.get(i)));
		    }
		    
			}
		return listStringSeat;
	}

	@Override
	public HashMap<String, String> getSeatListHashmapBySchedule(long startPlaceID, long finishPlaceID, String dateStart,
			String timeStart) {
		List<Ticket> list = new ArrayList<Ticket>();
		Hashtable<String, String> source1 = new Hashtable<String,String>();
		HashMap<String, String>  mapSeat = new HashMap(source1);
		List<Integer> listIntSeat = new ArrayList<Integer>();
		list=bookingticketdao.getSeatsBySchedule(startPlaceID, finishPlaceID, dateStart, timeStart);
		for(Ticket i:list){

			listIntSeat.add(i.getSeat());
		}

		Hashtable<Integer, String> source = new Hashtable<Integer,String>();
		HashMap<Integer, String>  map = new HashMap(source);
		
		map.put(1, "1_1");
		map.put(2, "1_2");
		map.put(3, "1_4");
		map.put(4, "1_5");
		map.put(5, "2_1");
		map.put(6, "2_2");
		map.put(7, "2_4");
		map.put(8, "2_5");
		map.put(9, "3_1");
		map.put(10, "3_2");
		map.put(11, "3_4");
		map.put(12, "3_5");
		map.put(13, "4_1");
		map.put(14, "4_2");
		map.put(15, "4_4");
		map.put(16, "4_5");
		map.put(17, "5_1");
		map.put(18, "5_2");
		map.put(19, "5_3");
		map.put(20, "5_4");
		map.put(21, "5_5");
		for (Integer i : listIntSeat) { 
			//System.out.println(i);
		    if (map.containsKey(i)) {
		    	mapSeat.put(map.get(i),"seat");
		    }
		    
			}
		return mapSeat;
	}
	
	@Override
	public int insertTicket(Ticket ticket, String[] listSeatStringArr) {
		return bookingticketdao.insertBooking(ticket, listSeatStringArr);
	}

	@Override
	public ArrayList<Ticket> getAllTicket(long id) {
		ArrayList<Ticket> listTicket= new ArrayList<Ticket>();
		listTicket = bookingticketdao.getAllTicket(id);
		return listTicket;
	}

	@Override
	public ArrayList<Ticket> detailTicket(long idCus, long idBook) {
		ArrayList<Ticket> listTicket= new ArrayList<Ticket>();
		listTicket = bookingticketdao.detailTicket(idCus, idBook);
		return listTicket;
	}
	@Override
	public int cancelBooking(long bookingID) {
		return bookingticketdao.cancelBooking(bookingID);

	}


	
	public static void main(String[] args) {
	BookingTicketService bkservice = new BookingTicketServiceImpl();
	List<Ticket> items=bkservice.getSeatsBySchedule(1,7,"2019-11-20","20:30:00");
	List<MapSeat> items1=bkservice.getSeatListBySchedule(1,7,"2019-11-20","20:30:00");
	HashMap<String,String> items2=bkservice.getSeatListHashmapBySchedule(1,7,"2019-11-20","20:30:00");
//	for (String key : items2.keySet()) {
//	    System.out.println("key: " + key + " value: " + items2.get(key));
//	}
	for (MapSeat i : items1) { 
		System.out.println(i.getSeat());

	    
		}
	
		
	
	
	}



	
}
