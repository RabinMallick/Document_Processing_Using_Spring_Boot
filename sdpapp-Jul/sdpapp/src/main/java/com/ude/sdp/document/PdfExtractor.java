package com.ude.sdp.document;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.ude.sdp.model.Document;
import com.ude.sdp.model.FileDB;
import com.ude.sdp.model.Page;
import com.ude.sdp.model.Sentence;

public class PdfExtractor {
	public String ReadPdf() {
		String text = "";
		try
		{
			ClassLoader classLoader = getClass().getClassLoader();
			//Read file using PdfReader
			//PdfReader pdfReader = new PdfReader(classLoader.getResource("file/test.pdf").getFile());
			//text = pdfReader.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	 public Document ReadPdfSource(String filepath) {

		PdfReader reader;
		String textFromPage = "";
		FileDB file = new FileDB();
		ClassLoader classLoader = getClass().getClassLoader();
		File fileSource = new File(classLoader.getResource(filepath).getFile());
		Document doc = new Document();
		List<Page> pages = new ArrayList<>();

		try {
			
			reader = new PdfReader(fileSource.getPath());
			int pageNumber = reader.getNumberOfPages();
			doc.setNoOfPage(pageNumber);

			for(int i = 1; i<pageNumber-2;i++) {
				
				textFromPage = PdfTextExtractor.getTextFromPage(reader, i);
				List<Sentence> sentences = new ArrayList();
				String text = "";

				// split by whitespace
				String lines[] = textFromPage.split("\\r?\\n");

				for (String line : lines) {
					text += line;
					Sentence sentence = new Sentence();
					sentence.setSentence(line);
					sentences.add(sentence);
				}
				
				Page page = new Page();
				page.setContent(text);
				page.setNumPage(i);
				pages.add(page);
			}
			
			doc.setPages(pages);
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return doc;

	} 


	public Document getPdfContent(String filepath) {
		try {
			PdfReader reader = new PdfReader(filepath);
			StringBuffer sb = new StringBuffer();
			PdfReaderContentParser parser = new PdfReaderContentParser(reader);
			TextExtractionStrategy strategy;
			Document document = new Document();
			List<Page> pages = new ArrayList<>();

			for (int i = 1; i <= reader.getNumberOfPages(); i++) {
				strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
				String lines[] = strategy.getResultantText().split("\\r?\\n");
				List<Sentence> sentences = new ArrayList<Sentence>();
				String text = "";

				for (String line : lines) {
					Sentence sentence = new Sentence();
					sentence.setSentence(line);
					sentences.add(sentence);
					text += line;
				}

				Page page = new Page();
				page.setContent(text);
				page.setNumPage(i);
				pages.add(page);
				sb.append(strategy.getResultantText());
			}

			document.setPages(pages);
			document.setNoOfPage(reader.getNumberOfPages());
			reader.close();
			return document;
			
		} catch (IOException e) {
			throw new IllegalArgumentException("Not able to read file " + filepath, e);
		}
	}
	
	public String getPdfText(String filepath) {
		try {
			PdfReader reader = new PdfReader(filepath);
			StringBuffer sb = new StringBuffer();
			PdfReaderContentParser parser = new PdfReaderContentParser(reader);
			TextExtractionStrategy strategy;
			String text = "";
			for (int i = 1; i <= reader.getNumberOfPages(); i++) {
				strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
				//text += strategy.getResultantText();
				String pageContent = 
					  	PdfTextExtractor.getTextFromPage(reader, i);
				text += pageContent;
			}
			reader.close();
			return text;
		} catch (IOException e) {
			return "File not found";
		}
		
	}


	 /*public Document readPdfBox(String filepath) throws IOException {

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(filepath).getFile());

		PDDocument document = PDDocument.load(file);
		int noOfPages = document.getNumberOfPages();
		FileDB fileDB = new FileDB();
		Document doc = new Document();
		List<Page> pages = new ArrayList<>();

		document.getClass();

		for(int i = 0; i<noOfPages; i++) {
			PDFTextStripper reader = new PDFTextStripper();
			reader.setStartPage(i);
			reader.setEndPage(i);
			String pageText = reader.getText(document);
			List<Sentence> sentences = new ArrayList<>();
			String text = "";
			
			// split by whitespace
			String lines[] = pageText.split("\\r?\\n");

			for (String line : lines) {
				text += line;
				Sentence sentence = new Sentence();
				sentence.setSentence(line);
				sentences.add(sentence);
			}
			
			Page page = new Page();
			page.setContent(pageText);
			pages.add(page);
		}

		if (!document.isEncrypted()) {

			PDFTextStripperByArea stripper = new PDFTextStripperByArea();
			stripper.setSortByPosition(true);

			PDFTextStripper tStripper = new PDFTextStripper();

			String pdfFileInText = tStripper.getText(document);
			//System.out.println("Text:" + st);

			// split by whitespace
			String lines[] = pdfFileInText.split("\\r?\\n");
			for (String line : lines) {
				text +="<br> "+ line;
			}

		}
		document.close();

		return doc;
	}*/

}
