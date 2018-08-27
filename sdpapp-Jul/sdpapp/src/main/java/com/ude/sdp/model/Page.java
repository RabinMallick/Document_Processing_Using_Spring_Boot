package com.ude.sdp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

public class Page implements Serializable {
	
	private long idPage;

	private long idFIle;

	private int numPage;
	
	private String content;

	public long getIdFIle() {
		return idFIle;
	}

	public long getIdPage() {
		return idPage;
	}

	public int getNumPage() {
		return numPage;
	}

	public String getContent() {
		return content;
	}

	public List<Sentence> getLine() {
		
		List<Sentence> sentences = new ArrayList();
		String lines[] = this.content.split("\\.");

		for (String line : lines) {
			Sentence sentence = new Sentence();
			sentence.setSentence(line);
			sentences.add(sentence);
		}
		
		return sentences;
	}

	public void setIdFIle(long idFIle) {
		this.idFIle = idFIle;
	}

	public void setIdPage(long idPage) {
		this.idPage = idPage;
	}

	public void setNumPage(int numPage) {
		this.numPage = numPage;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
