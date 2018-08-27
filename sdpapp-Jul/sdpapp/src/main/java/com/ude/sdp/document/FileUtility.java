package com.ude.sdp.document;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import com.ude.sdp.model.FileDB;

public class FileUtility {
	
	public byte[] getByte(String filepath) throws IOException {
		byte[] bFile = IOUtils.toByteArray(getClass().getClassLoader().getResourceAsStream(filepath));
		return bFile;
	}
	
	public double getSize(String filepath) {

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(filepath).getFile());
		double bytes = file.length();
		double kilobytes = (bytes / 1024);
		return kilobytes;
		
	}
	
	/*
	
	public String fileToPdf(FileDB fileDB) throws IOException {
		String tempPath = "temp/temp.pdf";
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(tempPath).getFile());
		FileUtils.writeByteArrayToFile(file, fileDB.getContent());
		return tempPath;
	}
	
	public String byteToDoc(FileDB fileDB) throws IOException {
		String tempPath = "temp/temp.doc";
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(tempPath).getFile());
		FileUtils.writeByteArrayToFile(file, fileDB.getContent());
		return tempPath;
	}
	
	public FileDB fileFromPath() throws IOException {
		PdfExtractor pdfEx = new PdfExtractor();
		FileUtility fileUtil = new FileUtility();
		String filepath = "file/test.pdf";
		FileDB file = new FileDB();
		
		String ext = FilenameUtils.getExtension(filepath);
		String name = FilenameUtils.getName(filepath);
		//Document doc = pdfEx.getPdfContent("file/test.pdf");
		
		file.setContent(fileUtil.getByte(filepath));
		file.setExtension(ext);
		file.setName(name);
		file.setPath(filepath);
		file.setSize(fileUtil.getSize(filepath));
		return file;
	}
	
	*/
	
}
