package com.nischal.model.persistence;
import com.nischal.beans.Transaction;


import com.nischal.exception.*;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nischal.beans.Card;
import com.nischal.beans.Station;
@Repository
public interface TransactionDao  extends JpaRepository<Transaction,Integer>{
	
//	ArrayList<Transaction> getAllRecords()throws NoRecordPresent;
//	Transaction searchById(int id)throws RecordNotFound;
//	boolean insert(Transaction transaction,String checkInTime)throws InsertionFailed;

}
