package com.theyapps.rest_example;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.*;

@JsonRootName(value = "PhoneBookRecord")
@JsonPropertyOrder({"id","firstname","lastname","phonenumber"})
//@XmlRootElement()
//@XmlType (propOrder={"id","firstname","lastname","phonenumber"})
public class PhoneBookRecord {
	private Long id;
	private String firstname;
	private String lastname;
	private String phonenumber;
	
	public PhoneBookRecord() {
		super();
	}

	public PhoneBookRecord(Long id, String firstname, String lastname, String phonenumber) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phonenumber = phonenumber;
	}
	
	public PhoneBookRecord(String firstname, String lastname, String phonenumber) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phonenumber = phonenumber;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}

	/**
	 * @param phonenumber
	 *            the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PhoneBookRecord [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", phonenumber="
				+ phonenumber + "]";
	}

}
