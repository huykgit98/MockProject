package edu.sgu.bookingsystem.model;

public class Seat {
	private long id;
	private int seat;
	private int status;  
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Seat(long id, int seat, int status) {
		super();
		this.id = id;
		this.seat = seat;
		this.status = status;
	}
	
	
	
	
	
}
