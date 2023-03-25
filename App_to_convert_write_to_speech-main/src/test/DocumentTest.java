package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encodingstrategies.StrategiesFactory;
import model.Document;
import model.Line;

class DocumentTest {
	
	int line=1;
	Document doc;
	StrategiesFactory strategy;
	ArrayList<Line> contents;
	String sentence= "Aris gouvas\n"
					+"Mixalis boukou\n" 
					+"Vasiliki xatz";
	
	@BeforeEach
	void setUp() throws Exception {
		doc= new Document();
		doc.addContents(sentence);
		strategy = new StrategiesFactory();
		doc.tuneEncodingStrategy(strategy.createStrategy("Rot13"));
	}
	@Test
	void testAddContents() {
		doc.addContents(sentence);
	}
	//Contents
	@Test
	void testPlayContents() {
		doc.playContents();
	}
	@Test
	void testPlayReverseContents() {
		doc.playReverseContents();
	}
	@Test
	void testPlayEncodedContents() {
		doc.playEncodedContents();
	}
	//Line
	@Test
	void testPlayLine() {
		doc.playLine(line);
	}
	@Test
	void testPlayReversedLine() {
		doc.playReverseLine(line);
	}
	@Test
	void testPlayEncodedLine() {
		doc.playEncodedLine(line);
	}
	@Test
	void testTitle() {
		doc.setTitle("Title");
		assertEquals(doc.getTitle(),"Title");
	}
	@Test
	void testAuthor() {
		doc.setAuthor("Author");
		assertEquals(doc.getAuthor(),"Author");
	}
	@Test
	void testDate() {
		String date = doc.createDate();
		doc.setDate(date);
		assertEquals(doc.getDate(),date);
	}
}
