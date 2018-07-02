package com.theyapps.rest_example;

import java.util.Iterator;


public class PhoneBookRecordIterator implements Iterator<Object> {
	private final PhoneBookRecord record;
    private int pointer;
    
	public PhoneBookRecordIterator(PhoneBookRecord record) {
		this.record = record;
	}

	@Override
	public boolean hasNext() {
		return pointer < 4;
	}

	@Override
	public Object next() {
		switch (pointer++) {
        case 0:
            return record.getFirstname();
        case 1:
            return record.getLastname();
        case 2:
            return record.getPhonenumber();
        case 3:
        	return record.getId();
    }
		return null;
	}

}
