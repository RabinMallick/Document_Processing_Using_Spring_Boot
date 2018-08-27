package com.ude.sdp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USER")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ENABLE")
	private boolean enable;

	@Column(name = "SECOND_NAME")
	private String secondName;

	@Column(name = "EMAIL", unique = true)
	private String email;

	@Column(name = "GOOGLE_MAIL")
	private String googleMail;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "PASSWORD_GOOGLE")
	private String passwordGoogle;

	@Column(name = "LAST_ACCESS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastAccess;

	@Column(name = "SESSION_EXPIRED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date sessionExpiredDate;

	@Column(name = "JWT_TOKEN")
	private String jwtToken;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "FILE")
	private List<FileDB> files = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "ROLE")
	private List<Role> roles = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGoogleMail() {
		return googleMail;
	}

	public void setGoogleMail(String googleMail) {
		this.googleMail = googleMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordGoogle() {
		return passwordGoogle;
	}

	public void setPasswordGoogle(String passwordGoogle) {
		this.passwordGoogle = passwordGoogle;
	}

	public Date getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}

	public Date getSessionExpiredDate() {
		return sessionExpiredDate;
	}

	public void setSessionExpiredDate(Date sessionExpiredDate) {
		this.sessionExpiredDate = sessionExpiredDate;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public List<FileDB> getFiles() {
		if (files == null)
			files = new ArrayList<FileDB>();
		return files;
	}

	public void setFiles(List<FileDB> files) {
		this.files = files;
	}

	public List<Role> getRoles() {
		if (roles == null)
			roles = new ArrayList<Role>();
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}