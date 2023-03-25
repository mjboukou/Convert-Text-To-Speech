package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Document;

public class NewDocument implements ActionListener {
	
	private Document doc = new Document();
	private String author;
	private String title;
	private String date = doc.createDate();
	
	public NewDocument(Document doc, String title, String author) {
		this.doc = doc;
		this.title = title;
		this.author = author;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		doc.setDate(date);
	    doc.setTitle(title);
		doc.setAuthor(author);
	}

}
