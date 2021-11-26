package com.nischal.model.service;
import java.sql.SQLException;
import com.nischal.exception.*;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nischal.beans.Card;
import com.nischal.model.persistence.CardDao;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardDao cardDao;
	
	public CardServiceImpl(CardDao cardDao) {
		super();
		this.cardDao = cardDao;
	}

	public CardServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Card> getAllCards() throws NoRecordPresent{
		// TODO Auto-generated method stub
		//handle exception
		ArrayList<Card> card=(ArrayList<Card>)(cardDao.findAll());
		if(card==null)
		{
			throw new NoRecordPresent("No entry in card");
		}
		return card;
	}

	@Override
	public Card searchById(int id) throws RecordNotFound {
		//handle exception
		Card  card= cardDao.findById(id).get();
		if(card==null)
		{
			throw new RecordNotFound("No card of that id");
		}
		return card;
	}

	@Override
	public boolean insert(Card card) throws InsertionFailed {
		// handle exception
		Card card1=cardDao.save(card);
		if(card1!=null) {return true;}
		throw new InsertionFailed("Failed to insert card");
	}

	@Override
	public boolean updateBalance(int card_id, int balance) throws InsertionFailed {
		// handle exception
		//write a query
		int rows= cardDao.updateBalance(card_id, balance);
		if(rows<=0)
		{
			throw new InsertionFailed("Failed to updae card balance");
		}
		return true;
	}

}
