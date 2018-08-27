package com.ude.sdp.dto;

public class FileDTO extends DTO {

	private long idFile;

	private String content;

	private String name;

	private boolean toAnalize;

	private String hash;

	private String extension;

	private double size;

	private String downloadURL;

	public long getIdFile() {
		return idFile;
	}

	public void setIdFile(long idFile) {
		this.idFile = idFile;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
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

	public String getDownloadURL() {
		return downloadURL;
	}

	public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}

	public FileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileDTO(String name, String extension, double size, String downloadURL) {
		super();
		this.name = name;
		this.extension = extension;
		this.size = size;
		this.downloadURL = downloadURL;
	}
	

	public FileDTO(long idFile, String content, String name, boolean toAnalize, String hash, String extension,
			double size, String downloadURL) {
		super();
		this.idFile = idFile;
		this.content = content;
		this.name = name;
		this.toAnalize = toAnalize;
		this.hash = hash;
		this.extension = extension;
		this.size = size;
		this.downloadURL = downloadURL;
	}

	public FileDTO(String name) {
		super();
		this.name = name;
	}
	
	

}