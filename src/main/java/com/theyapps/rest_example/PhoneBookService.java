package com.theyapps.rest_example;

public interface PhoneBookService {
	public PhoneBookRecord newPhoneBookRecord(PhoneBookRecord record);
	public PhoneBookRecord getPhoneBookRecord(Long recordId);
	public PhoneBookRecordList getPhoneBookRecordList();
	public PhoneBookRecord deletePhoneBookRecord(Long recordId);
}
