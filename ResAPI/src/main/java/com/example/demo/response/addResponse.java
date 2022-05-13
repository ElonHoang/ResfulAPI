package com.example.demo.response;

import java.util.Objects;

import com.example.demo.model.Response;

public class addResponse extends Response {
	private String addId;

	public addResponse() {
		super();
	}

	public addResponse(String responseCode, String responseMessage, String responseId, String responseTime, String addId) {
		super(responseCode,responseMessage,responseId,responseTime);
		this.addId = addId;
	}

	public String getAddId() {
		return addId;
	}

	public void setAddId(String addId) {
		this.addId = addId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(addId);
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
		addResponse other = (addResponse) obj;
		return Objects.equals(addId, other.addId);
	}

	@Override
	public String toString() {
		return  "addResponse [addId=" + addId + "] " + super.toString();
	}

}
