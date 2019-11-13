package edu.sgu.bookingsystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import java.sql.CallableStatement;
import edu.sgu.bookingsystem.connect.JDBCConnection;
import edu.sgu.bookingsystem.dao.BookingTicketDAO;

import edu.sgu.bookingsystem.model.Seat;
import edu.sgu.bookingsystem.model.Ticket;
import edu.sgu.bookingsystem.service.BookingTicketService;
import edu.sgu.bookingsystem.service.impl.BookingTicketServiceImpl;


public class BookingTicketDAOImpl implements BookingTicketDAO {


	private PreparedStatement stmt = null;
	public BookingTicketDAOImpl() {
	}


	@Override
	public int cancelBooking(long bookingID) {
		//call sp_cancel_ticket(1)
		// TODO Auto-generated method stub
				try {
					Connection conn = JDBCConnection.getConnection();
					CallableStatement cs = conn.prepareCall("{CALL sp_cancel_ticket(?)}");
					cs.setLong(1, bookingID);
					cs.executeUpdate();

					return 1;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					e.getMessage();
					return 0;
				}
		
	}

	@Override
	public int insertBooking(Ticket ticket, String[] listSeatStringArr) {
		try(Connection conn =JDBCConnection.getConnection()){//conn=DBHelper.getConnection();
			
			try {
				CallableStatement cstmt = conn.prepareCall("{call sp_insert_booking_update_customer(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
				cstmt.setLong(1, ticket.getScheduleID());
				cstmt.setLong(2, ticket.getCusID());
				cstmt.setString(3, ticket.getBookingDate());
				cstmt.setString(4, ticket.getDateStart());
				cstmt.setInt(5, ticket.getStatus());
				cstmt.setString(6, ticket.getEmail());
				cstmt.setString(7, ticket.getFullName());
				cstmt.setString(8, ticket.getAddress());
				cstmt.setString(9, ticket.getPhone());
				
				cstmt.executeUpdate();
				
				cstmt = conn.prepareCall("{call spSelectBookingIDByBookingInfo(?, ?, ?, ?)}");
				cstmt.setLong(1, ticket.getScheduleID());
				cstmt.setLong(2, ticket.getCusID());
				cstmt.setString(3, ticket.getBookingDate());
				cstmt.setString(4, ticket.getDateStart());
				ResultSet rs = cstmt.executeQuery();

				long lastBookingID = 0;

				if (rs.next()) {
					lastBookingID = rs.getLong("BookingID");
				}

				System.out.println(lastBookingID);
				String sql = "INSERT INTO detail (`BookingID`, `Seat`, `status`) VALUES(?,?,?)";
				PreparedStatement stmt=conn.prepareStatement(sql);
				int size = listSeatStringArr.length;
				for (String string : listSeatStringArr)  {		
					cstmt = conn.prepareCall("{call spInsertDetail(?, ?, ?)}");
					stmt.setLong(1, lastBookingID);
					stmt.setInt(2, Integer.valueOf(string));
					
					stmt.setInt(3, 1);
					stmt.executeUpdate();
				}
				
				return 1;

				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
		}
		catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
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
			String sql="SELECT bt.TypeName, b.NumberPlate, b.SeatNum, s.Price, pS.PlaceName as 'StartPlace', pF.PlaceName as 'FinishPlace', bk.DateStart, s.TimeStart, bk.BookingID, bk.CusID, bk.Status, d.Seat from schedule s JOIN place pS ON (pS.PlaceID = s.StartPlace) JOIN place pF ON (pF.PlaceID = s.FinishPlace) JOIN bus b ON (b.BusID = s.BusID) JOIN bus_type bt ON (b.TypeID = bt.TypeID) JOIN booking bk ON (bk.ScheduleID = s.ScheduleID) JOIN detail d ON (d.BookingID = bk.BookingID) WHERE pS.PlaceID=? AND pF.PlaceID=? AND bk.DateStart = ? AND s.TimeStart=?";
			stmt = dbConnection.prepareStatement(sql);
			stmt.setLong(1, startPlace);
			stmt.setLong(2, finishPlace);
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
				ticket.setSeat(rs.getInt("d.Seat"));

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


	@Override
	public ArrayList<Ticket> getAllTicket(long id) {
		// TODO Auto-generated method stub
		try {
			ArrayList<Ticket> listTicket = new ArrayList<Ticket>();
			Connection conn = JDBCConnection.getConnection();
			CallableStatement cs = conn.prepareCall("{CALL show_booking_customer(?)}");
			cs.setLong(1, id);
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				Ticket tk = new Ticket();
				tk.setBookingID(rs.getLong("BookingID"));
				tk.setBookingDate(rs.getString("bk.BookingDate"));
				tk.setStartPlace(rs.getString("pS.PlaceName"));
				tk.setFinishPlace(rs.getString("pF.PlaceName"));
				tk.setDateStart(String.valueOf(rs.getDate("DateStart")));
				tk.setTimeStart(rs.getString("TimeStart"));
				tk.setStatus(rs.getInt("Status"));
				listTicket.add(tk);
			}
			return listTicket;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
			return null;
		}
	}

	@Override
	public ArrayList<Ticket> detailTicket(long idCus,long idBook) {
		ArrayList<Ticket> ticketList = new ArrayList<Ticket>();

		try {
			PreparedStatement stmt =null;
			Connection dbConnection = null;
			dbConnection = JDBCConnection.getConnection();
			String  sql="SELECT d.Seat,s.Price,b.NumberPlate, d.Status from schedule s JOIN bus b ON (b.BusID = s.BusID) JOIN booking bk ON (bk.ScheduleID = s.ScheduleID) JOIN detail d ON (d.BookingID = bk.BookingID) WHERE bk.BookingID=? AND bk.CusID =?";
			stmt = dbConnection.prepareStatement(sql);
			stmt.setLong(1, idBook);
			stmt.setLong(2, idCus);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Ticket tk = new Ticket();
				tk.setSeat(rs.getInt("d.Seat"));
				tk.setPrice(rs.getDouble("s.Price"));
				tk.setNumberPlate(rs.getString("b.NumberPlate"));
				tk.setStatus(rs.getInt("d.status"));
				ticketList.add(tk);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}

		return ticketList;
	}

	

//	public static void main(String[] args) {
//		String listSeatBooking = "7,6,5,14,10,9,13";
//		String[] listSeatStringArr = listSeatBooking.split(",");
//		BookingTicketDAO bk = new BookingTicketDAOImpl();
//		Ticket ticket = new Ticket();
//		ticket.setScheduleID(4);
//	    ticket.setCusID(11);
//	    ticket.setBookingDate(String.valueOf(LocalDateTime.now()));
//	    ticket.setDateStart("2019-11-13");
//	    ticket.setFullName("Lê văn tám");
//	    ticket.setEmail("huykgit98@gmail.com");
//	    ticket.setAddress("lank mark");
//	    ticket.setPhone("0387171717");
//	    ticket.setStatus(1);
//	    System.out.println(bk.insertBooking(ticket , listSeatStringArr));
////	    System.out.println(listSeatStringArr.length);
////		for (String string : listSeatStringArr) {
////			System.out.println(string);
////		}
//	}
//	public static void main(String[] args) {
//	BookingTicketDAO bkservice = new BookingTicketDAOImpl();
//	//List<Ticket> items=bkservice.detailTicket(41, 6);
////	System.out.println(items.size());
////	for(Ticket i:items){
////	//System.out.println(i.getStartPlace());
////	//System.out.println(i.getFinishPlace());
////	System.out.println(i.getNumberPlate());
////	System.out.println(i.getPrice());
////	System.out.println(i.getSeat());
////	System.out.println("");
////
////	}
////	bkservice.cancelBooking(2);
////(2,1,"2019-11-13","06:00:00")
//	List<Ticket> items = bkservice.getSeatsBySchedule(2,1,"2019-11-13","06:00:00");
//	for(Ticket i:items){
//	//System.out.println(i.getStartPlace());
//	//System.out.println(i.getFinishPlace());
////	System.out.println(i.getNumberPlate());
////	System.out.println(i.getPrice());
//	System.out.println(i.getSeat());
//	System.out.println("asd");
//
//	}
//	}
//	public static void main(String[] args) {
//		BookingTicketDAO bkservice = new BookingTicketDAOImpl();
//		System.out.println("a1sd");
////(1,7,"2019-11-15","20:00:00");
//		List<Ticket> items = bkservice.getSeatsBySchedule(1,7,"2019-11-20","20:30:00");
//		for(Ticket i:items){
//			//System.out.println(i.getDateStart());
//			//System.out.println(i.getStartPlace());
//			//System.out.println(i.getFinishPlaceID());
//
//		System.out.println(i.getSeat());
//		System.out.println("asd");
//
//		}
//	}
}
