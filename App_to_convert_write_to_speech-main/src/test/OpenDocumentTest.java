package test;

import javax.swing.JTextArea;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import commands.OpenDocument;

class OpenDocumentTest {
	OpenDocument open;
	
	@BeforeEach
	void setUp() throws Exception {
		JTextArea textArea = null;
		open = new OpenDocument(textArea);
	}

	@Test
	void Test() {
		open.actionPerformed(null);
		
	}

}
