package com.nischal.model.service;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nischal.beans.Transaction;
import com.nischal.exception.InsertionFailed;
import com.nischal.exception.NoRecordPresent;
import com.nischal.exception.RecordNotFound;
import com.nischal.model.persistence.TransactionDao;
import com.nischal.beans.Station;
@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionDao transaction;
	
	public TransactionServiceImpl(TransactionDao transaction) {
		super();
		this.transaction = transaction;
	}

	public TransactionServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	//throwing exception left
	@Override
	public ArrayList<Transaction> getAllRecords() throws NoRecordPresent {
		ArrayList<Transaction> transactionList=(ArrayList<Transaction>)(transaction.findAll());
		if(transactionList==null)
		{
			throw new NoRecordPresent("No transaction record Present");
		}
		return transactionList;
		
	}

	@Override
	public Transaction searchById(int id) throws RecordNotFound {
	
		Transaction transaction1=transaction.findById(id).get();
		if(transaction1==null)
		{
			throw new RecordNotFound("No transaction present by id");
		}
		return transaction1;
	}

	@Override
	public boolean insert(Transaction transactionInput,String checkInTime) throws InsertionFailed {
	       transactionInput.setCheckInTime(checkInTime);
	       DateTimeFormatter formatter
	         = DateTimeFormatter.ofPattern(
	             "yyyy-MM-dd HH:mm:ss");
		     LocalDateTime now = LocalDateTime.now();
		     String dateTimeString = now.format(formatter);
		     transactionInput.setCheckOutTime(dateTimeString);
		     Transaction t=transaction.save(transactionInput);
		     if(t==null)
		     {
		    	 throw new InsertionFailed("Failed to insert transaction");
		     }
		     return true;
	}

}
