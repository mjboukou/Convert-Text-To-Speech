package model;

import java.util.ArrayList;

import encodingstrategies.EncodingStrategy;
import text2speechapis.TextToSpeechAPI;
import text2speechapis.TextToSpeechAPIFactory;

public class Line {
	private ArrayList<String> words;
	private EncodingStrategy encodingStrategy;
	private TextToSpeechAPI audioManager;
	private TextToSpeechAPIFactory apiFactory; 

	public Line() {
		words = new ArrayList<String>();
		apiFactory = new TextToSpeechAPIFactory();
		audioManager = apiFactory.createTTSAPI("freeTTS");
	}
	public void addLine(String string) {
		String [] array = string.split(" ");
		for (int i=0;i<array.length;i++) {
			words.add(array[i]);
		}
	}
	public void playLine() {
		String contents="";
		for (int i = 0;i<words.size();i++) {
			contents = contents + words.get(i);
		}

		audioManager.play(contents);
	}
	public void playReverseLine() {
		String contents="";
		for(int i=0;i<words.size();i++) {
			contents = contents + words.get(i);
		}
		byte [] strAsByteArray3 = contents.getBytes(); 
		  
        byte [] result =  
                   new byte [strAsByteArray3.length]; 
  
        // Store result in reverse order into the 
        // result byte[] 
        for (int j = 0; j<strAsByteArray3.length; j++) {
            result[j] = strAsByteArray3[strAsByteArray3.length-j-1]; 
        }
		audioManager.play(new String(result));
	}
	public void playEncodedLine() {
		String contents="";
		for(int i=0;i<words.size();i++) {
			String encodedline = encodingStrategy.encode(words.get(i));
			contents =  contents + encodedline;
		}
		audioManager.play(contents);
	}
	public void tuneEncodingStrategy(EncodingStrategy e) {
		encodingStrategy = e;
	}
}
