package com.ude.sdp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ude.sdp.document.DocExtractor;
import com.ude.sdp.document.PdfExtractor;
import com.ude.sdp.model.Document;
import com.ude.sdp.model.Page;

/*** This is a test Controller ***/

@RestController
public class Controller {

	@RequestMapping("/show_pdf")
	public String showPdf() {
		PdfExtractor pdfEx = new PdfExtractor();
		//FileDB file = pdfEx.ReadPdfSource("file/test.pdf");
		//FileDB file = new FileDB();
		String text = "";
		Document document = pdfEx.ReadPdfSource("file/check.pdf");
		List<Page> pages = document.getPages();
		for(Page page : pages) {
			text += "<br>"+page.getNumPage()+" <br>"+page.getContent();
		}
		return text;
	}
	
	@RequestMapping("/show_text")
	public Document showPdfText() {
		PdfExtractor pdfEx = new PdfExtractor();
		return pdfEx.ReadPdfSource("file/check.pdf");
	}
	
	@RequestMapping("/show_doc_text")
	public Document showDoc(){
		DocExtractor docEx = new DocExtractor();
		return docEx.readDocFile("file/template.doc");
	}
	
}
