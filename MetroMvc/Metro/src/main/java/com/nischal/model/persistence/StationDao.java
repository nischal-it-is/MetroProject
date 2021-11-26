package com.nischal.model.persistence;
import com.nischal.beans.Station;
import com.nischal.exception.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StationDao  extends JpaRepository<Station,Integer>{
	
//	ArrayList<Station> getAllStation()throws NoRecordPresent;
//	Station searchById(int id)throws RecordNotFound;
//	boolean insert(Station station)throws InsertionFailed;

}
