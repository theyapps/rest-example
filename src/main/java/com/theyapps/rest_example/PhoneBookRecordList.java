package com.theyapps.rest_example;

import java.util.LinkedList;

import javax.xml.bind.annotation.*;

import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName(value = "PhoneBookList")
public class PhoneBookRecordList {
	private LinkedList<PhoneBookRecord> records;
	
	public PhoneBookRecordList() {
		records = new LinkedList<>();
	}
	
	/**
	 * @return the records
	 */
	@XmlElement(name="RecordList")
	public LinkedList<PhoneBookRecord> getRecords() {
		return records;
	}

	/**
	 * @param records the records to set
	 */
	public void setRecords(LinkedList<PhoneBookRecord> records) {
		this.records = records;
	}

	
}
