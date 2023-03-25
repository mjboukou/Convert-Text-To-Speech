package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

import model.Document;
import model.Line;

public class OpenDocument implements ActionListener {

	private JTextArea textArea;
	private Document doc = new Document();
	
	public OpenDocument(JTextArea textArea) {
		this.textArea = textArea;
	}

	public void actionPerformed(ActionEvent e) {
	 	JFileChooser fileCh = new JFileChooser();
	 	StringBuilder stringB = new StringBuilder();
		try
		{
		 	if (fileCh.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
	
		 				File file = fileCh.getSelectedFile();
		 				Scanner input = new Scanner(file);
		 				while(input.hasNextLine()){
		 					stringB.append(input.nextLine()+ "\n");
		 					Line newLine = new Line();
		 					newLine.addLine(stringB.toString());
		 				}
		 				input.close();
		 				doc.addContents(stringB.toString());
		 				textArea.setText(stringB.toString());
		 	}
		 	else{
		 		stringB.append("No file was selected");
		 	}
		}catch(IOException e1)
		{
			e1.printStackTrace();
		}
	}
}
	    
