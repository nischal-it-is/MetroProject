package com.nischal.model.persistence;
import com.nischal.beans.Card;
import com.nischal.exception.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface CardDao extends JpaRepository<Card,Integer>{

//	ArrayList<Card> getAllRecords()throws NoRecordPresent;
//	Card searchById(int id)throws RecordNotFound;
//	boolean insert(Card card)throws InsertionFailed;
//	boolean updateBalance(int card_id,int balance)throws InsertionFailed;
	
	@Transactional
	@Modifying
	@Query("update Card Set balance=:bal where cardId=:id")
	public int updateBalance(@Param("id") int cardid, @Param("bal") int balance);
	
}
