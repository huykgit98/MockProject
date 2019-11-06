 package edu.sgu.bookingsystem.model;

import java.time.LocalDate;

public class Time {
	private long schedule_ID;
	private String typeBus;
	private int amount;
	private long startPlace;
	private long finishPlace;
	private LocalDate dateStart;
	private String timeStart;
	public long getSchedule_ID() {
		return schedule_ID;
	}
	public void setSchedule_ID(long schedule_ID) {
		this.schedule_ID = schedule_ID;
	}
	public String getTypeBus() {
		return typeBus;
	}
	public void setTypeBus(String typeBus) {
		this.typeBus = typeBus;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public long getStartPlace() {
		return startPlace;
	}
	public void setStartPlace(long startPlace) {
		this.startPlace = startPlace;
	}
	public long getFinishPlace() {
		return finishPlace;
	}
	public void setFinishPlace(long finishPlace) {
		this.finishPlace = finishPlace;
	}
	public LocalDate getDateStart() {
		return dateStart;
	}
	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public Time() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Time(long schedule_ID, String typeBus, int amount, long startPlace, long finishPlace, LocalDate dateStart,
			String timeStart) {
		super();
		this.schedule_ID = schedule_ID;
		this.typeBus = typeBus;
		this.amount = amount;
		this.startPlace = startPlace;
		this.finishPlace = finishPlace;
		this.dateStart = dateStart;
		this.timeStart = timeStart;
	}
	public Time(long schedule_ID, String typeBus, String timeStart) {
		super();
		this.schedule_ID = schedule_ID;
		this.typeBus = typeBus;
		this.timeStart = timeStart;
	}

	public Time(long Schedule_ID, LocalDate dateStart) {
		super();
		this.schedule_ID = Schedule_ID;
		this.dateStart = dateStart;
	}


}
