package com.nischal.model.service;
import com.nischal.beans.Station;
import com.nischal.exception.*;
import java.sql.SQLException;
import java.util.ArrayList;
public interface StationService {
	
	ArrayList<Station> getAllStation()throws NoRecordPresent;
	Station searchById(int id)throws RecordNotFound;
	boolean insert(Station station)throws InsertionFailed;

}
