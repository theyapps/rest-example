package com.theyapps.rest_example;

public interface PhoneBookService {
	public ResultRecord newPhoneBookRecord(PhoneBookRecord record);
	public ResultRecord updatePhoneBookRecord(PhoneBookRecord record);
	public PhoneBookRecord getPhoneBookRecord(Long recordId);
	public PhoneBookRecordList getPhoneBookRecordList();
	public ResultRecord deletePhoneBookRecord(Long recordId);
}
