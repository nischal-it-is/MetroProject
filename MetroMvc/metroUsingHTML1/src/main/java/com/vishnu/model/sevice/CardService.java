package com.vishnu.model.sevice;

import java.sql.SQLException;

import com.vishnu.beans.Card;
import com.vishnu.model.exceptions.CardNotFoudException;

public interface CardService {
	public int newCard() ;
	public Card getCardDetails(int card_id) throws CardNotFoudException;
	boolean addBalance(int id,int amount) ;
	public int generateCardId() ;
	

}
