package edu.sgu.bookingsystem.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.sgu.bookingsystem.connect.JDBCConnection;
import edu.sgu.bookingsystem.dao.BookedTicketDao;
import edu.sgu.bookingsystem.model.Ticket;

public class BookedTicketDAOImpl implements BookedTicketDao {

	@Override
	public ArrayList<Ticket> getAllTicket(long id) {
		// TODO Auto-generated method stub
		try {
			Ticket tk = new Ticket();
			ArrayList<Ticket> listTicket = new ArrayList<Ticket>();
			Connection conn = JDBCConnection.getConnection();
			CallableStatement cs = conn.prepareCall("{CALL show_booking_customer(?)}");
			cs.setLong(1, id);
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				tk.setBookingID(rs.getLong("BookingID"));
				tk.setStartPlace(rs.getString("pS.PlaceName"));
				tk.setFinishPlace(rs.getString("pF.PlaceName"));
				tk.setDateStart(String.valueOf(rs.getDate("DateStart")));
				tk.setTimeStart(String.valueOf(rs.getDate("TimeStart")));
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
	public ArrayList<Ticket> detailTicket() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket getIdBooking(long idCus,long idBook) {
		// TODO Auto-generated method stub
		Connection conn;
		Ticket tk = null;
		try {
			tk = new Ticket();
			conn = JDBCConnection.getConnection();
			String  sql="SELECT d.Seat,s.Price,b.NumberPlate from schedule s  JOIN bus b ON (b.BusID = s.BusID)  JOIN booking bk ON (bk.ScheduleID = s.ScheduleID) JOIN detail d ON (d.BookingID = bk.BookingID)"
					+"WHERE bk.BookingID='"+idCus+"' AND  bk.CusID ='"+idBook+"';";
		////	CallableStatement cs = conn.prepareCall("{CALL get_id_history_detail_customer(?,?)}");
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tk.setSeat(rs.getInt("d.Seat"));
				tk.setPrice(rs.getDouble("s.Price"));
				tk.setNumberPlate(rs.getString("b.NumberPlate"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		System.out.println(tk.toString());
		return tk;
	}

}
