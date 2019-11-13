package edu.sgu.bookingsystem.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.sgu.bookingsystem.model.TicketModel;

public class TicketMapper implements RowMapper<TicketModel>{

	@Override
	public TicketModel mapRow(ResultSet rs) {
		TicketModel ticket =  new TicketModel();
		try {
//			ticket.setBookingID(rs.getInt("BookingID"));
//			ticket.setSeatList(rs.getInt("Seat"));
//			ticket.setBookingDate(rs.getDate("BookingDate"));
//			ticket.setDateStart(rs.getDate("DateStart"));
//			ticket.setFullName(rs.getString("FullName"));
//			ticket.setBusID(rs.getLong("BusID"));
//			ticket.setTimeStart(rs.getDate("TimeStart"));
//			ticket.setStartPlace(rs.getLong("StartPlace"));
//			ticket.setFinishPlace(rs.getLong("FinishPlace"));
//			ticket.setPrice(rs.getDouble("Price"));
			
			
			ticket.getBooking().setBookingID(rs.getInt("BookingID"));
			ticket.setSeatList(rs.getInt("Seat"));
			ticket.getBooking().setBookingDate(rs.getDate("BookingDate"));
			ticket.getBooking().setDateStart(rs.getDate("DateStart"));
			ticket.getCustomer().setFullName(rs.getString("FullName"));
			ticket.getCustomer().setEmail(rs.getString("Email"));
			ticket.getCustomer().setAddress(rs.getString("Address"));
			ticket.getCustomer().setPhone(rs.getString("Phone"));
			ticket.getSchedule().setId(rs.getLong("BusID"));
			ticket.getBus().setNumberPlate(rs.getString("NumberPlate"));
			ticket.getSchedule().setTimeStart(rs.getString("TimeStart"));
			ticket.setStartPlace(rs.getString("PlaceStart"));
			ticket.setFinishPlace(rs.getString("PlaceFinish"));
			ticket.getSchedule().setPrice(rs.getDouble("Price"));
			ticket.getSchedule().setId(rs.getLong("BusID"));


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ticket;
	}

}
