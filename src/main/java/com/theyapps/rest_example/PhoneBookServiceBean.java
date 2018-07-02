package com.theyapps.rest_example;

import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.log4j.Logger;
import org.switchyard.component.bean.Service;

import com.theyapps.rest_example.db.DatabaseConnection;

@Service(PhoneBookService.class)
public class PhoneBookServiceBean implements PhoneBookService {
	private static Logger LOG = Logger.getLogger(PhoneBookService.class);
	
	static long id = 0;
	private static ConcurrentMap<Long, PhoneBookRecord> phonebookMap = new ConcurrentHashMap<>();
	private static DatabaseConnection dbConn;
	
	public PhoneBookServiceBean() {
		LOG.info("Creating PhoneBookService");
		
		try {
			dbConn = new DatabaseConnection();
			
			Collection<PhoneBookRecord> records = dbConn.getPhonebookRecords();
			for(PhoneBookRecord record : records) {
				phonebookMap.put(record.getId(), record);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ResultRecord newPhoneBookRecord(PhoneBookRecord record) {
		PhoneBookRecord result = null;
		if(record != null) {
			//result = new PhoneBookRecord(id++, record.getFirstName(), record.getLastName(), record.getPhoneNumber());
			result = dbConn.newPhonebookRecord(record);
			if(result != null) {
				phonebookMap.put(result.getId(), result);
				LOG.info("Added a new record " + result.toString());
			}
		}
		
		return result != null ? ResultRecord.SUCCESS : ResultRecord.ERROR;
	}

	@Override 
	public PhoneBookRecord getPhoneBookRecord(Long recordId) {
		PhoneBookRecord result = phonebookMap.get(recordId);
		return result;
	}

	@Override
	public PhoneBookRecordList getPhoneBookRecordList() {
		PhoneBookRecordList recordList = new PhoneBookRecordList();
		for(PhoneBookRecord record : phonebookMap.values()) {
			recordList.getRecords().add(record);
		}
		
		return recordList;
	}

	@Override
	public ResultRecord deletePhoneBookRecord(Long recordId) {
		boolean success = false;
		
		PhoneBookRecord result = phonebookMap.get(recordId);
		if(result != null) {
			success = dbConn.deletePhonebookRecord(result);
			phonebookMap.remove(recordId);
		}
		
		return success ? ResultRecord.SUCCESS : ResultRecord.ERROR;
	}

	@Override
	public ResultRecord updatePhoneBookRecord(PhoneBookRecord record) {
		PhoneBookRecord result = phonebookMap.get(record.getId());
		boolean success = false;
		
		if(result != null) {
			success = dbConn.updatePhonebookRecord(result, record);
			
			result.setFirstName(record.getFirstName());
			result.setLastName(record.getLastName());
			result.setPhoneNumber(record.getPhoneNumber());	
		}
		
		return success ? ResultRecord.SUCCESS : ResultRecord.ERROR;
	}


}
