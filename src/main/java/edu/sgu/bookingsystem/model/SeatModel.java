package edu.sgu.bookingsystem.model;

public class SeatModel extends AbstractModel<SeatModel>{
	Booking booking  = new Booking();
	Schedule schedule = new Schedule();
	Place place = new Place();
	Bus bus = new Bus();
	BusType busType = new BusType();
	Customer customer =  new Customer();
	private int seatList;
	private String startPlace;
	private String finishPlace;
	private long bookingId;
	private int seatStatus;
	private long scheduleID;
	private long cusID;
	
	
	
	public SeatModel(long scheduleID, long cusID, int seatList) {
		super();
		this.scheduleID = scheduleID;
		this.cusID = cusID;
		this.seatList = seatList;
	}
	public long getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(long scheduleID) {
		this.scheduleID = scheduleID;
	}
	public long getCusID() {
		return cusID;
	}
	public void setCusID(long cusID) {
		this.cusID = cusID;
	}
	public SeatModel(long bookingId, int seatList) {
		super();
		this.bookingId = bookingId;
		this.seatList = seatList;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public BusType getBusType() {
		return busType;
	}
	public void setBusType(BusType busType) {
		this.busType = busType;
	}
	public SeatModel(Booking booking, Schedule schedule, Place place) {
		super();
		this.booking = booking;
		this.schedule = schedule;
		this.place = place;
	}
	public SeatModel() {
		super();
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
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	public int getSeatList() {
		return seatList;
	}
	public void setSeatList(int seatList) {
		this.seatList = seatList;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
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
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public int getSeatStatus() {
		return seatStatus;
	}
	public void setSeatStatus(int seatStatus) {
		this.seatStatus = seatStatus;
	}
	
	
}
