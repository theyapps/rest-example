package com.theyapps.rest_example;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.camel.Converter;
import org.apache.log4j.Logger;


@Converter
public class PhoneBookRecordConverter {
	private static final Logger LOGGER = Logger.getLogger(PhoneBookRecordConverter.class);
	
	/**
     * Wraps PhoneBookRecord into iterator.
     *
     * @param record PhoneBookRecord.
     * @return
     */
    @Converter
    public static Iterator<Object> from(PhoneBookRecord record) {
        return new PhoneBookRecordIterator(record);
    }
    
    @Converter
    public static PhoneBookRecord[] from(List<Map<String, Object>> objects) {
    	PhoneBookRecord[] records = new PhoneBookRecord[objects.size()];
        int position = 0;
        for (Map<String, Object> record : objects) {
        	records[position++] = new PhoneBookRecord(
        		Long.valueOf(((Integer) record.get("id")).longValue()),
                (String) record.get("firstname"),
                (String) record.get("lastname"),
                (String) record.get("phonenumber")
                );
        }
        return records;
    }
    
    /**
     * Wraps a map that contains the record sql result into a Record[].
     *
     * @param object Map with the result.
     */
    @Converter
    public static PhoneBookRecord from(Map<String, Object> object) {
        LOGGER.debug("Converting " + object.toString() + "to a PhoneBookRecord object");
        PhoneBookRecord record = new PhoneBookRecord(
        		Long.valueOf(((Integer) object.get("id")).longValue()),
                (String) object.get("firstname"),
                (String) object.get("lastname"),
                (String) object.get("phonenumber")
                );
        return record;
    }
}
