package com.nischal.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Transaction {

	private int cardId;
	@Id
	private int transactionId;
	@OneToOne
	private Station start;
	@OneToOne
	private Station end;
	private int fare;
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	String checkInTime;
	public String getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}
	String checkOutTime;
	public String getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	//date and time have to do
	public Transaction(int cardId, int transactionId, Station start, Station end, int fare) {
		super();
		this.cardId = cardId;
		this.transactionId = transactionId;
		this.start = start;
		this.end = end;
		this.fare = fare;
	}
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public Station getStart() {
		return start;
	}
	public void setStart(Station start) {
		this.start = start;
	}
	public Station getEnd() {
		return end;
	}
	public void setEnd(Station end) {
		this.end = end;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "Transaction [cardId=" + cardId + ", transactionId=" + transactionId + ", start=" + start + ", end="
				+ end + ", fare=" + fare + "]";
	}
	
	
}
