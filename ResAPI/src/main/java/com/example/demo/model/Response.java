package com.example.demo.model;

import java.util.Objects;

public class Response {
	private String responseCode;
	private String responseMessage;
	private String responseId;
	private String responseTime;

	public Response() {
		super();
	}

	public Response(String responseCode, String responseMessage, String responseId, String responseTime) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
		this.responseId = responseId;
		this.responseTime = responseTime;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getResponseId() {
		return responseId;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	public String getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(responseCode, responseId, responseMessage, responseTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Response other = (Response) obj;
		return Objects.equals(responseCode, other.responseCode) && Objects.equals(responseId, other.responseId)
				&& Objects.equals(responseMessage, other.responseMessage)
				&& Objects.equals(responseTime, other.responseTime);
	}

	@Override
	public String toString() {
		return "Reponse [responseCode=" + responseCode + ", responseMessage=" + responseMessage + ", responseId="
				+ responseId + ", responseTime=" + responseTime + "]";
	}
}
