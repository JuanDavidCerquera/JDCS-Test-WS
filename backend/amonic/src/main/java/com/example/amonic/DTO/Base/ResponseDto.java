package com.example.amonic.DTO.Base;

public class ResponseDto<T> {

	private Boolean status;
	private T data;
	private String message;

	public ResponseDto(String message, T data, Boolean status) {
		this.data = data;
		this.message = message;
		this.status = status;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
