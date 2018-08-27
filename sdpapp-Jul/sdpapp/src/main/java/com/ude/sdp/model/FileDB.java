package com.ude.sdp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.ude.sdp.document.DocExtractor;
import com.ude.sdp.document.PdfExtractor;


@Entity
@Table(name = "FILE")
public class FileDB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "FILEID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long fileID;
	
	@Lob
	@Column(name = "CONTENT")
	private byte[] content;
	

	@Column(name = "NAME")
	private String name;

	@Column(name = "TO_ANALIZE")
	private boolean toAnalize;

	@Column(name = "HASH")
	private String hash;

	@Column(name = "EXTENSION")
	private String extension;

	@Column(name = "SIZE")
	private double size;

	@Column(name = "LINK_TO_DRIVE_FILE")
	private String linkToDriveFile;
	
	@Column(name="PATH")
	private String path;

	public long getFileID() {
		return fileID;
	}

	public void setFileID(long fileID) {
		this.fileID = fileID;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isToAnalize() {
		return toAnalize;
	}

	public void setToAnalize(boolean toAnalize) {
		this.toAnalize = toAnalize;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getLinkToDriveFile() {
		return linkToDriveFile;
	}

	public void setLinkToDriveFile(String linkToDriveFile) {
		this.linkToDriveFile = linkToDriveFile;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public Document getDocument() {
		Document doc = new Document();
		if(this.extension.toUpperCase().equals("PDF")) {
			PdfExtractor pdfEx = new PdfExtractor();
			doc = pdfEx.ReadPdfSource(this.path);
			doc.setIdFile(this.fileID);
		}
		else if(this.extension.toUpperCase().equals("DOC") || this.extension.toUpperCase().equals("DOCX")) {
			DocExtractor docEx = new DocExtractor();
			doc = docEx.readDocFile(this.path);
			doc.setIdFile(this.fileID);
		}
		
		return doc;
	}

}
