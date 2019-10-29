package edu.sgu.bookingsystem.model;

public class Seat {
	private long id;
	private int seat;
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Seat(long id, int seat) {
		super();
		this.id = id;
		this.seat = seat;
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
	
}
