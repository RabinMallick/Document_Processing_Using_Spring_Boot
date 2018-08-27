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

public class Document implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	private long idDoc;
	
	private long idFile;
	
	private int noOfPage;
	
	private List<Page> pages = new ArrayList<>();

	public long getIdFile() {
		return idFile;
	}
	
	public List<Page> getPages() {
		if(pages == null)
			pages = new ArrayList<>();
		return pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

	public void setIdFile(long idFile) {
		this.idFile = idFile;
	}

	public long getIdDoc() {
		return idDoc;
	}

	public int getNoOfPage() {
		return noOfPage;
	}

	public void setIdDoc(long idDoc) {
		this.idDoc = idDoc;
	}

	public void setNoOfPage(int noOfPage) {
		this.noOfPage = noOfPage;
	}
	
	
}
