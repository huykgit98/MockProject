package edu.sgu.bookingsystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import edu.sgu.bookingsystem.connect.JDBCConnection;
import edu.sgu.bookingsystem.dao.ScheduleDAO;
import edu.sgu.bookingsystem.model.Schedule;
import edu.sgu.bookingsystem.model.Ticket;

public class ScheduleDAOImpl implements ScheduleDAO {
	private PreparedStatement stmt = null;
	public ScheduleDAOImpl() {
		
	}
//	@Override
//	public List<Schedule> getSchedule() {
//		List<Schedule> scheduleList = new ArrayList<Schedule>();
//
//		
//		try {
//			String sql=" SELECT bs.ScheduleID, bs.TimeStart, pS.PlaceName  AS 'StartPlace', pF.PlaceName  AS 'FinishPlace', b.NumberPlate, bbt.TypeName, bs.Price" + 
//					"	FROM schedule bs JOIN place pS ON (bs.StartPlace = pS.PlaceID)" + 
//					"		JOIN place pF ON (pF.PlaceID = bs.FinishPlace)" + 
//					"		JOIN bus b ON (b.BusID = bs.BusID)" + 
//					"		JOIN bus_type bbt ON (b.TypeID = bbt.TypeID)" + 
//					"	ORDER BY bs.TimeStart";
//			stmt = dbConnection.prepareStatement(sql);
//			ResultSet rs = stmt.executeQuery();
//
//			while (rs.next()) {
//
//				Schedule schedule = new Schedule(rs.getLong("ScheduleID"), rs.getDate("TimeStart"),
//						rs.getString("StartPlace"), rs.getString("FinishPlace"), rs.getString("NumberPlate"), rs.getString("TypeName"), rs.getDouble("Price"));
//				scheduleList.add(schedule);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			finallyFunction();
//		}
//
//		return scheduleList;
//	}
	private void finallyFunction() {

		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} 
	}
	@Override
	public HashSet<Schedule> getTimeStartBySchedule(long startPlace, long finishPlace) {
		HashSet<Schedule> listTimeStart = new HashSet<Schedule>();
		  
		try {
			Connection dbConnection = null;
			dbConnection = JDBCConnection.getConnection();
			String sql="SELECT s.TimeStart, pF.PlaceID, pF.PlaceName as 'FinishPlace' from schedule s JOIN place pS ON (pS.PlaceID = s.StartPlace) JOIN place pF ON (pF.PlaceID = s.FinishPlace) WHERE pS.PlaceID=? and pF.PlaceID=?";
			stmt = dbConnection.prepareStatement(sql);
			stmt.setLong(1, startPlace);
			stmt.setLong(2, finishPlace);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Schedule schedule=new Schedule();
				//schedule.setFinishPlaceID(rs.getLong("PlaceID"));
				//schedule.setFinishPlace(rs.getString("FinishPlace"));
				schedule.setTimeStart(rs.getString("TimeStart"));
				
				listTimeStart.add(schedule);			

			
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			finallyFunction();
		}

		return listTimeStart;
	}
	@Override
	public HashSet<Schedule> getFinishPlaceByStartPlace(long startPlace) {
		HashSet<Schedule> listSchedule = new HashSet<Schedule>();
		  
		try {
			Connection dbConnection = null;
			dbConnection = JDBCConnection.getConnection();
			String sql="SELECT s.TimeStart, pF.PlaceID, pF.PlaceName as 'FinishPlace' from schedule s JOIN place pS ON (pS.PlaceID = s.StartPlace) JOIN place pF ON (pF.PlaceID = s.FinishPlace) WHERE pS.PlaceID=?";
			stmt = dbConnection.prepareStatement(sql);
			stmt.setLong(1, startPlace);
			

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Schedule schedule=new Schedule();
				schedule.setFinishPlaceID(rs.getLong("PlaceID"));
				schedule.setFinishPlace(rs.getString("FinishPlace"));
				schedule.setTimeStart(rs.getString("TimeStart"));
				
				listSchedule.add(schedule);			

			
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			finallyFunction();
		}

		return listSchedule;
	}
	
	@Override
	public List<Schedule> getSchedule() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public static void main(String[] args) {
//		ScheduleDAO Scheduledao = new ScheduleDAOImpl();
//		
//		HashSet<Schedule> items=Scheduledao.getFinishPlaceByStartPlace(1);
//		for(Schedule i:items){
//			//System.out.println(i.getTimeStart());
//			System.out.println(i.getFinishPlace());
//		}
//		System.out.println("");
//
//		HashSet<Schedule> items1=Scheduledao.getTimeStartBySchedule(1,7);
//		for(Schedule i:items1){
//			System.out.println(i.getTimeStart());
//			//System.out.println(i.getFinishPlace());
//		}
//		System.out.println("");
//		
//	}
	
		
//	public static void main(String args[]){  
//		  //Creating HashSet and adding elements  
//		  HashSet<String> set=new HashSet<String>();  
//		  set.add("Ravi");  
//		  set.add("Vijay");  
//		  set.add("Ravi");  
//		  set.add("Ajay");  
//		  
//			for(String i:set){
//			
//			System.out.println(i);
//			}
//		 }  
}
