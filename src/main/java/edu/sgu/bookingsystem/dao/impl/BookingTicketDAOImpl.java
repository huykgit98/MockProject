package edu.sgu.bookingsystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import edu.sgu.bookingsystem.connect.JDBCConnection;
import edu.sgu.bookingsystem.dao.BookingTicketDAO;
import edu.sgu.bookingsystem.model.Booking;
import edu.sgu.bookingsystem.model.BookingTicket;
import edu.sgu.bookingsystem.model.Ticket;

public class BookingTicketDAOImpl implements BookingTicketDAO {


	private PreparedStatement stmt = null;
	public BookingTicketDAOImpl() {
	}


	@Override
	public int cancelBooking(Ticket ticket) {
		return 0;
		
	}

	@Override
	public int insertBooking(Ticket ticket) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	@Override
	public List<Ticket> getTicketInfo(String startPlace, String finishPlace, String dateStart, String timeStart) {
		List<Ticket> listTicket = new ArrayList<>();
		
		try {
			Connection dbConnection = null;
			dbConnection = JDBCConnection.getConnection();
			String sql="SELECT bt.TypeName, b.NumberPlate, b.SeatNum, s.Price, pS.PlaceName as 'StartPlace', pF.PlaceName as 'FinishPlace', bk.DateStart, s.TimeStart, bk.BookingID, bk.CusID, bk.Status, d.Seat " + 
					"from schedule s " + 
					"JOIN place pS ON (pS.PlaceID = s.StartPlace) " + 
					"JOIN place pF ON (pF.PlaceID = s.FinishPlace) " + 
					"JOIN bus b ON (b.BusID = s.BusID) " + 
					"JOIN bus_type bt ON (b.TypeID = bt.TypeID) " + 
					"JOIN booking bk ON (bk.ScheduleID = s.ScheduleID) " + 
					"JOIN detail d ON (d.BookingID = bk.BookingID) " + 
					"WHERE pS.PlaceName=? AND pF.PlaceName=? AND bk.Status = 1 AND bk.DateStart = ? AND s.TimeStart=? ";
			stmt = dbConnection.prepareStatement(sql);
			stmt.setString(1, startPlace);
			stmt.setString(2, finishPlace);
			stmt.setString(3, dateStart);
			stmt.setString(4, timeStart);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Ticket ticket=new Ticket();
//				ticket.setTypeName(rs.getString("TypeName"));
//				ticket.setSeatNum(rs.getInt("SeatNum"));
//				ticket.setPrice(rs.getDouble("Price"));
//				ticket.setStartPlace(rs.getString("StartPlace"));
//				ticket.setFinishPlace(rs.getString("FinishPlace"));
//				ticket.setDateStart(rs.getString("DateStart"));
//				ticket.setTimeStart(rs.getString("TimeStart"));
//				ticket.setBookingID(rs.getLong("BookingID"));
//				ticket.setStatus(rs.getInt("Status"));
				ticket.setSeat(rs.getString("Seat"));

				listTicket.add(ticket);			

			
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			finallyFunction();
		}

		return listTicket;
	}

	@Override
	public List<Ticket> getTicketBookedByCustomer(long customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> getSeatsBySchedule(long startPlace, long finishPlace, String dateStart, String timeStart) {
List<Ticket> listTicket = new ArrayList<>();
		
		try {
			Connection dbConnection = null;
			dbConnection = JDBCConnection.getConnection();
			String sql="SELECT bt.TypeName, b.NumberPlate, b.SeatNum, s.Price, pS.PlaceName as 'StartPlace', pF.PlaceName as 'FinishPlace', bk.DateStart, s.TimeStart, bk.BookingID, bk.CusID, bk.Status, d.Seat " + 
					"from schedule s " + 
					"JOIN place pS ON (pS.PlaceID = s.StartPlace) " + 
					"JOIN place pF ON (pF.PlaceID = s.FinishPlace) " + 
					"JOIN bus b ON (b.BusID = s.BusID) " + 
					"JOIN bus_type bt ON (b.TypeID = bt.TypeID) " + 
					"JOIN booking bk ON (bk.ScheduleID = s.ScheduleID) " + 
					"JOIN detail d ON (d.BookingID = bk.BookingID) " + 
					"WHERE pS.PlaceID=? AND pF.PlaceID=? AND bk.Status = 1 AND bk.DateStart = ? AND s.TimeStart=? ";
			stmt = dbConnection.prepareStatement(sql);
			stmt.setLong(1, startPlace);
			stmt.setLong(2, finishPlace);
			stmt.setString(3, dateStart);
			stmt.setString(4, timeStart);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Ticket ticket=new Ticket();
				ticket.setTypeName(rs.getString("TypeName"));
				ticket.setSeatNum(rs.getInt("SeatNum"));
				ticket.setPrice(rs.getDouble("Price"));
				ticket.setStartPlace(rs.getString("StartPlace"));
				ticket.setFinishPlace(rs.getString("FinishPlace"));
				ticket.setDateStart(rs.getString("DateStart"));
				ticket.setTimeStart(rs.getString("TimeStart"));
				ticket.setBookingID(rs.getLong("BookingID"));
				ticket.setStatus(rs.getInt("Status"));
				ticket.setSeat(rs.getString("Seat"));

				listTicket.add(ticket);			

			
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			finallyFunction();
		}

		return listTicket;
	}
	private void finallyFunction() {

		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} 
	}

	
	public static void main(String[] args) {
		BookingTicketDAO bkdao = new BookingTicketDAOImpl();
		List<Ticket> items=bkdao.getTicketInfo("Sài Gòn", "Cà Mau", "2019-10-22", "20:00:00");
//		System.out.println(items.size());
//		for(Ticket i:items){
//		System.out.println(i.getStartPlace());
//		System.out.println(i.getFinishPlace());
//		System.out.println(i.getDateStart());
//		System.out.println(i.getTimeStart());
//		System.out.println(i.getSeat());
//		System.out.println("");
//
//		}
		System.out.println("----");
		List<Ticket> items1=bkdao.getSeatsBySchedule(1, 7, "2019-11-11", "20:00:00");
		System.out.println(items1.size());
		for(Ticket i:items1){
		System.out.println(i.getSeat());
		System.out.println("");
	}
	}

}
