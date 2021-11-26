package com.vishnu.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Card {
	@Id
	private int card_id;
	private int balance;
	private String creation_info;
	public Card()
	{
		
	}
	public Card(int card_id, int amount, String creation_info) {
		super();
		this.card_id = card_id;
		this.balance = amount;
		this.creation_info = creation_info;
	}
	public int getCard_id() {
		return card_id;
	}
	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int amount) {
		this.balance = amount;
	}
	public String getCreation_info() {
		return creation_info;
	}
	public void setCreation_info(String creation_info) {
		this.creation_info = creation_info;
	}
	@Override
	public String toString() {
		return "Card [card_id=" + card_id + ", balance=" + balance + ", creation_info=" + creation_info + "]";
	}
	

}
