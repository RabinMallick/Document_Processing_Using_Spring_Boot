package com.ude.sdp.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ude.sdp.document.FileUtility;
import com.ude.sdp.document.PdfExtractor;
import com.ude.sdp.model.Document;
import com.ude.sdp.model.FileDB;
import com.ude.sdp.model.Page;
import com.ude.sdp.repository.FileRepository;

@RestController
public class FileController {
	
	@Autowired
	FileRepository fileRepository;
	
	@RequestMapping("/save_pdf_file")
	public void savePdfFile() throws IOException, URISyntaxException {

		FileUtility fileUtil = new FileUtility();
		String filepath = "file/test.pdf";
		FileDB file = new FileDB();
		
		String ext = FilenameUtils.getExtension(filepath);
		String name = FilenameUtils.getName(filepath);
		
		file.setContent(fileUtil.getByte(filepath));
		file.setExtension(ext);
		file.setName(name);
		file.setPath(filepath);
		file.setSize(fileUtil.getSize(filepath));
		fileRepository.save(file);
		
	}
	
	@RequestMapping("/save_doc_file")
	public void saveDocFile() throws IOException, URISyntaxException {

		FileUtility fileUtil = new FileUtility();
		String filepath = "file/test2.doc";
		FileDB file = new FileDB();
		
		String ext = FilenameUtils.getExtension(filepath);
		String name = FilenameUtils.getName(filepath);
		
		file.setContent(fileUtil.getByte(filepath));
		file.setExtension(ext);
		file.setName(name);
		file.setPath(filepath);
		file.setSize(fileUtil.getSize(filepath));
		fileRepository.save(file);
		
	}
	
/*  @RequestMapping("/save_pdf_file")
	public void savePdfFile(String filepath) throws IOException {
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(filepath).getFile());
	    DiskFileItem fileItem = new DiskFileItem("file", "text/plain", false, file.getName(), (int) file.length() , file.getParentFile());
	    fileItem.getOutputStream();
	    MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
	    
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		ByteArrayInputStream stream = new ByteArrayInputStream(multipartFile.getBytes());
		
		FileDB fileObject = new FileDB();
		fileObject.setName(fileName);
		fileObject.setContent(IOUtils.toString(stream, "UTF-8"));
		fileObject.setExtension(FilenameUtils.getExtension(fileName));
		fileObject.setSize(multipartFile.getBytes().length / 1024);
		fileObject = fileRepository.save(fileObject);
		
	} */
	
	@RequestMapping("/get_all_file")
	public List<FileDB> getAllFile() {
		
		List<FileDB> files = fileRepository.findAll();
		//for(File file : files) {
			//byte[] data = file.getContent();
			//String textContent = new String(data, StandardCharsets.UTF_8);
			//texts.add(textContent);
		//}
		return files;
	}
	
	@RequestMapping(value = "/fetch/{id}", method = RequestMethod.GET)
	public List<Page> getData(@PathVariable String id) {
		 try {
				FileDB file = fileRepository.findOne(Long.parseLong(id));
				Document doc = file.getDocument();
				String text = "";
				List<Page> pages = doc.getPages();
				for(Page page : pages) {
					text += page.getContent();
				}
				
				return pages;
				
		    } catch (Exception e) {
		    	String ex = "File not found !";
		    	System.out.println(ex);
		    	List<Page> pages = new ArrayList<>();
		    	return pages;
		    }
	}
}
