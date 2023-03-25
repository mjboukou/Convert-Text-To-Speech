package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import encodingstrategies.EncodingStrategy;
import text2speechapis.TextToSpeechAPI;
import text2speechapis.TextToSpeechAPIFactory;

public class Document {
	private EncodingStrategy encodingStrategy;
	private TextToSpeechAPI audioManager;
	private TextToSpeechAPIFactory apiFactory; 
	private ArrayList<Line> contents;
	
	private String date;
	private String title;
	private String author;
	
	public Document() {
		contents = new ArrayList<Line>();
		apiFactory = new TextToSpeechAPIFactory();
		audioManager = apiFactory.createTTSAPI("freeTTS");
	}
	public void addContents(String str) {
		String [] array = str.split("\n");
		for (int i=0;i<array.length;i++) {
			Line newLine = new Line();
			newLine.addLine(array[i]);
			contents.add(newLine);
		}
	}
	public void getContents() {
		
	}
	public void playContents() {
		
		for(int i =0;i<contents.size();i++) {
			contents.get(i).playLine();
		}
		
	}
	public void playReverseContents() {
		String reverseContents = "";
		for(int i=0;i<contents.size();i++) {
			String con = String.valueOf(contents.get(i));
			reverseContents = reverseContents + con;
		}
		byte [] strAsByteArray = reverseContents.getBytes(); 
		  
        byte [] result =  
                   new byte [strAsByteArray.length]; 
  
        // Store result in reverse order into the 
        // result byte[] 
        for (int j = 0; j<strAsByteArray.length; j++) {
            result[j] = strAsByteArray[strAsByteArray.length-j-1]; 
        }
		audioManager.play(new String(result));
	}
	public void playEncodedContents() {
		String encontents = "";
		for (int i=0;i<contents.size();i++) {
			String encontents1 = String.valueOf(contents.get(i));
			String encontents2 = encodingStrategy.encode(encontents1);
			encontents = encontents+ encontents2;
		}
		audioManager.play(encontents);
		
	}
	public void playLine(int line) {
		contents.get(line).playLine();
	}
	public void playReverseLine(int line) {
		contents.get(line).playReverseLine();
	}
	public void playEncodedLine(int line) {
		contents.get(line).playEncodedLine();
	}
	public void tuneEncodingStrategy(EncodingStrategy e) {
		encodingStrategy = e;
	}
	
	//Date
	public String createDate() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	    Date today = Calendar.getInstance().getTime();
	    String reportDate = df.format(today);
	    String date = reportDate;
	    return date;
		
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate() {
		return this.date;
	}
	
	//Title
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return this.title;
	}
	
	//Author
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return this.author;
	}
}
