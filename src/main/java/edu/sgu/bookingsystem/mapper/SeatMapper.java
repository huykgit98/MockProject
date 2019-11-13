package edu.sgu.bookingsystem.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import edu.sgu.bookingsystem.model.SeatModel;
import edu.sgu.bookingsystem.model.TicketModel;

public class SeatMapper implements RowMapper<SeatModel>{

	@Override
	public SeatModel mapRow(ResultSet rs) {
		SeatModel seat = new SeatModel();
		try {
			seat.setSeatList(rs.getInt("Seat"));
			seat.getBus().setNumberPlate(rs.getString("NumberPlate"));
			seat.getSchedule().setTimeStart(rs.getString("TimeStart"));
			seat.setStartPlace(rs.getString("PlaceStart"));
			seat.setFinishPlace(rs.getString("PlaceFinish"));
			seat.getSchedule().setPrice(rs.getDouble("Price"));
			seat.getBooking().setDateStart(rs.getDate("DateStart"));
			seat.getBooking().setDescription(rs.getString("Description"));
			seat.getBus().setId(rs.getLong("BusID"));
			seat.getBusType().setTypeName(rs.getString("TypeName"));
			seat.setScheduleID(rs.getLong("ScheduleID"));
			
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return seat;
	}

}
