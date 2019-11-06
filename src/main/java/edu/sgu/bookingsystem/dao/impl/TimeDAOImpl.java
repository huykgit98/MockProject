package edu.sgu.bookingsystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.sgu.bookingsystem.connect.JDBCConnection;
import edu.sgu.bookingsystem.dao.TimeDAO;
import edu.sgu.bookingsystem.model.Booking;
import edu.sgu.bookingsystem.model.Time;

public class TimeDAOImpl implements TimeDAO {
	private Connection dbConnection = null;
	private PreparedStatement stmt = null;
	public TimeDAOImpl() {
		try {
			dbConnection = JDBCConnection.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("TimeDAOImpl: Ket noi that bai!");
		}
	}
	
	@Override
	public List<Time> getTimeByPlaceDateAmount(Time time) {
		List<Time> timeList = new ArrayList<>();

		try {
			String sql="SELECT bs.ScheduleID AS 'Schedule_ID', bs.TimeStart, bt.TypeName" + 
					"	FROM bus b JOIN bus_type bt ON (b.TypeID = bt.TypeID)" + 
					"		JOIN schedule bs ON (b.BusID = bs.BusID)" + 
					"		LEFT JOIN booking bk ON (bs.ScheduleID = bk.ScheduleID  AND bk.DateStart =? AND bk.Status = 1)" + 
					"		LEFT JOIN detail bd ON (bk.BookingID = bd.BookingID)" + 
					"	WHERE b.Status = 1  AND bs.StartPlace = ? AND bs.FinishPlace = ?" + 
					"	GROUP BY bs.ScheduleID, bs.TimeStart, bt.TypeName, b.SeatNum" + 
					"	HAVING b.SeatNum - COUNT(bd.Seat)  > ?";
			stmt = dbConnection.prepareStatement(sql);
			stmt.setString(1, String.valueOf(time.getDateStart()));
			stmt.setLong(2, time.getStartPlace());
			stmt.setLong(3, time.getFinishPlace());
			stmt.setInt(4, time.getAmount());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Time timeResult = new Time(rs.getLong("Schedule_ID"), rs.getString("TypeName"), rs.getString("TimeStart"));
				timeList.add(timeResult);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finallyFunction();
		}

		return timeList;
	}

	//lấy danh sách ghế đã đặt của 1 xe buýt
	@Override
	public Booking getBusTypeBookedSeatsByPlaceTimeDate(Time time) {
		Booking booking = new Booking();

		try {
			String sql="SELECT bs.BusID, bd.Seat" + 
					"	FROM schedule bs LEFT JOIN booking bk ON (bs.ScheduleID = bk.ScheduleID   AND (bk.Status = 1) AND bk.DateStart = ?)" + 
					"		LEFT JOIN detail bd ON (bk.BookingID = bd.BookingID)" + 
					"	WHERE bs.ScheduleID = ?";
			stmt = dbConnection.prepareStatement(sql);
			stmt.setLong(1, time.getSchedule_ID());
			stmt.setString(2, String.valueOf(time.getDateStart()));


			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				booking.setBusType(rs.getString("BusID"));
				booking.getSeatList().add(rs.getInt("Seat"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finallyFunction();
		}

		return booking;

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
	
//	public static void main(String[] args) {
//		TimeDAO timeDAO = new TimeDAOImpl();
//		Time time = new Time();
//		time.setStartPlace(1);
//		time.setFinishPlace(7);
//		time.setDateStart(LocalDate.now());
//		time.setDateStart(LocalDate.now());
//		
//		time.setAmount(15);
//	List<Time> items=timeDAO.getTimeByPlaceDateAmount(time);
//		
//		System.out.println(items.size());
//		for(Time i:items){
//		System.out.println(i.getSchedule_ID());
//		System.out.println(i.getTimeStart());
//		System.out.println(i.getTypeBus());
//		}
//		
//		Booking bk = timeDAO.getBusTypeBookedSeatsByPlaceTimeDate(time);
//		System.out.println(bk.getBusType());
//		System.out.println(bk.getSeatList());
//
//	}


}
