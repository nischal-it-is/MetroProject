package com.nischal.model.service;
import com.nischal.beans.Station;
import com.nischal.exception.*;
import com.nischal.beans.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
public interface TransactionService {

	ArrayList<Transaction> getAllRecords()throws NoRecordPresent;
	Transaction searchById(int id)throws RecordNotFound;
	boolean insert(Transaction transaction,String checkInTime)throws InsertionFailed;
}
