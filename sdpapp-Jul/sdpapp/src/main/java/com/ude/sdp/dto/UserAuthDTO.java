package com.ude.sdp.dto;

import java.util.ArrayList;
import java.util.List;

public class UserAuthDTO extends DTO{

	private String mail;
	private String password;
	private String token;
	private List<RoleDTO> roleDTOs;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<RoleDTO> getRoleDTOs() {
		if(roleDTOs==null)
			roleDTOs = new ArrayList<RoleDTO>();
		return roleDTOs;
	}

	public void setRoleDTOs(List<RoleDTO> roleDTOs) {
		this.roleDTOs = roleDTOs;
	}

	public UserAuthDTO(String mail, String password, String token, List<RoleDTO> roleDTOs) {
		super();
		this.mail = mail;
		this.password = password;
		this.token = token;
		this.roleDTOs = roleDTOs;
	}

	public UserAuthDTO() {
		super();
	}
	
	

}
