package com.vishnu.model.sevice;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishnu.beans.Card;
import com.vishnu.model.exceptions.CardNotFoudException;
import com.vishnu.model.persistence.CardDao;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	CardDao cardDao;
	public CardServiceImpl()
	{
		System.out.println("Generating cardService"+cardDao);
	}

	public CardDao getCardDao() {
		return cardDao;
	}

	public void setCardDao(CardDao cardDao) {
		this.cardDao = cardDao;
	}

	@Override
	public int newCard() {
		Card card=new Card();
		int id=generateCardId();
		card.setCard_id(id);
		card.setBalance(100);
		LocalDateTime date = LocalDateTime.now();
	    DateTimeFormatter format1 =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
	    String timeStamp = date.format(format1);
		card.setCreation_info(timeStamp);
		cardDao.save(card);
		return id;
	}

	@Override
	public Card getCardDetails(int card_id) throws CardNotFoudException {
		Optional<Card> c=cardDao.findById(card_id);
		
		if(c.isEmpty())
			throw new CardNotFoudException("Please enter a valid card number if you are a new user generate  new card");
		return c.get();
		
	}

	@Override
	public boolean addBalance(int card_id, int amount) {
		int k= cardDao.addBalance(card_id, amount);
		if(k==0)
			return false;
		return true;
	}

	@Override
	public int generateCardId() {
		return cardDao.generateCardNO()+1;
	}

}
