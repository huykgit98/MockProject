package edu.sgu.bookingsystem.model;

public class Seat {
	private int id;
	private int seat;
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Seat(int id, int seat) {
		super();
		this.id = id;
		this.seat = seat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	
}
