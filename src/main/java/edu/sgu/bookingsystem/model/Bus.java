package edu.sgu.bookingsystem.model;

public class Bus {
	private int id;
	private String numberPlate;
	private BusType busType;
	private int seatNum;
	private int driver_ID;
	private int emp_ID;
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getDriver_ID() {
		return driver_ID;
	}
	public void setDriver_ID(int driver_ID) {
		this.driver_ID = driver_ID;
	}
	public int getEmp_ID() {
		return emp_ID;
	}
	public void setEmp_ID(int emp_ID) {
		this.emp_ID = emp_ID;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bus(int id, String numberPlate, BusType busType, int seatNum, int driver_ID, int emp_ID, int status) {
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
