package com.ude.sdp.dto;

public class UserDTO extends DTO {

	private String name;

	private String email;

	private String token;

	private String password;

	private String passwordGoogle;

	private String googleMail;

	private String secondName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserDTO(String email) {
		super();
		this.email = email;
	}

	public String getPasswordGoogle() {
		return passwordGoogle;
	}

	public void setPasswordGoogle(String passwordGoogle) {
		this.passwordGoogle = passwordGoogle;
	}

	public String getGoogleMail() {
		return googleMail;
	}

	public void setGoogleMail(String googleMail) {
		this.googleMail = googleMail;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public UserDTO(String email, String token) {
		super();
		this.email = email;
		this.token = token;
	}

	public UserDTO() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDTO(String name, String email, String token) {
		super();
		this.name = name;
		this.email = email;
		this.token = token;

	}

}