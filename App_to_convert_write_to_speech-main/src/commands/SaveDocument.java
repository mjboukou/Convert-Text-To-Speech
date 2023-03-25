package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

import model.Document;

public class SaveDocument implements ActionListener {

	private JTextArea textArea;
	private Document doc;
	
	public SaveDocument(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		  JFileChooser chooser = new JFileChooser();
		  int actionDialog = chooser.showOpenDialog(null);
	      if (actionDialog != JFileChooser.APPROVE_OPTION) {
	         return;
	      }

	      File file = new File(chooser.getSelectedFile() + ".txt");
	      BufferedWriter outFile = null;
	      
	      DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	      Date today = Calendar.getInstance().getTime();
	      String reportDate = df.format(today);
	      String dateToPrintToFile = reportDate;

	      doc.setDate(dateToPrintToFile);
	      
	      try {
	    	  outFile = new BufferedWriter(new FileWriter(file));
	    	  outFile.write(dateToPrintToFile + "\n\n");
	    	  textArea.write(outFile);  
	    	  outFile.close();
	      } catch (IOException ex) {
	         ex.printStackTrace();
	      }
	}
}