package com.nischal.model.service;
import java.sql.SQLException;
import com.nischal.exception.*;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nischal.beans.Station;
import com.nischal.model.persistence.StationDao;
@Service
public class StationServiceImpl implements StationService{

	@Autowired
	private StationDao stationDao;

	public StationServiceImpl(StationDao stationDao) {
		super();
		this.stationDao = stationDao;
	}

	public StationServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	//handling exception is left
	@Override
	public ArrayList<Station> getAllStation() throws NoRecordPresent {
		ArrayList<Station> station=(ArrayList<Station>)(stationDao.findAll());
		if(station==null)
		{
			throw new NoRecordPresent("No station record Present");
		}
		return station;
	}

	@Override
	public Station searchById(int id) throws RecordNotFound {
		Station station=stationDao.findById(id).get();
		if(station==null)
		{
			throw new RecordNotFound("No Station By this id");
		}
		return station;
	}

	@Override
	public boolean insert(Station station) throws InsertionFailed {
	
		Station station1= stationDao.save(station);
		if(station1==null)
		{
			throw new InsertionFailed("Failed to insert Station");
		}
		return true;
	}
	
}
