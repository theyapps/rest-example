package com.theyapps.rest_example;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

@Service(PhoneBookService.class)
public class PhoneBookServiceBean implements PhoneBookService {
	Logger LOG = Logger.getLogger(PhoneBookService.class);
	
	static long id = 0;
	private static ConcurrentMap<Long, PhoneBookRecord> phonebookMap = new ConcurrentHashMap<>();
	
	@Inject
    @Reference("DBInsertService")
	private DBService insertDB;
	
	@Inject
    @Reference("DBDeleteService")
	private DBService deleteDB;

	public PhoneBookServiceBean() {
		LOG.info("Creating PhoneBookService");
		
		// Adding some dummy data
		/*LOG.info("Populating dummy data");
		
		phonebookMap.put(id, new PhoneBookRecord(id++, "John", "Doe", "555-656-8845"));
		phonebookMap.put(id, new PhoneBookRecord(id++, "Jane", "Doe", "555-656-4545"));
		phonebookMap.put(id, new PhoneBookRecord(id++, "Steve", "Smith", "555-985-4582"));
		phonebookMap.put(id, new PhoneBookRecord(id++, "Joe", "Brown", "555-545-4569"));
		phonebookMap.put(id, new PhoneBookRecord(id++, "Bob", "Black", "555-656-2157"));*/

	}
	
	@Override
	public void consume(PhoneBookRecord record) {
		if(!phonebookMap.containsKey(record.getId())) {
			LOG.info("Consuming record " + record.getId());
			phonebookMap.put(record.getId(), record);
		}		
	}

	@Override
	public ResultRecord newPhoneBookRecord(PhoneBookRecord record) {
		PhoneBookRecord result = null;
		if(record != null) {
			insertDB.execute(record);
			LOG.info("Added a new record " + record.toString());
			return ResultRecord.SUCCESS;
		}
		
		return ResultRecord.ERROR;
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
		PhoneBookRecord result = phonebookMap.get(recordId);
		
		if(result != null) {
			phonebookMap.remove(recordId);
			deleteDB.execute(result);
			return ResultRecord.SUCCESS;
		}
		
		return ResultRecord.ERROR;
	}

	@Override
	public ResultRecord updatePhoneBookRecord(PhoneBookRecord record) {
		PhoneBookRecord result = phonebookMap.get(record.getId());
		
		if(result != null) {
			result.setFirstname(record.getFirstname());
			result.setLastname(record.getLastname());
			result.setPhonenumber(record.getPhonenumber());
			return ResultRecord.SUCCESS;
		}
		
		return ResultRecord.ERROR;
	}
}
