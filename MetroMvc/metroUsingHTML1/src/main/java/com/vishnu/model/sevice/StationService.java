package com.vishnu.model.sevice;

import java.sql.SQLException;
import java.util.ArrayList;

import com.vishnu.beans.Station;
import com.vishnu.model.exceptions.InsufficientBalanceException;
import com.vishnu.model.exceptions.StationNotFoundException;

public interface StationService {
	ArrayList<Station> getAllStations() ;
	boolean checkInService(int card_id,int station_id) throws InsufficientBalanceException;
	int checkOutService(int card_id,int station_id) ;
	public int calculateFare(int check_out_id,int check_in_id) ;
	public boolean isValidStation(int station_id) throws StationNotFoundException;
	public Station getStationDetails(int station_id) throws StationNotFoundException;

}
