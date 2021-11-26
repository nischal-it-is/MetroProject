package com.vishnu.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TravelInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int travel_id;
	private int card_id;
	private int checkIn_id;
	private int checkOut_id;
	private String checkIn_time;
	private String checkOut_time;
	private int fare;
	public TravelInfo()
	{
		
	}
	public TravelInfo(int travel_id, int card_id, int checkIn_id, int checkOut_id, String checkIn_time,
			String checkOut_time, int fare) {
		this.travel_id = travel_id;
		this.card_id = card_id;
		this.checkIn_id = checkIn_id;
		this.checkOut_id = checkOut_id;
		this.checkIn_time = checkIn_time;
		this.checkOut_time = checkOut_time;
		this.fare = fare;
	}
	public int getTravel_id() {
		return travel_id;
	}
	public void setTravel_id(int travel_id) {
		this.travel_id = travel_id;
	}
	public int getCard_id() {
		return card_id;
	}
	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}
	public int getCheckIn_id() {
		return checkIn_id;
	}
	public void setCheckIn_id(int checkIn_id) {
		this.checkIn_id = checkIn_id;
	}
	public int getCheckOut_id() {
		return checkOut_id;
	}
	public void setCheckOut_id(int checkOut_id) {
		this.checkOut_id = checkOut_id;
	}
	public String getCheckIn_time() {
		return checkIn_time;
	}
	public void setCheckIn_time(String checkIn_time) {
		this.checkIn_time = checkIn_time;
	}
	public String getCheckOut_time() {
		return checkOut_time;
	}
	public void setCheckOut_time(String checkOut_time) {
		this.checkOut_time = checkOut_time;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "TravelInfo [travel_id=" + travel_id + ", card_id=" + card_id + ", checkIn_id=" + checkIn_id
				+ ", checkOut_id=" + checkOut_id + ", checkIn_time=" + checkIn_time + ", checkOut_time=" + checkOut_time
				+ ", fare=" + fare + "]";
	}
	

}
