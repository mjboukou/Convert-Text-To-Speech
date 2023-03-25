package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import commands.NewDocument;
import model.Document;

class NewDocumentTest {
	NewDocument newdoc;
	private Document doc = new Document();
	private String title = "Title";
	private String author = "Author";
	
	@BeforeEach
	void setUp() throws Exception {
		newdoc = new NewDocument(doc, title, author);
	}
	@Test
	void testnDoc() {
		newdoc.actionPerformed(null);
	}
	@Test
	void testDate() {
		String date = doc.createDate();
		doc.setDate(date);
		assertEquals(doc.getDate(),date);
	}
	@Test
	void testTitle() {
		doc.setTitle(title);
		assertEquals(doc.getTitle(),title);
	}
	@Test
	void testAuthor() {
		doc.setAuthor(author);
		assertEquals(doc.getAuthor(),author);
	}

}
