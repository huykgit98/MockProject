	package edu.sgu.bookingsystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.sgu.bookingsystem.connect.JDBCConnection;
import edu.sgu.bookingsystem.dao.SeatDAO;
import edu.sgu.bookingsystem.mapper.SeatMapper;
import edu.sgu.bookingsystem.mapper.TicketMapper;
import edu.sgu.bookingsystem.model.SeatModel;
import edu.sgu.bookingsystem.model.TicketModel;
import edu.sgu.bookingsystem.paging.Pageble;

public class SeatDAOImpl extends AbstractDAO<SeatModel> implements SeatDAO{

	public static void main(String[] args)
	{
		/* -- search
		SeatDAO seat = new SeatDAOImpl();
		short id =444;
		String s="a";
		List<SeatModel> items =seat.findByText(id);
		System.out.println("tong so dong:"+ items.size());
		for(SeatModel i: items) {
			System.out.println(i.getSeatList());	
			System.out.println(i.getSchedule().getPrice());
		} 
		 --findAllCustomer
		SeatDAO seat = new SeatDAOImpl();
		List<SeatModel> items =seat.findAllCustomer();
		System.out.println("tong so dong:"+ items.size());
		for(SeatModel i: items) {
			System.out.println(i.getCustomer().getFullName());	
		}
		--update
		SeatModel seatup = new SeatModel(1L,2);
		seat.update(seatup); 
		
		--updateSeatStatus*/
//		SeatDAO seat = new SeatDAOImpl();
//		SeatModel seatup = new SeatModel(2 , 11 , 24);
//		seat.updateSeatStatus(seatup); 
	}
	
	@Override
	public List<SeatModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder(" Select detail.Seat, bus.NumberPlate, schedule.TimeStart, Sp.PlaceName as PlaceStart, Fp.PlaceName as PlaceFinish, ");
		sql.append(" schedule.Price, booking.DateStart, booking.Description, bus.BusID, bus_type.TypeName");
		sql.append(" From  booking,detail,schedule, bus, bus_type, place Sp, place Fp ");
		sql.append(" where booking.BookingID = detail.BookingID AND booking.ScheduleID = schedule.ScheduleID ");
		sql.append("  AND bus_type.TypeID = bus.TypeID AND bus.BusID = schedule.BusID AND Sp.PlaceID = schedule.StartPlace  ");
		sql.append(" AND Fp.PlaceID = schedule.FinishPlace AND detail.status = 0 ");
		if (pageble.getSorter() != null ) //if (sortName != null && sortBy != null)
		{
			sql.append(" ORDER BY "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+" ");
			//sql.append(" ORDER BY "+sortName+" "+sortBy+" ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) //if (offset != null && limit != null) - neu page can hien thi du lieu trong 2 trang, thi moi ton tai offset vs limit
		{
			sql.append("LIMIT "+pageble.getOffset()+" , "+pageble.getLimit()+" ");
			//sql.append("LIMIT "+offset+" , "+limit+" ");
		}
		return query(sql.toString(), new SeatMapper());
	}

	@Override
	public int getTotalItem() {
		String sql="SELECT count(Seat) FROM detail";
		return count(sql);
	}


	@Override
	public <T> List<SeatModel> findByText(T text) {
		StringBuilder sb = new StringBuilder();
		sb.append(" Select detail.Seat, schedule.BusID, schedule.TimeStart, schedule.StartPlace, schedule.FinishPlace,  ");
		sb.append(" schedule.Price, booking.DateStart, booking.Description, place.PlaceName ");
		sb.append(" From  booking, place,detail,schedule  ");
		sb.append(" where booking.BookingID = detail.BookingID  AND booking.ScheduleID = schedule.ScheduleID  AND place.PlaceID = schedule.StartPlace AND booking.Status = 0 ");
		sb.append(" AND (detail.Seat = " + text + "  or schedule.BusID  = " + text + " or schedule.TimeStart like '%"+ text +"%'  ");
		sb.append(" or  schedule.StartPlace like '%\"+ text +\"%' or  schedule.FinishPlace like '%\"+ text +\"%' or ");
		sb.append(" schedule.Price like '%"+ text +"%' or booking.DateStart like '%"+ text +"%' or booking.Description like '%"+ text +"%' or place.PlaceName  like '%"+ text +"%') ");
		SeatMapper mapper = new SeatMapper();
		return query(sb.toString(), mapper);
		/*
		List<SeatModel> listOfSeat = new ArrayList<>();
		Connection conn = JDBCConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sb.toString());
			//......
		} catch (SQLException e) {
			e.printStackTrace();
			}finally {
			try {
			if (conn != null)  conn.close(); 
			if (pst != null)   pst.close();
			if (rs != null)    rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}	
			}
		return listOfSeat; */
	}

	@Override
	public SeatModel findOne(long id) {
		StringBuilder sql = new StringBuilder("Select detail.Seat, schedule.BusID, schedule.TimeStart, schedule.StartPlace, schedule.FinishPlace,");
		sql.append(" schedule.Price, booking.DateStart, booking.Description, place.PlaceName ");
		sql.append(" From  booking, place,detail,schedule ");
		sql.append(" where booking.BookingID = detail.BookingID AND booking.ScheduleID = schedule.ScheduleID  AND place.PlaceID = schedule.StartPlace ");
		sql.append(" AND booking.Status = 0 and detail.BookingID=?");
		List<SeatModel> seats = query(sql.toString(), new SeatMapper(), id);
		return seats.isEmpty() ? null : seats.get(0);
	}

	@Override
	public SeatModel findBySeat(long busId, int seat) {
		StringBuilder sql = new StringBuilder(" Select detail.Seat, bus.NumberPlate, schedule.TimeStart, Sp.PlaceName as PlaceStart, Fp.PlaceName as PlaceFinish,  ");
		sql.append(" schedule.Price, booking.DateStart, booking.Description, bus.BusID, bus_type.TypeName, ");
		sql.append(" schedule.ScheduleID ");
		sql.append(" From  booking,detail,schedule, bus, bus_type, place Sp, place Fp  ");
		sql.append(" where booking.BookingID = detail.BookingID AND booking.ScheduleID = schedule.ScheduleID  ");
		sql.append(" AND bus_type.TypeID = bus.TypeID AND bus.BusID = schedule.BusID AND Sp.PlaceID = schedule.StartPlace  ");
		sql.append(" AND Fp.PlaceID = schedule.FinishPlace AND detail.status = 0  AND bus.BusID = ? AND detail.seat =? ");
		List<SeatModel> seats = query(sql.toString(), new SeatMapper(), busId, seat);
		return seats.isEmpty() ? null : seats.get(0); 
	}

	@Override
	public List<SeatModel> findAllCustomer() {
		String sql =  "SELECT * FROM customers"; 
		
		List<SeatModel> listOfSeat = new ArrayList<SeatModel>();
		Connection conn = JDBCConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next())
			{
				SeatModel seat = new SeatModel();
				seat.getCustomer().setId(rs.getLong("CusID"));
				seat.getCustomer().setEmail(rs.getString("Email"));
				seat.getCustomer().setFullName(rs.getString("FullName"));
				seat.getCustomer().setAddress(rs.getString("Address"));
				seat.getCustomer().setPhone(rs.getString("Phone"));
				
				
//				seat.getBooking().setBookingID(rs.getLong("CusID"));
//				seat.getSchedule().setId(rs.getLong("ScheduleID"));
//				seat.getPlace().setId(rs.getLong("PlaceID"));
//				seat.getBus().setId(rs.getLong("BusID"));
//				seat.getBusType().setId(rs.getLong("TypeID"));
//				seat.setSeatList(rs.getInt("Seat"));
//				seat.setStartPlace(rs.getString("StartPlace"));
//				seat.setFinishPlace(rs.getString("FinishPlace"));
				listOfSeat.add(seat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (conn!=null) {
					conn.close(); }
				if (pst!=null) {
					pst.close();  }
				if (rs !=null) {
					rs.close();   }
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		 }
		
		return listOfSeat;
	}

	@Override
	public List<SeatModel> findBooking() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(SeatModel seatModel) {
		String sql = "UPDATE detail set status = 0 where BookingID= ?  AND Seat= ?";
		update(sql, seatModel.getBookingId(), seatModel.getSeatList());
	}

	@Override
	public void updateSeatStatus(SeatModel seatModel) {
		String sql="{CALL new_procedurev2( ? , ? , ? )}";
		update(sql,seatModel.getScheduleID() , seatModel.getCusID(), seatModel.getSeatList());
		
	}

	@Override
	public List<SeatModel> findAllStatus() {
		String sql=" select distinct (detail.status) from detail, booking where detail.BookingID = booking.BookingID";
		List<SeatModel> listStatus = new ArrayList<SeatModel>();
		Connection conn = JDBCConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst= conn.prepareStatement(sql);
			rs =pst.executeQuery();
			while(rs.next())
			{
				SeatModel seat = new SeatModel();
				seat.getBooking().setStatus(rs.getInt("status"));
				listStatus.add(seat);
			}	
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (conn!=null) {
					conn.close(); }
				if (pst!=null) {
					pst.close();  }
				if (rs !=null) {
					rs.close();   }
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		 }
		
		return listStatus;
	}

	@Override
	public void updateSeat(SeatModel seatModel) {
		String sql = "{CALL updateSeat(?,?,?)}"; //status - bookingid - seat
		update(sql, seatModel.getSeatStatus(), seatModel.getBookingId(), seatModel.getSeatList());
	}

	
}
