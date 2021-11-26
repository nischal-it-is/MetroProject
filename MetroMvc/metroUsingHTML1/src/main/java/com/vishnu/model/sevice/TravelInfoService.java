package com.vishnu.model.sevice;

import java.sql.SQLException;
import java.util.ArrayList;

import com.vishnu.beans.TravelInfo;

public interface TravelInfoService {
	public ArrayList<TravelInfo> getTravellog(int card_id);
	public boolean isCheckedInService(int card_id) ;

}
