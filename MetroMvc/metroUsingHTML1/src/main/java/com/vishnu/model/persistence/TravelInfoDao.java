package com.vishnu.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vishnu.beans.TravelInfo;

@Repository
public interface TravelInfoDao extends JpaRepository<TravelInfo, Integer>{
	
	
//	public boolean checkIn(int card_id, int station_id, String DateTime) throws ClassNotFoundException, SQLException,InsufficientBalanceException;
	@Query("select tr from TravelInfo tr where tr.card_id=:card_id and tr.checkIn_time is not null and tr.checkOut_time is  null")
	public TravelInfo isCheckedIn(@Param("card_id")int card_id);
	
	@Transactional
	@Modifying
	@Query("update TravelInfo set checkOut_id=:station_id,checkOut_time=:time,fare=:fare  where card_id=:card_id and checkIn_time is not null and checkOut_time is  null")
	public int checkOut(@Param("card_id") int card_id,@Param("station_id")int station_id,@Param("time")String DateTime,@Param("fare")int fare) ;
	
	@Query("select tr.checkIn_id from TravelInfo tr where tr.card_id=:card_id and tr.checkIn_time is not null and tr.checkOut_time is  null")
	public int checkInStationId(int card_id) ;
	
	@Query("select tr.checkIn_time from TravelInfo tr where tr.card_id=:card_id and tr.checkIn_time is not null and tr.checkOut_time is  null")
	public String checkInTime(int card_id);
	
	@Query("select tr from TravelInfo tr where tr.card_id=:card_id  and tr.checkIn_time is not null and tr.checkOut_time is not null order by tr.checkOut_time desc")
	public List<TravelInfo> getTravelLog(@Param("card_id")int card_id) ;

}
