package com.nischal.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Card {
	
	private int balance;
	@Id
	private int cardId;

	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int card_id) {
		this.cardId = card_id;
	}
	@Override
	public String toString() {
		return "Card [balance=" + balance + ", card_id=" + cardId + "]";
	}
	
	public Card(int balance, int card_id) {
		super();
		this.balance = balance;
		this.cardId = card_id;
	}
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
