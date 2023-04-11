package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class SolvitCase implements Serializable {

	private String processState;
	private String processId;
	@JsonProperty("nameField")
	private String formId;
	private String token;
	private String modemType;
	private String modemStatus;
	private String lineMeasurement;

	public String getProcessState() {
		return processState;
	}

	public void setProcessState(String processState) {
		this.processState = processState;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getModemType() {
		return modemType;
	}

	public void setModemType(String modemType) {
		this.modemType = modemType;
	}

	public String getModemStatus() {
		return modemStatus;
	}

	public void setModemStatus(String modemStatus) {
		this.modemStatus = modemStatus;
	}

	public String getLineMeasurement() {
		return lineMeasurement;
	}

	public void setLineMeasurement(String lineMeasurement) {
		this.lineMeasurement = lineMeasurement;
	}
}
