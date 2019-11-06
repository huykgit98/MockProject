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

	private Connection dbConnection = null;
	private PreparedStatement stmt = null;
	public BookingTicketDAOImpl() {
		try {
			dbConnection = JDBCConnection.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("BookingTicketDAOImpl: Ket noi that bai!");
		}
	}

	@Override
	public List<BookingTicket> getTicketBookedAvailableByStartDate(LocalDate date, int page) {
		List<BookingTicket> BookingTicketList = new ArrayList<>();

		try {
			String sql="SELECT bb.BookingID, b.NumberPlate, cc.FullName, pS.PlaceName AS 'StartPlace', pF.PlaceName AS 'FinishPlace', bs.TimeStart" + 
					"FROM booking bb JOIN schedule bs ON (bb.ScheduleID = bs.ScheduleID AND bb.Status = 1)" + 
					"JOIN place pS ON (pS.PlaceID = bs.StartPlace) " + 
					"JOIN place pF ON (pF.PlaceID = bs.FinishPlace)" + 
					"JOIN customers cc ON (bb.CusID = cc.CusID) JOIN bus b ON (b.BusID = bs.BusID)" + 
					"WHERE bb.DateStart = '2019-10-22'";
			stmt = dbConnection.prepareStatement(sql);
			stmt.setString(1, String.valueOf(date));
			//stmt.setInt(2, page);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				BookingTicket bw = new BookingTicket(rs.getString("NumberPlate"), rs.getString("FullName"),
						rs.getString("StartPlace"), rs.getString("FinishPlace"), rs.getString("StartTime"),
						rs.getInt("Booking_ID"));
				//bw.setPageNumber(rs.getInt("PageNumber"));

				BookingTicketList.add(bw);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finallyFunction();
		}

		return BookingTicketList;
	}

	@Override
	public int cancelBooking(BookingTicket bookingTicket) {
		try {
			String sql="UPDATE Booking.Booking SET Status = 'False' WHERE Booking_ID = ?";
			stmt = dbConnection.prepareStatement(sql);
			stmt.setLong(1, bookingTicket.getBooking_ID());

			stmt.executeUpdate();

			return 1;

		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			finallyFunction();
		}

		return 0;
	}

	@Override
	public List<BookingTicket> getBookedByCusIDPage(int customer_ID, int page) {
		List<BookingTicket> bookingWebList = new ArrayList<>();

		try {
			String sql="";
			stmt = dbConnection.prepareStatement(sql);
			stmt.setInt(1, customer_ID);
			stmt.setInt(2, page);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				BookingTicket bw = new BookingTicket(rs.getLong("BookingID"), rs.getString("StartPlace"),
						rs.getString("FinishPlace"), rs.getString("TimeStart"), rs.getString("BookingDate"),
						rs.getString("Status"));
				//bw.setPageNumber(rs.getInt("PageNumber"));
				bookingWebList.add(bw);
			}

			for (int i = 0; i < bookingWebList.size(); i++) {
				String sql1="SELECT Seat FROM detail WHERE BookingID = ?";
				stmt = dbConnection.prepareStatement(sql1);
				stmt.setLong(1, bookingWebList.get(i).getBooking_ID());

				rs = stmt.executeQuery();

				while (rs.next()) {
					bookingWebList.get(i).getSeatList().add(rs.getInt("Seat"));
				}
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			finallyFunction();
		}

		return bookingWebList;
	}

	@Override
	public List<BookingTicket> searchBooking(String search, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking getBookingByDateStartScheduleSeat(Booking booking) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int insertBooking(Booking booking) {
		// TODO Auto-generated method stub
		return 0;
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
	public List<Ticket> getTicketInfo(String startPlace, String finishPlace, String dateStart, String timeStart) {
		List<Ticket> listTicket = new ArrayList<>();
		
		try {
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
				ticket.setTypeName(rs.getString("TypeName"));
				ticket.setSeatNum(rs.getInt("SeatNum"));
				ticket.setPrice(rs.getDouble("Price"));
				ticket.setStartPlace(rs.getString("StartPlace"));
				ticket.setFinishPlace(rs.getString("FinishPlace"));
				ticket.setDateStart(rs.getString("DateStart"));
				ticket.setTimeStart(rs.getString("TimeStart"));
				ticket.setBookingID(rs.getLong("BookingID"));
				ticket.setStatus(rs.getInt("Status"));
				ticket.setSeat(rs.getInt("Seat"));

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
	
//	public static void main(String[] args) {
//		BookingTicketDAO bkdao = new BookingTicketDAOImpl();
//		List<Ticket> items=bkdao.getTicketInfo("Sài Gòn", "Cà Mau", "2019-10-22", "20:00:00");
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
//
//	}

}
