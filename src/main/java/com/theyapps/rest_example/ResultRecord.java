package com.theyapps.rest_example;

import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName(value = "PhoneBookResult")
public class ResultRecord {	
	public static enum ResultState{
		SUCCESS("Success"), ERROR("Error");
		
		private final String stateVal;
		ResultState(String val){
			stateVal = val;
		}
		
		public String toString() {
			return stateVal;
		}
	}
	
	private String result;
	public static final ResultRecord SUCCESS = new ResultRecord(ResultRecord.ResultState.SUCCESS.toString());
	public static final ResultRecord ERROR = new ResultRecord(ResultRecord.ResultState.ERROR.toString());
	
	public ResultRecord(String result) {
		super();
		this.result = result;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	
	
}
