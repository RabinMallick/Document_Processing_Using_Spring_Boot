package com.ude.sdp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class Sentence implements Serializable {

	private long idFile;
	
	private long idPage;
	
	private String sentence;

	public long getIdFile() {
		return idFile;
	}

	public long getIdPage() {
		return idPage;
	}

	public String getSentence() {
		return sentence;
	}

	public void setIdFile(long idFile) {
		this.idFile = idFile;
	}

	public void setIdPage(long idPage) {
		this.idPage = idPage;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
}
