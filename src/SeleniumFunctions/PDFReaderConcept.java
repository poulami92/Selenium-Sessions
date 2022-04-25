package SeleniumFunctions;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.fontbox.cmap.CMapParser;

public class PDFReaderConcept{
	
	public static void main(String[] args) throws IOException {
		
   //PDF get opened in browser tab		
	
	URL url = new URL("https://www.betterteam.com/download/job-application-form-template-download-standard-20170814.pdf");
	
	InputStream is = url.openStream();   //to read data from pdf file
	
	BufferedInputStream fileParse = new BufferedInputStream(is);
	
	//PDF gets downloaded in local
	
	//File fileParse = new File("D://Sample.pdf");
	
	PDDocument document = null;
	
	document=PDDocument.load(fileParse);
	
	String pdfContent= new PDFTextStripper().getText(document);
	
	System.out.println(pdfContent);

  }
	
}