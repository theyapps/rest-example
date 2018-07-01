package com.theyapps.rest_example;

import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName(value = "Error")
public class ErrorRecord extends Record{
	private String errorCause;
	private String errorMessage;
	public ErrorRecord(String errorCause, String errorMessage) {
		super();
		this.errorCause = errorCause;
		this.errorMessage = errorMessage;
	}
	
	
}
