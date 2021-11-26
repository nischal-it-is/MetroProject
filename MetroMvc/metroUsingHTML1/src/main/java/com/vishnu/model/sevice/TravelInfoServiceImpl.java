package com.vishnu.model.sevice;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.vishnu.beans.TravelInfo;
import com.vishnu.model.persistence.TravelInfoDao;

@Service
public class TravelInfoServiceImpl implements TravelInfoService {

	TravelInfoDao t;
//	public TravelInfoServiceImpl()
//	{
//		
//	}
	
	public TravelInfoServiceImpl(TravelInfoDao t) {
		this.t = t;
	}

	@Override
	public ArrayList<TravelInfo> getTravellog(int card_id) {
//		TravelInfoDao t=new TravelInfoDaoImpl();
		return (ArrayList<TravelInfo>) t.getTravelLog(card_id);
	}

	@Override
	public boolean isCheckedInService(int card_id) {
//		TravelInfoDao t=new TravelInfoDaoImpl();
		TravelInfo travelInfo= t.isCheckedIn(card_id);
		if(travelInfo==null)
			return false;
		return true;
	}

}
