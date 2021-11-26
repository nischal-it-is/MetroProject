package com.nischal.model.service;
import com.nischal.beans.Card;
import java.sql.SQLException;
import java.util.ArrayList;
import com.nischal.exception.*;
public interface CardService {
     
	ArrayList<Card> getAllCards()throws NoRecordPresent;
	Card searchById(int id)throws RecordNotFound;
	boolean insert(Card card)throws InsertionFailed;
	boolean updateBalance(int card_id,int balance)throws InsertionFailed;
	
}
