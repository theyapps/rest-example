package com.theyapps.rest_example;

import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName(value = "ResultRecord")
public class ResultRecord {
	public static final ResultRecord SUCCESS = new ResultRecord("Success");
	public static final ResultRecord ERROR = new ResultRecord("Error");

	private String resultState;

	public ResultRecord(String resultState) {
		this.resultState = resultState;
	}

	/**
	 * @return the resultState
	 */
	public String getResultState() {
		return resultState;
	}

	/**
	 * @param resultState
	 *            the resultState to set
	 */
	public void setResultState(String resultState) {
		this.resultState = resultState;
	}

}
