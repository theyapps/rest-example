package com.theyapps.rest_example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import com.theyapps.rest_example.PhoneBookRecord;

public class DatabaseConnection {
	private static Logger LOG = Logger.getLogger(DatabaseConnection.class); 
	
	private Connection conn;
	
	public DatabaseConnection() throws SQLException {
		conn = DriverManager.getConnection(
		           "jdbc:mysql://localhost:3306/phonebook?useSSL=false", "jboss", "jboss");
	}
	
	public Collection<PhoneBookRecord> getPhonebookRecords() {
		LinkedList<PhoneBookRecord> records = new LinkedList<>();
		
		try {
			String query = "SELECT * FROM phonebook";
			Statement stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery(query);
			
			while(results.next()) {
				records.add(new PhoneBookRecord(
						results.getLong("id"),
						results.getString("firstname"),
						results.getString("lastname"),
						results.getString("phonenumber")));
			}
			
			stmt.close();			
		} catch (SQLException e) {
			LOG.error("SQLException while getting phone records");
			e.printStackTrace();
		}
		return records;		
	}
	
	public PhoneBookRecord newPhonebookRecord(PhoneBookRecord record) {
		PhoneBookRecord result = null;
		try {
			// Note: Any time you are passing params to a sql query you should use preparedstatements
			String query = "INSERT INTO phonebook(firstname,lastname,phonenumber) VALUES (?,?,?)";
			
			PreparedStatement pStmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, record.getFirstName());
			pStmt.setString(2, record.getLastName());
			pStmt.setString(3, record.getPhoneNumber());
			
			int affected = pStmt.executeUpdate();
			
			ResultSet resultset = pStmt.getGeneratedKeys();
			if(resultset.next()) {
				record.setId(resultset.getLong(1));
				result = record;
			}
			pStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;		
	}
	
	//TODO: Implement
	public boolean deletePhonebookRecord(PhoneBookRecord record) {
		int affected = 0;
		try {
			String query = "DELETE FROM phonebook WHERE id=? AND firstname=? AND lastname=? AND phonenumber=?";
			PreparedStatement pStmt = conn.prepareStatement(query);
			pStmt.setLong  (1, record.getId());
			pStmt.setString(2, record.getFirstName());
			pStmt.setString(3, record.getLastName());
			pStmt.setString(4, record.getPhoneNumber());
			
			affected = pStmt.executeUpdate();
			pStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return affected > 0;
	}
	
	//TODO: Implement
	public boolean updatePhonebookRecord(PhoneBookRecord origRecord, PhoneBookRecord modRecord) {
		int affected = 0;
		try {
			String query = "UPDATE phonebook SET id=?,firstname=?,lastname=?,phonenumber=? WHERE "
					+ "id=? AND firstname=? AND lastname=? AND phonenumber=?";
			PreparedStatement pStmt = conn.prepareStatement(query);
			pStmt.setLong  (1, modRecord.getId());
			pStmt.setString(2, modRecord.getFirstName());
			pStmt.setString(3, modRecord.getLastName());
			pStmt.setString(4, modRecord.getPhoneNumber());
			pStmt.setLong  (5, origRecord.getId());
			pStmt.setString(6, origRecord.getFirstName());
			pStmt.setString(7, origRecord.getLastName());
			pStmt.setString(8, origRecord.getPhoneNumber());
			
			affected = pStmt.executeUpdate();
			pStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return affected > 0;
	}
}
