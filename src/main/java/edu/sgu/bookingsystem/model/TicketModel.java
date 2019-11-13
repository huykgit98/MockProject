package edu.sgu.bookingsystem.model;

public class TicketModel extends AbstractModel<TicketModel>{
	
	private int seatList;
	private int seatListupdate;
	private Booking booking =  new Booking();
	private Schedule schedule = new Schedule();
	private Customer customer = new Customer();
	private Place place = new Place();
	private Bus bus =  new Bus();
	private long[] ids;
	private int[] seats;
	private String fullName;
	private long id;
	private String startPlace;
	private String finishPlace;
	private String email;
	private String address;
	private String phone;
	
	
	
	
	
	public TicketModel(String uName, String email, String address, String phone, int uSeat, long iId, int iSeat) {
		super();
		this.fullName = uName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.seatList = uSeat;
		this.id = iId;
		this.seatListupdate = iSeat;
	}

	public TicketModel(String uName, int uSeat, long iId, int iSeat) {
		super();
		this.fullName = uName;
		this.seatList = uSeat;
		this.id = iId;
		this.seatListupdate = iSeat;
	}

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public TicketModel() {
		super();
	}
	
	
	
	public TicketModel(Booking booking, Schedule schedule, Customer customer, long[] ids) {
		super();
		this.booking = booking;
		this.schedule = schedule;
		this.customer = customer;
		this.ids = ids;
	}


	
	public Booking getBooking() {
		return booking;
	}



	public void setBooking(Booking booking) {
		this.booking = booking;
	}



	public Schedule getSchedule() {
		return schedule;
	}



	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public long[] getIds() {
		return ids;
	}
	public void setIds(long[] ids) {
		this.ids = ids;
	}



	public int getSeatList() {
		return seatList;
	}



	public void setSeatList(int seatList) {
		this.seatList = seatList;
	}



//	public TicketModel(String cusName, int seatList, long id) {
//		super();
//		String s =  this.getCustomer().getFullName() ; 
//		s = cusName ;
//		 this.seatList = seatList  ;
//		 long l = this.getBooking().getBookingID();
//				 l= 	id ;
//	}



	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public TicketModel(String fullName, long id) {
		super();
		this.fullName = fullName;
		//this.seatList = seatList;
		this.id = id;
	}



	public TicketModel(long id, int seatList) {
		super();
		this.id = id;
		this.seatList = seatList;
	}





	public int getSeatListupdate() {
		return seatListupdate;
	}



	public void setSeatListupdate(int seatListupdate) {
		this.seatListupdate = seatListupdate;
	}
	
	




	public Place getPlace() {
		return place;
	}



	public void setPlace(Place place) {
		this.place = place;
	}



	public String getStartPlace() {
		return startPlace;
	}



	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}



	public String getFinishPlace() {
		return finishPlace;
	}



	public void setFinishPlace(String finishPlace) {
		this.finishPlace = finishPlace;
	}



	public int[] getSeats() {
		return seats;
	}



	public void setSeats(int[] seats) {
		this.seats = seats;
	}



	public Bus getBus() {
		return bus;
	}



	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	
}
