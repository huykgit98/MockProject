package edu.sgu.bookingsystem.model;

public class Bus {
	private long id;
	private String numberPlate;
	private BusType busType;
	private int seatNum;
	private long driver_ID;
	private long emp_ID;
	private boolean status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumberPlate() {
		return numberPlate;
	}
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	public BusType getBusType() {
		return busType;
	}
	public void setBusType(BusType busType) {
		this.busType = busType;
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	public long getDriver_ID() {
		return driver_ID;
	}
	public void setDriver_ID(long driver_ID) {
		this.driver_ID = driver_ID;
	}
	public long getEmp_ID() {
		return emp_ID;
	}
	public void setEmp_ID(long emp_ID) {
		this.emp_ID = emp_ID;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bus(long id, String numberPlate, BusType busType, int seatNum, long driver_ID, long emp_ID, boolean status) {
		super();
		this.id = id;
		this.numberPlate = numberPlate;
		this.busType = busType;
		this.seatNum = seatNum;
		this.driver_ID = driver_ID;
		this.emp_ID = emp_ID;
		this.status = status;
	}
}
