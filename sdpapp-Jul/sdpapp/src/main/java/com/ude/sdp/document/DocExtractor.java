package com.ude.sdp.document;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

import com.ude.sdp.model.Document;
import com.ude.sdp.model.Page;

public class DocExtractor {

	public String readDoc(String filepath) {

		File file = new File(filepath);
		String text = "";
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				text += line;
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return text;

	}
	
	public Document readDocFile(String filepath) {
		try
        {
			Document doc = new Document();
			List<Page> pages = new ArrayList<>();
            ClassLoader classLoader = getClass().getClassLoader();
    		File file = new File(classLoader.getResource(filepath).getFile());
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            HWPFDocument document = new HWPFDocument(fis);
            WordExtractor extractor = new WordExtractor(document);
            String[] paragraphs = extractor.getParagraphText();
            String text = Arrays.toString(paragraphs);
            Page page = new Page();
            page.setContent(text);
            pages.add(page);
            doc.setPages(pages);
            return doc;
        }
        catch (Exception exep)
        {
        	//return exep.toString();
        	Document doc = new Document();
        	return doc;
        }
	}
}
