package com.example.demo.response;

import java.util.Objects;

import com.example.demo.model.Response;

public class deleteResponse extends Response {
	private String deleteId;

	public deleteResponse() {
		super();
	}

	public deleteResponse(String responseCode, String responseMessage, String responseId, String responseTime,String deleteId) {
		super(responseCode,responseMessage,responseId,responseTime);
		this.deleteId = deleteId;
	}

	public String getDeleteId() {
		return deleteId;
	}

	public void setDeleteId(String deleteId) {
		this.deleteId = deleteId;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(deleteId);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		deleteResponse other = (deleteResponse) obj;
		return Objects.equals(deleteId, other.deleteId);
	}

	@Override
	public String toString() {
		return "deleteResponse [deleteId=" + deleteId + "] " + super.toString();
	}
	
}
