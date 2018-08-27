package com.ude.sdp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class Author {

	private int id;
	
	private String name;
	
	private String secondName;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public Author() {
		super();
	}
	
	public Author(String name, String secondName) {
		super();
		this.name = name;
		this.secondName = secondName;
	}
	
	public String getSecondName() {
		return secondName;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
}
