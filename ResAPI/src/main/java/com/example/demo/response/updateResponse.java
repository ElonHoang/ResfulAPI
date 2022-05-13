package com.example.demo.response;

import java.util.Objects;

import com.example.demo.model.Response;

public class updateResponse extends Response {
	private String updateId;
	public updateResponse() {
		super();
	}
	public updateResponse(String responseCode, String responseMessage, String responseId, String responseTime,String updateId) {
		super(responseCode, responseMessage,responseId,responseTime);
		this.updateId = updateId;
	}
	
	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(updateId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		updateResponse other = (updateResponse) obj;
		return Objects.equals(updateId, other.updateId);
	}
	@Override
	public String toString() {
		return "updateResponse [updateId=" + updateId + "] " + super.toString();
	}

	
}
