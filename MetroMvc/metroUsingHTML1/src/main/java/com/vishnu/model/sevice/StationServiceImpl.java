package com.vishnu.model.sevice;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishnu.beans.Station;
import com.vishnu.beans.TravelInfo;
import com.vishnu.model.exceptions.InsufficientBalanceException;
import com.vishnu.model.exceptions.StationNotFoundException;
import com.vishnu.model.persistence.CardDao;
import com.vishnu.model.persistence.StationDao;
import com.vishnu.model.persistence.TravelInfoDao;

@Service
public class StationServiceImpl implements StationService {

	@Autowired
	StationDao s;
	@Autowired
	TravelInfoDao t;
	@Autowired
	CardDao card;
//	public StationServiceImpl()
//	{
//		
//	}
	

	@Override
	public ArrayList<Station> getAllStations() {
//		StationDao s=new StationDaoImpl();
		return (ArrayList<Station>) s.findAll();
	}

	@Override
	public boolean checkInService(int card_id, int station_id) throws InsufficientBalanceException {
		LocalDateTime date = LocalDateTime.now();
	    DateTimeFormatter format1 =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
	    String timeStamp = date.format(format1);
	    TravelInfo travelInfo=new TravelInfo();
	    travelInfo.setCard_id(card_id);
	    travelInfo.setCheckIn_id(station_id);
	    travelInfo.setCheckIn_time(timeStamp);
	    travelInfo= t.save(travelInfo);
	    if(travelInfo==null)
	    	return false;
	    return true;
		
	}

	@Override
	public int checkOutService(int card_id, int station_id) {
		LocalDateTime date = LocalDateTime.now();
	    DateTimeFormatter format1 =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
	    String timeStamp = date.format(format1);
		int check_in_id=t.checkInStationId(card_id);
		String check_in_time=t.checkInTime(card_id);
		int fare=calculateFare(check_in_id,station_id);
		int fine=calculateFine(check_in_time,timeStamp);
		card.addBalance(card_id, -(fare+fine));
		t.checkOut(card_id, station_id, timeStamp, fare+fine);
		return fare+fine;
		
	}

	@Override
	public int calculateFare(int check_in_id,int check_out_id) {
		// TODO Auto-generated method stub
		return Math.abs((check_out_id-check_in_id)*5);
	}
	
	public int calculateFine(String check_in_time,String check_out_time)
	{
		DateTimeFormatter formatter_3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime local_date_3 = LocalDateTime.parse(check_in_time, formatter_3);
		  LocalDateTime local_date_4 = LocalDateTime.parse(check_out_time, formatter_3);
		  long diffInMinutes = ChronoUnit.MINUTES.between(local_date_3, local_date_4);
		  int fine=0;
		  if(diffInMinutes>90)
		  fine= (int)( Math.ceil((double)(diffInMinutes-90)/60))*60;
		  return Math.abs(fine);
		
	}

	@Override
	public boolean isValidStation(int station_id) throws StationNotFoundException {
		Optional<Station> station=s.findById(station_id);
		if(station.isEmpty())
			throw new StationNotFoundException("Please Enter a Valid Station");
		return true;
		
	}

	@Override
	public Station getStationDetails(int station_id) throws StationNotFoundException {
//		StationDao s=new StationDaoImpl();
		Optional<Station> station=s.findById(station_id);
		
		if(!station.isPresent())
			throw new StationNotFoundException("Please Enter a Valid Station");
		return station.get();
	}

}
