package com.ude.sdp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REFERENCE")
public class Reference {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String title;
	
	private String year;
	
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getYear() {
		return year;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setYear(String year) {
		this.year = year;
	}
}
