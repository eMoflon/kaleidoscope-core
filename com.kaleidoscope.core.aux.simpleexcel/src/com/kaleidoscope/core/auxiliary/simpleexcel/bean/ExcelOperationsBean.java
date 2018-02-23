/**
 * 
 */
package com.kaleidoscope.core.auxiliary.simpleexcel.bean;

import java.util.HashMap;

/**
 * @author Srijani
 *
 */
public class ExcelOperationsBean {
	private String operationName;
	private HashMap<String, String> operationDetails;
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	public HashMap<String, String> getOperationDetails() {
		return operationDetails;
	}
	public void setOperationDetails(HashMap<String, String> operationDetails) {
		this.operationDetails = operationDetails;
	}
}
