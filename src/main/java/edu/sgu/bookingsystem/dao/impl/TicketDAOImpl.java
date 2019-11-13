package edu.sgu.bookingsystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import edu.sgu.bookingsystem.connect.JDBCConnection;
import edu.sgu.bookingsystem.dao.TicketDAO;
import edu.sgu.bookingsystem.mapper.SeatMapper;
import edu.sgu.bookingsystem.mapper.TicketMapper;
import edu.sgu.bookingsystem.model.SeatModel;
import edu.sgu.bookingsystem.model.TicketModel;
import edu.sgu.bookingsystem.paging.Pageble;

public class TicketDAOImpl extends AbstractDAO<TicketModel> implements TicketDAO{
	
	public static void main(String[] args){
		/*-- test findSeatByBookingId
			TicketDAO ticketdao = new TicketDAOImpl();
			int bookingId=3;
			List<TicketModel> items =ticketdao.findSeatByBookingId(bookingId);
			System.out.println("tong so dong:"+ items.size());
			for(TicketModel i: items) {
				System.out.println(i.getFullName());			
			}  */
		
		/* -- test findOne(
		TicketDAO ticketdao = new TicketDAOImpl();
		int bookingId=3;
		System.out.println(ticketdao.findOne(bookingId).getBookingID());
		System.out.println(ticketdao.findOne(bookingId).getPrice()); */
		
		/*test findSeatByBookingId
		TicketDAO ticketdao = new TicketDAOImpl();
		int bookingId=2;
		List<TicketModel> items =ticketdao.findSeatByBookingId(bookingId);
		System.out.println("tong so dong:"+ items.size());
		for(TicketModel i: items) {
			System.out.println(i.getFullName());	
			System.out.println(i.getCustomer().getAddress());
		} */
		
		/* --findByBookingId
		TicketDAO ticketdao = new TicketDAOImpl();
		TicketModel items =ticketdao.findByBookingId(2, 56);
			System.out.println(items.getFullName());	
			System.out.println(items.getCustomer().getAddress());
			System.out.println(items.getAddress());
			System.out.println(items.getCustomer().getFullName());
			System.out.println(items.getCustomer().getPassword());
			System.out.println(items.getBooking().getBookingDate());
			System.out.println(items.getCustomer().getEmail()); */
		
		/* - test ham save()
		TicketDAO ticketdao = new TicketDAOImpl();
		TicketModel ticketModel = new TicketModel();
		//schedule
		ticketModel.setBusID(2);
		ticketModel.setTimeStart(Date.valueOf("1998-01-04"));
		ticketModel.setStartPlace(1);
		ticketModel.setFinishPlace(3L);
		ticketModel.setPrice(100000D);
		//booking
		ticketModel.setCusId(3);
		ticketModel.setBookingDate(Date.valueOf("1998-01-04"));
		ticketModel.setDateStart(Date.valueOf("1998-01-04"));
		ticketModel.setDescription("hung");
		ticketModel.setStatus(false);
		ticketModel.setScheduleID(2L);
		//detail
		ticketModel.setBookingID(6);
		ticketModel.setSeatList(95);	
		//customer
		String mail = "asrvs@gmail.com";
		ticketModel.setEmail(mail);
		ticketdao.save(ticketModel); */
		
	/* - test ham update()
		TicketDAO ticketdao = new TicketDAOImpl();
		TicketModel ticketModel = new TicketModel("OKK",81,1,32);
		ticketdao.updateTicket(ticketModel); 
		System.out.println("OK"); */
		/*	
		TicketDAO ticketdao = new TicketDAOImpl();
		System.out.println(ticketdao.findByBookingId(1, 1).getCustomer().getFullName()); */
		
		
		/* test findSeatByStatus
		TicketDAO ticketdao = new TicketDAOImpl();
		List<TicketModel> items =ticketdao.findSeatByStatus();
		System.out.println("tong so dong:"+ items.size());
		for(TicketModel i: items) {
			System.out.println(i.getSeatList());			
		}  */
	}
	
	@Override
	public List<TicketModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder(" select distinct( booking.BookingID), detail.Seat, booking.BookingDate, booking.DateStart, ");
		sql.append(" customers.FullName, customers.Email, customers.Address, customers.Phone, bus.NumberPlate,schedule.BusID ,schedule.TimeStart, placeStart.PlaceName as PlaceStart, ");
		sql.append(" placeFinish.PlaceName as PlaceFinish,  schedule.Price ");
		sql.append(" FROM schedule, booking, detail, customers, place placeStart, place placeFinish, bus");
		sql.append(" WHERE booking.ScheduleID = schedule.ScheduleID  AND booking.BookingID =detail.BookingID ");
		sql.append(" AND Booking.CusID = customers.CusID And detail.status =1 AND bus.BusID = schedule.BusID ");
		sql.append(" AND placeStart.PlaceID = schedule.StartPlace AND placeFinish.PlaceID = schedule.FinishPlace ");
		
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
			return query(sql.toString(), new TicketMapper()); 
		
		
	/*	List<TicketModel> listOfTicket = new ArrayList<TicketModel>();
		//khai bao SQL
		//String sql = "select detail.BookingID, detail.Seat, booking.BookingDate, booking.DateStart, customers.FullName,schedule.TimeStart,schedule.StartPlace, schedule.FinishPlace, schedule.Price from schedule, booking, detail, customers where booking.ScheduleID = schedule.ScheduleID AND booking.BookingID =detail.BookingID AND Booking.CusID = customers.CusID And booking.Status =1 LIMIT '"+offset+"' , '"+limit+"' ";
		String sql = "select detail.BookingID, detail.Seat, booking.BookingDate, booking.DateStart, customers.FullName,schedule.TimeStart,schedule.StartPlace, schedule.FinishPlace, schedule.Price from schedule, booking, detail, customers where booking.ScheduleID = schedule.ScheduleID AND booking.BookingID =detail.BookingID AND Booking.CusID = customers.CusID And booking.Status =0 LIMIT ? , ? ";	
		//open connection
				Connection conn = JDBCConnection.getConnection();
				PreparedStatement pst = null;
				ResultSet rs = null;
					try {
						pst = conn.prepareStatement(sql);
						pst.setInt(1, offset);
						pst.setInt(2, limit);
						//init parameter
						rs = pst.executeQuery();
						while(rs.next())
						{
							TicketModel ticket =  new TicketModel();
							ticket.setBookingID(rs.getInt("BookingID"));
							ticket.setSeatList(rs.getInt("Seat"));
							ticket.setBookingDate(rs.getDate("BookingDate"));
							ticket.setDateStart(rs.getDate("DateStart"));
							ticket.setFullName(rs.getString("FullName"));
							ticket.setTimeStart(rs.getDate("TimeStart"));
							ticket.setStartPlace(rs.getString("StartPlace"));
							ticket.setFinishPlace(rs.getString("FinishPlace"));
							ticket.setPrice(rs.getString("Price"));
							listOfTicket.add(ticket);	
						}
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
				return listOfTicket;  */
	}

	@Override
	public int getTotalItem() {
		String sql="SELECT count(BookingID) FROM booking";
		return count(sql);
	}

	@Override
	public List<TicketModel> findSeatByBookingId(long bookingId) {
		String sql="SELECT detail.BookingID, detail.Seat, booking.BookingDate, booking.DateStart, customers.FullName,schedule.BusID ,schedule.TimeStart,schedule.StartPlace, schedule.FinishPlace, schedule.Price FROM  schedule, booking, detail, customers  WHERE booking.ScheduleID = schedule.ScheduleID AND booking.BookingID =detail.BookingID AND Booking.CusID = customers.CusID And booking.Status =0 AND booking.BookingID=?";
		return query(sql, new TicketMapper(), bookingId);
		
		/*
		List<TicketModel> listOfSeat = new ArrayList<>();
		String sql="SELECT detail.Seat FROM  booking, detail  WHERE booking.BookingID =detail.BookingID AND booking.Status = 0 AND booking.BookingID=?";
		Connection conn = JDBCConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setLong(1, bookingId);
			rs = pst.executeQuery();
			while(rs.next())
			{
			TicketModel seat =  new TicketModel();
			seat.setBookingID(rs.getInt("Seat"));

			listOfSeat.add(seat);	
			}
						
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
	public TicketModel findOne(long id ) {
		String sql="select detail.BookingID, detail.Seat, booking.BookingDate, booking.DateStart, customers.FullName,schedule.BusID,schedule.TimeStart,schedule.StartPlace, schedule.FinishPlace, schedule.Price FROM schedule, booking, detail, customers WHERE booking.ScheduleID = schedule.ScheduleID AND booking.BookingID =detail.BookingID AND Booking.CusID = customers.CusID And booking.Status =0 AND detail.BookingID=? ";
		List<TicketModel> tickets = query(sql, new TicketMapper(), id);
		return tickets.isEmpty() ? null : tickets.get(0);
	}
	
	@Override
	public TicketModel findByBookingId(long bookingId, int seat) {
		StringBuilder sql = new StringBuilder(" select detail.BookingID, detail.Seat, booking.BookingDate, booking.DateStart, customers.FullName, customers.Email, customers.Address, customers.Phone, ");
		sql.append(" bus.NumberPlate, schedule.BusID, schedule.TimeStart,schedule.StartPlace, schedule.FinishPlace, schedule.Price ");
		sql.append("FROM schedule, booking, detail, customers,bus WHERE booking.ScheduleID = schedule.ScheduleID AND booking.BookingID =detail.BookingID ");
		sql.append(" AND Booking.CusID = customers.CusID And detail.status =1  AND bus.BusID = schedule.BusID AND detail.BookingID=? AND detail.Seat = ?");
		List<TicketModel> tickets = query(sql.toString(), new TicketMapper(), bookingId, seat);
		return tickets.isEmpty() ? null : tickets.get(0); 
	}

	
	@Override
	public Long save(TicketModel ticketModel) { // can id tra ve de hien thi thong bao them thanh cong
		String sqlcus = "INSERT INTO customers(CusID, Email) VALUES (?,?)";
		update(sqlcus,ticketModel.getCustomer().getId(), ticketModel.getCustomer().getEmail());
		
		String sqlsche = "INSERT INTO schedule(ScheduleID, BusID,TimeStart,StartPlace,FinishPlace,Price) VALUES (?,?,?,?,?,?)";
		update(sqlsche,ticketModel.getSchedule().getId(), ticketModel.getSchedule().getTimeStart(), ticketModel.getSchedule().getStartPlace(), ticketModel.getSchedule().getFinishPlace(), ticketModel.getSchedule().getPrice());
		
		 String sqlboo = "INSERT INTO booking(BookingID, ScheduleID, CusID, BookingDate, DateStart, Description, Status) VALUES (?,?,?,?,?,?,?)";
		 Long inse = insert(sqlboo, ticketModel.getBooking().getBookingID() ,ticketModel.getBooking().getSchedule().getId(), ticketModel.getBooking().getCustomer().getId(), ticketModel.getBooking().getBookingDate(), ticketModel.getBooking().getDateStart(), ticketModel.getBooking().getDescription(), ticketModel.getBooking().getStatus());
		
		String sqldetail = "INSERT INTO detail (BookingID, Seat) VALUES (?,?)"; 
		update(sqldetail, ticketModel.getBooking().getBookingID(), ticketModel.getBooking().getSeatList());
	
		return inse;
		
		/*
		ResultSet rs = null;
		Long id = null;
		Connection conn = null;
		PreparedStatement pst  = null;
		try {
			conn = JDBCConnection.getConnection();
			conn.setAutoCommit(false);
			
			String sqlsche = "INSERT INTO schedule(BusID,TimeStart,StartPlace,FinishPlace,Price) VALUES (?,?,?,?,?)";
			pst = conn.prepareStatement(sqlsche);
			pst.setLong(1,ticketModel.getBusID());
			pst.setDate(2, ticketModel.getTimeStart());
			pst.setLong(3, ticketModel.getStartPlace()); // dung
			pst.setLong(4, ticketModel.getFinishPlace()); // dung
			pst.setDouble(5, ticketModel.getPrice());
			pst.executeUpdate();
			System.out.println("scheduke OK");
			conn.commit(); 
			// 1
			
			//TicketID la BookingID
			String sqlboo = "INSERT INTO booking(ScheduleID, CusID, BookingDate, DateStart, Description, Status) VALUES (?,?,?,?,?,?)";
			pst = conn.prepareStatement(sqlboo, Statement.RETURN_GENERATED_KEYS);
			pst.setLong(1,ticketModel.getScheduleID());
			pst.setLong(2,ticketModel.getCusId());
			pst.setDate(3, ticketModel.getBookingDate());
			pst.setDate(4, ticketModel.getDateStart());
			pst.setString(5, ticketModel.getDescription());
			pst.setBoolean(6, ticketModel.isStatus() );
			pst.executeUpdate();
			rs = pst.getGeneratedKeys();
			if (rs.next())
			{
				System.out.println("lay dc gia tri ID");
				id= rs.getLong(1);
			}
			conn.commit();
			System.out.println("booking OK");
			 //2
			
			String sqldetail = "INSERT INTO detail (BookingID, Seat) VALUES (?,?)"; 
			pst = conn.prepareStatement(sqldetail);
			pst.setInt(2,ticketModel.getSeatList());
			pst.setLong(1,ticketModel.getBookingID());
			pst.executeUpdate();
			conn.commit();
			System.out.println("detail OK");
			 //3
		
			String sqlcus = "INSERT INTO customers( Email) VALUES ( ?)";
			pst = conn.prepareStatement(sqlcus);
			pst.setString(1, ticketModel.getEmail());   
			pst.executeUpdate();
			conn.commit(); //4
			System.out.println("customer OK"); 
			
		} catch (SQLException e) {
			if (conn != null)
			{
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.getMessage();
		}finally {
			try {
				if (conn != null)  conn.close(); 
				if (pst != null) pst.close();
				if (rs != null)    rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return id;
		*/
	}

	@Override
	public TicketModel findOneForTicket(long id) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public void updateapi(TicketModel ticketModel) {
//		//String sql = "UPDATE schedule, booking, detail, customers SET customers.Email=?, customers.FullName=?, customers.Password=?,customers.Address=?, customers.Phone=?, detail.Seat =?, booking.BookingDate=?, booking.DateStart=?,booking.Description = ? WHERE booking.ScheduleID = schedule.ScheduleID AND booking.BookingID =detail.BookingID AND Booking.CusID = customers.CusID AND  booking.BookingID=?";
//		//update(sql, ticketModel.getCustomer().getEmail(), ticketModel.getCustomer().getFullName(), ticketModel.getCustomer().getPassword(), ticketModel.getCustomer().getAddress(), ticketModel.getCustomer().getPhone(), ticketModel.getSeatList(), ticketModel.getBooking().getBookingDate(), ticketModel.getBooking().getDateStart(), ticketModel.getBooking().getDescription(), ticketModel.getBooking().getBookingID()  );
//		String sql = "UPDATE schedule, booking, detail, customers SET customers.FullName=?, detail.Seat =? WHERE booking.ScheduleID = schedule.ScheduleID AND booking.BookingID =detail.BookingID AND Booking.CusID = customers.CusID AND  booking.BookingID=?";
//	update(sql, ticketModel.getCustomer().getFullName(), ticketModel.getSeatList(), ticketModel.getBooking().getBookingID());
//	}

	@Override
	public List<TicketModel> findSeatByStatus() {
		//String sql = "SELECT detail.BookingID, detail.Seat, booking.BookingDate, booking.DateStart, customers.FullName,schedule.TimeStart,schedule.StartPlace, schedule.FinishPlace, schedule.Price FROM  schedule, booking, detail, customers  WHERE booking.ScheduleID = schedule.ScheduleID AND booking.BookingID =detail.BookingID AND Booking.CusID = customers.CusID And booking.Status = 0 AND schedule.BusID = ?";
		StringBuilder sql = new StringBuilder(" SELECT detail.BookingID, detail.Seat, booking.BookingDate, booking.DateStart, customers.FullName,schedule.BusID, schedule.TimeStart, ");
		sql.append(" schedule.StartPlace, schedule.FinishPlace, schedule.Price ");
		sql.append(" FROM  schedule, booking, detail, customers ");
		sql.append(" WHERE booking.ScheduleID = schedule.ScheduleID AND booking.BookingID =detail.BookingID ");
		sql.append(" AND Booking.CusID = customers.CusID And detail.status = 0");
			return query(sql.toString(), new TicketMapper());
	}
		@Override
public List<TicketModel> findAllAvailabeSeat(long busId) {
	//String sql = "SELECT detail.BookingID, detail.Seat, booking.BookingDate, booking.DateStart, customers.FullName,schedule.TimeStart,schedule.StartPlace, schedule.FinishPlace, schedule.Price FROM  schedule, booking, detail, customers  WHERE booking.ScheduleID = schedule.ScheduleID AND booking.BookingID =detail.BookingID AND Booking.CusID = customers.CusID And booking.Status = 0 AND schedule.BusID = ?";
	StringBuilder sql = new StringBuilder(" SELECT detail.BookingID, detail.Seat, booking.BookingDate, booking.DateStart, customers.FullName, schedule.BusID, schedule.TimeStart, ");
	sql.append(" schedule.StartPlace, schedule.FinishPlace, schedule.Price, customers.Email, customers.Address, customers.Phone ");
	sql.append(" FROM  schedule, booking, detail, customers ");
	sql.append(" WHERE booking.ScheduleID = schedule.ScheduleID AND booking.BookingID =detail.BookingID ");
	sql.append(" AND Booking.CusID = customers.CusID And detail.status = 0  AND schedule.BusID = ? ");
		return query(sql.toString(), new TicketMapper(), busId);	
}

	@Override
	public void delete(long id) {
		String sqldetail = "delete from detail where  BookingID=? ";
		update(sqldetail, id);
		
		String sqlbooking = "delete from booking where  BookingID=?";
		update(sqlbooking, id);
	}

	@Override
	public void updateapi(TicketModel ticketModel) {
		String sql = "UPDATE detail set status = 0 where BookingID = ?  AND Seat= ?";
		update(sql, ticketModel.getId(), ticketModel.getSeatList());
	}

	@Override
	public void cancelTicket(long id, int seat) {
		String sql="{CALL cancelTicket( ? , ? )}";
		update(sql, id, seat);
	}

	@Override
	public TicketModel findBySeat(long booking, int seat) {
		StringBuilder sql = new StringBuilder(" select distinct( booking.BookingID), detail.Seat, booking.BookingDate, booking.DateStart,  ");
		sql.append(" customers.FullName, bus.NumberPlate,schedule.BusID ,schedule.TimeStart, placeStart.PlaceName as PlaceStart,  	");
		sql.append("  placeFinish.PlaceName as PlaceFinish,  schedule.Price  ");
		sql.append(" FROM schedule, booking, detail, customers, place placeStart, place placeFinish, bus ");
		sql.append(" WHERE booking.ScheduleID = schedule.ScheduleID  AND booking.BookingID =detail.BookingID  ");
		sql.append("  AND Booking.CusID = customers.CusID AND bus.BusID = schedule.BusID  ");
		sql.append(" AND placeStart.PlaceID = schedule.StartPlace AND placeFinish.PlaceID = schedule.FinishPlace AND bus.BusID = ?  AND detail.seat =? ");
		List<TicketModel> tickets = query(sql.toString(), new TicketMapper(), booking, seat);
		return tickets.isEmpty() ? null : tickets.get(0); 
	}

//	@Override
//	public void updateTicket(TicketModel ticketModel) {
//		String sql="{CALL update4tablenew(?,?,?,?)}";
//		update(sql, ticketModel.getFullName(),ticketModel.getSeatList(), ticketModel.getId(), ticketModel.getSeatListupdate());
//	}
	
	@Override
	public void updateTicket(TicketModel ticketModel) {
		String sql="{CALL update4tablenew(?,?,?,?,?,?,?)}";
		update(sql, ticketModel.getFullName(),ticketModel.getEmail(), ticketModel.getAddress(), ticketModel.getPhone() ,ticketModel.getSeatList(), ticketModel.getId(), ticketModel.getSeatListupdate());
	}
	
	
	//seat nam trong bus (BUS NP), bus NP nam trong BUS, bus ID khoa ngoai schedule
	//=>update status seat(detail), insert CusID, DateStart => new Ticket
}
	