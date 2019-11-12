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
			String sql="SELECT s.ScheduleID, s.Price,s.TimeStart, pF.PlaceID, pF.PlaceName as 'FinishPlace' from schedule s JOIN place pS ON (pS.PlaceID = s.StartPlace) JOIN place pF ON (pF.PlaceID = s.FinishPlace) WHERE pS.PlaceID=? and pF.PlaceID=?";
			stmt = dbConnection.prepareStatement(sql);
			stmt.setLong(1, startPlace);
			stmt.setLong(2, finishPlace);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Schedule schedule=new Schedule();
				schedule.setSchedule_ID(rs.getLong("ScheduleID"));
				//schedule.setFinishPlaceID(rs.getLong("PlaceID"));
				schedule.setPrice(rs.getDouble("Price"));
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
			String sql="SELECT s.Price, pF.PlaceID, pF.PlaceName as 'FinishPlace' from schedule s JOIN place pS ON (pS.PlaceID = s.StartPlace) JOIN place pF ON (pF.PlaceID = s.FinishPlace) WHERE pS.PlaceID=?";
			stmt = dbConnection.prepareStatement(sql);
			stmt.setLong(1, startPlace);
			

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Schedule schedule=new Schedule();
				schedule.setPrice(rs.getDouble("Price"));
				schedule.setFinishPlaceID(rs.getLong("PlaceID"));
				schedule.setFinishPlace(rs.getString("FinishPlace"));				
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
	public long getScheduleIDByStartPlaceFinishPlaceTimeStart(long startPlace, long finishPlace,
			String timeStart) {
		Schedule schedule = new Schedule();

		// select s.ScheduleID from schedule s WHERE s.StartPlace = 1 AND s.FinishPlace = 7 AND s.TimeStart = '20:00:00'
		try {
			Connection dbConnection = null;
			dbConnection = JDBCConnection.getConnection();

			String sql="select s.ScheduleID from schedule s WHERE s.StartPlace = ? AND s.FinishPlace = ? AND s.TimeStart = ?";
			stmt = dbConnection.prepareStatement(sql);
			stmt.setLong(1, startPlace);
			stmt.setLong(2, finishPlace);
			stmt.setString(3, timeStart);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				schedule.setSchedule_ID(rs.getLong("ScheduleID"));			
				}


			return schedule.getSchedule_ID();
		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			finallyFunction();
		}

		return schedule.getSchedule_ID();
	}
	

//	public static void main(String[] args) {
//		ScheduleDAO Scheduledao = new ScheduleDAOImpl();
//		
//		HashSet<Schedule> items=Scheduledao.getFinishPlaceByStartPlace(1);
////		for(Schedule i:items){
////			//System.out.println(i.getTimeStart());
////			System.out.println(i.getPrice());
////
////			System.out.println(i.getFinishPlace());
////		}
////		System.out.println("");
//
//		HashSet<Schedule> items1=Scheduledao.getTimeStartBySchedule(1,7);
//		for(Schedule i:items1){
//			System.out.println(i.getSchedule_ID());
//
//			System.out.println(i.getTimeStart());
//			//System.out.println(i.getFinishPlace());
//		}
//		System.out.println("");
//		
//	}
//	public static void main(String[] args) {
//		ScheduleDAO d = new ScheduleDAOImpl();
//		System.out.println(d.getScheduleIDByStartPlaceFinishPlaceTimeStart(1, 7, "21:00:00"));
//
//	}

}
