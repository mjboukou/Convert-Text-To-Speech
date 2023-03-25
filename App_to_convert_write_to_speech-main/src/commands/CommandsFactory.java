package commands;

import javax.swing.JTextArea;

import model.Document;

import java.awt.event.ActionListener;


public class CommandsFactory {

	public ActionListener createCommand(String arg, JTextArea textArea, Integer rate, Integer pitch, Integer volume,Document doc, String title, String author) {
		if(arg.equals("saveDocument"))
			return new SaveDocument(textArea);
		if(arg.equals("newDocument"))
			return new NewDocument(doc, title, author);
		if(arg.equals("lineToSpeech"))
			return new LineToSpeech();
		if(arg.equals("replayCommand"))
			return new ReplayCommand();
		if(arg.equals("openDocument"))
			return new OpenDocument(textArea);
		if(arg.equals("editDocument"))
			return new EditDocument();
		if(arg.equals("tuneAudio"))
			return new TuneAudio(rate,pitch,volume);
		return null;
	}

}
