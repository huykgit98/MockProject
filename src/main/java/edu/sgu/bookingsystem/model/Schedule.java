package edu.sgu.bookingsystem.model;

import java.util.Date;
import java.util.List;

public class Schedule {
	
	private long schedule_ID;
	private long id;
	private String timeStart;
	private long startPlaceID;
	private long finishPlaceID;
	private String startPlace;
	private String finishPlace;
	private String numberPlate;
	private String busType;
	private double price;
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSchedule_ID() {
		return schedule_ID;
	}
	public void setSchedule_ID(long schedule_ID) {
		this.schedule_ID = schedule_ID;
	}
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public long getStartPlaceID() {
		return startPlaceID;
	}
	public void setStartPlaceID(long startPlaceID) {
		this.startPlaceID = startPlaceID;
	}
	public long getFinishPlaceID() {
		return finishPlaceID;
	}
	public void setFinishPlaceID(long finishPlaceID) {
		this.finishPlaceID = finishPlaceID;
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
	public String getNumberPlate() {
		return numberPlate;
	}
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Schedule(long schedule_ID, String timeStart, long startPlaceID, long finishPlaceID, String startPlace,
			String finishPlace, String numberPlate, String busType, double price) {
		super();
		this.schedule_ID = schedule_ID;
		this.timeStart = timeStart;
		this.startPlaceID = startPlaceID;
		this.finishPlaceID = finishPlaceID;
		this.startPlace = startPlace;
		this.finishPlace = finishPlace;
		this.numberPlate = numberPlate;
		this.busType = busType;
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((busType == null) ? 0 : busType.hashCode());
		result = prime * result + ((finishPlace == null) ? 0 : finishPlace.hashCode());
		result = prime * result + (int) (finishPlaceID ^ (finishPlaceID >>> 32));
		result = prime * result + ((numberPlate == null) ? 0 : numberPlate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (schedule_ID ^ (schedule_ID >>> 32));
		result = prime * result + ((startPlace == null) ? 0 : startPlace.hashCode());
		result = prime * result + (int) (startPlaceID ^ (startPlaceID >>> 32));
		result = prime * result + ((timeStart == null) ? 0 : timeStart.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		if (busType == null) {
			if (other.busType != null)
				return false;
		} else if (!busType.equals(other.busType))
			return false;
		if (finishPlace == null) {
			if (other.finishPlace != null)
				return false;
		} else if (!finishPlace.equals(other.finishPlace))
			return false;
		if (finishPlaceID != other.finishPlaceID)
			return false;
		if (numberPlate == null) {
			if (other.numberPlate != null)
				return false;
		} else if (!numberPlate.equals(other.numberPlate))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (schedule_ID != other.schedule_ID)
			return false;
		if (startPlace == null) {
			if (other.startPlace != null)
				return false;
		} else if (!startPlace.equals(other.startPlace))
			return false;
		if (startPlaceID != other.startPlaceID)
			return false;
		if (timeStart == null) {
			if (other.timeStart != null)
				return false;
		} else if (!timeStart.equals(other.timeStart))
			return false;
		return true;
	}

}
