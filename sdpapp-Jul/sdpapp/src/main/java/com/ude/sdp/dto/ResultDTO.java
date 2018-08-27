package com.ude.sdp.dto;

import java.util.ArrayList;
import java.util.List;

public class ResultDTO {

	public int code;
	public String message;
	public List<DTO> result;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<DTO> getResult() {
		if (result == null)
			result = new ArrayList<DTO>();
		return result;
	}

	public void setResult(List<DTO> result) {
		this.result = result;
	}

	public ResultDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultDTO(int code, String message, List<DTO> result) {
		super();
		this.code = code;
		this.message = message;
		this.result = result;
	}

}