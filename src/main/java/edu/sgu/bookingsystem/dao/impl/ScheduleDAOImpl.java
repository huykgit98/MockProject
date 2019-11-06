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
	private Connection dbConnection = null;
	private PreparedStatement stmt = null;
	public ScheduleDAOImpl() {
		try {
			dbConnection = JDBCConnection.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ScheduleDAOImpl: Ket noi that bai!");
		}
	}
	@Override
	public List<Schedule> getSchedule() {
		List<Schedule> scheduleList = new ArrayList<Schedule>();

		
		try {
			String sql=" SELECT bs.ScheduleID, bs.TimeStart, pS.PlaceName  AS 'StartPlace', pF.PlaceName  AS 'FinishPlace', b.NumberPlate, bbt.TypeName, bs.Price" + 
					"	FROM schedule bs JOIN place pS ON (bs.StartPlace = pS.PlaceID)" + 
					"		JOIN place pF ON (pF.PlaceID = bs.FinishPlace)" + 
					"		JOIN bus b ON (b.BusID = bs.BusID)" + 
					"		JOIN bus_type bbt ON (b.TypeID = bbt.TypeID)" + 
					"	ORDER BY bs.TimeStart";
			stmt = dbConnection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Schedule schedule = new Schedule(rs.getLong("ScheduleID"), rs.getDate("TimeStart"),
						rs.getString("StartPlace"), rs.getString("FinishPlace"), rs.getString("NumberPlate"), rs.getString("TypeName"), rs.getDouble("Price"));
				scheduleList.add(schedule);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finallyFunction();
		}

		return scheduleList;
	}
	private void finallyFunction() {

		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (dbConnection != null)
					dbConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	@Override
	public HashSet<Schedule> getFinishPlaceByStartPlace(String startPlace) {
		HashSet<Schedule> listSchedule = new HashSet<Schedule>();
		  
		try {
			String sql="SELECT pF.PlaceName as 'FinishPlace' from schedule s JOIN place pS ON (pS.PlaceID = s.StartPlace) JOIN place pF ON (pF.PlaceID = s.FinishPlace) WHERE pS.PlaceName=?";
			stmt = dbConnection.prepareStatement(sql);
			stmt.setString(1, startPlace);


			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Schedule schedule=new Schedule();
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
	
//	public static void main(String[] args) {
//		ScheduleDAO Scheduledao = new ScheduleDAOImpl();
//		
//		HashSet<Schedule> items=Scheduledao.getFinishPlaceByStartPlace("Sài Gòn");
//		for(Schedule i:items){
//		
//		System.out.println(i.getFinishPlace());
//		}
//		System.out.println("");
//
//		
//	}
//	
		
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
