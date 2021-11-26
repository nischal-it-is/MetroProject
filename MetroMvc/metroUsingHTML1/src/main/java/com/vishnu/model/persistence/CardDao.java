package com.vishnu.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vishnu.beans.Card;

@Repository
public interface CardDao extends JpaRepository<Card, Integer>{
	@Transactional
	@Modifying
	@Query("update Card set balance=balance+:amt where card_id=:CId")
	public int addBalance(@Param("CId")int card_id,@Param("amt")int amount);
	
	
//	@Query("select random_num from (SELECT FLOOR(RAND() * 99999) AS random_num ) as rand WHERE random_num NOT IN (SELECT card_id FROM Card) LIMIT 1;")
	@Query("select max(card_id) from Card")
	public int generateCardNO();

}
