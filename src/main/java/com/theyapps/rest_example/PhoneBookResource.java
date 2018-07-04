package com.theyapps.rest_example;

import javax.ws.rs.*;
import javax.xml.ws.Response;


@Path("/phonebook")
public interface PhoneBookResource {
	@PUT
	@Path("/")
	@Consumes({"application/json"})
	@Produces({ "application/json" })
	public PhoneBookRecord newPhoneBookRecord(PhoneBookRecord record);
	
	@POST
	@Path("/")
	@Consumes({"application/json"})
	@Produces({ "application/json" })
	public PhoneBookRecord updatePhoneBookRecord(PhoneBookRecord record);
	
	@GET
	@Path("/")
	@Produces({"application/json"})
	public PhoneBookRecordList getPhoneBookRecordList();
	
	@GET
    	@Path("{phonebookId}")
    	@Produces({"application/json"})
    	public PhoneBookRecord getPhoneBookRecord(@PathParam("phonebookId") Long recordId);
	
	@DELETE
    	@Path("{phonebookId}")
    	@Produces({"application/json"})
    	public PhoneBookRecord deletePhoneBookRecord(@PathParam("phonebookId") Long recordId);
	
}
