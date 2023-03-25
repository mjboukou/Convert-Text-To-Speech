package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import commands.CommandsFactory;
import model.Document;
import text2speechapis.FreeTTSAdapter;
import text2speechapis.TextToSpeechAPIFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Text2SpeechEditorView {

	private String clipBoard;
	private Integer rate;
	private Integer pitch;
	private Integer volume;
	private String title;
	private String author;
	private JFrame frame;
	private JMenuBar menuBar;
	private JTextArea textArea; 
	private JMenu file;
	private JMenuItem NewFile;
	private JMenuItem OpenFile;
	private JMenuItem SaveFile;
	private JMenuItem Exit;
	private JMenu Edit;
	private JMenuItem Cut;
	private JMenuItem Copy;
	private JMenuItem Paste;
	private JMenuItem SelectAll;
	private JMenu Encode;
	private JButton Speech;
	private JTextField textFRate;
	private JTextField textFVolume;
	private JTextField textFPitch;
	
	FreeTTSAdapter speak = new FreeTTSAdapter();
	CommandsFactory comFactory = new CommandsFactory();
	TextToSpeechAPIFactory TextSpFactory = new TextToSpeechAPIFactory();
	private JButton Set;

	private Document doc = new Document();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Text2SpeechEditorView window = new Text2SpeechEditorView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Text2SpeechEditorView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 535, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		textArea = new JTextArea();
		textArea.setBounds(173, 34, 336, 151);
		frame.getContentPane().add(textArea);
		
		JLabel Pitch = new JLabel("Pitch:");
		Pitch.setHorizontalAlignment(SwingConstants.LEFT);
		Pitch.setFont(new Font("Verdana Pro", Font.PLAIN, 12));
		Pitch.setBounds(10, 66, 46, 23);
		frame.getContentPane().add(Pitch);
		
		JLabel Volume = new JLabel("Volume:");
		Volume.setHorizontalAlignment(SwingConstants.LEFT);
		Volume.setFont(new Font("Verdana Pro", Font.PLAIN, 12));
		Volume.setBounds(10, 100, 57, 23);
		frame.getContentPane().add(Volume);
		
		JLabel Rate = new JLabel("Rate:");
		Rate.setHorizontalAlignment(SwingConstants.LEFT);
		Rate.setFont(new Font("Verdana Pro", Font.PLAIN, 12));
		Rate.setBounds(10, 32, 46, 23);
		frame.getContentPane().add(Rate);
		
		
		textFVolume = new JTextField();
		textFVolume.setColumns(10);
		textFVolume.setBounds(63, 102, 86, 20);
		frame.getContentPane().add(textFVolume);

		
		textFPitch = new JTextField();
		textFPitch.setColumns(10);
		textFPitch.setBounds(63, 68, 86, 20);
		frame.getContentPane().add(textFPitch);

		textFRate = new JTextField();
		textFRate.setBounds(63, 34, 86, 20);
		frame.getContentPane().add(textFRate);
		textFRate.setColumns(10);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		file = new JMenu("File");
		menuBar.add(file);
		
		NewFile = new JMenuItem("New ");
		NewFile.setIcon(new ImageIcon(Text2SpeechEditorView.class.getResource("/view/new.png")));
		NewFile.setSelectedIcon(new ImageIcon(Text2SpeechEditorView.class.getResource("/view/new.png")));
		file.add(NewFile);
		
		OpenFile = new JMenuItem("Open file");
		OpenFile.setIcon(new ImageIcon(Text2SpeechEditorView.class.getResource("/view/open.png")));
		OpenFile.setSelected(true);
		OpenFile.setSelectedIcon(new ImageIcon(Text2SpeechEditorView.class.getResource("/view/open.png")));
		OpenFile.addActionListener(comFactory.createCommand("openDocument",textArea,rate,pitch,volume,doc,title,author));
		file.add(OpenFile);
		
		JMenuItem EditContentsFile = new JMenuItem("Edit Contents");
		EditContentsFile.setIcon(new ImageIcon(Text2SpeechEditorView.class.getResource("/view/edit.png")));
		EditContentsFile.setSelectedIcon(new ImageIcon(Text2SpeechEditorView.class.getResource("/view/edit.png")));
		file.add(EditContentsFile);
		
		
		SaveFile = new JMenuItem("Save");
		SaveFile.setIcon(new ImageIcon(Text2SpeechEditorView.class.getResource("/view/save.png")));
		SaveFile.setSelectedIcon(new ImageIcon(Text2SpeechEditorView.class.getResource("/view/save.png")));
		SaveFile.setSelected(true);
		SaveFile.addActionListener(comFactory.createCommand("saveDocument",textArea,rate,pitch,volume,doc,title,author));
		file.add(SaveFile);
		
		Exit = new JMenuItem("Exit");
		Exit.addActionListener((event) -> System.exit(0));
		file.add(Exit);
		
		Edit = new JMenu("Edit");
		Edit.addActionListener(comFactory.createCommand("editDocument",textArea,rate,pitch,volume,doc,title,author));
		menuBar.add(Edit);
		
		Cut = new JMenuItem("cut");
		Cut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clipBoard = new String(textArea.getSelectedText());
				textArea.replaceRange("", textArea.getSelectionStart(), textArea.getSelectionEnd());
			}
		});
		
		Edit.add(Cut);
		
		Copy = new JMenuItem("copy");
		Copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clipBoard = new String(textArea.getSelectedText());
			}
		});
		Edit.add(Copy);
		
		Paste = new JMenuItem("paste");
		Paste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(clipBoard != null) {
			            textArea.replaceRange(clipBoard, textArea.getSelectionStart(),
			                              textArea.getSelectionEnd());
				 }
			}
		});
		Edit.add(Paste);
		
		SelectAll = new JMenuItem("select All");
		SelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.selectAll();
			}
		});
		Edit.add(SelectAll);
		
		JMenu Play = new JMenu("Play");
		menuBar.add(Play);
		
		JMenuItem playLine = new JMenuItem("Line");
		Play.add(playLine);
		
		JMenuItem playContents = new JMenuItem("Contents");
		Play.add(playContents);
		
		Encode = new JMenu("Endoce");
		menuBar.add(Encode);
		
		JMenuItem Rot13 = new JMenuItem("Rot13");
		Encode.add(Rot13);
		
		JMenuItem Atbash = new JMenuItem("Atbash");
		Encode.add(Atbash);
		frame.getContentPane().setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Arial", Font.PLAIN, 12));
		btnExit.addActionListener((event) -> System.exit(0));
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(417, 205, 92, 23);
		frame.getContentPane().add(btnExit);
		
		JButton Clear = new JButton("Clear");
		Clear.setFont(new Font("Arial", Font.PLAIN, 12));
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(" ");
			}
		});
		Clear.setBackground(Color.WHITE);
		Clear.setBounds(315, 205, 92, 23);
		frame.getContentPane().add(Clear);
		
		Speech = new JButton("Speech");
		Speech.setFont(new Font("Arial", Font.PLAIN, 12));
		Speech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clipBoard = textArea.getText();
				speak.play(clipBoard);
		}});
		Speech.setBackground(Color.WHITE);
		Speech.setBounds(209, 205, 92, 23);
		frame.getContentPane().add(Speech);
		
		JLabel textLabel = new JLabel("Text");
		textLabel.setHorizontalAlignment(SwingConstants.CENTER);
		textLabel.setFont(new Font("Verdana Pro", Font.BOLD, 13));
		textLabel.setBounds(173, 0, 336, 23);
		frame.getContentPane().add(textLabel);
		
		JLabel Audio = new JLabel("Audio");
		Audio.setHorizontalAlignment(SwingConstants.CENTER);
		Audio.setFont(new Font("Verdana Pro", Font.BOLD, 13));
		Audio.setBounds(10, 0, 139, 23);
		frame.getContentPane().add(Audio);
		
		JButton Reset = new JButton("Reset");
		Reset.setHorizontalAlignment(SwingConstants.LEFT);
		Reset.setFont(new Font("Arial", Font.PLAIN, 12));
		Reset.setBackground(Color.WHITE);
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFVolume.setText(" ");
				textFPitch.setText(" ");
				textFRate.setText(" ");
			}
		});
		Reset.setBounds(10, 134, 65, 23);
		frame.getContentPane().add(Reset);
		
		Set = new JButton("Set");
		Set.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rate = Integer.parseInt(textFRate.getText());
				pitch = Integer.parseInt(textFPitch.getText());
				volume = Integer.parseInt(textFVolume.getText());
				Set.addActionListener(comFactory.createCommand("tuneAudio",textArea,rate,pitch,volume,doc,title,author));
				speak.play(clipBoard);
				speak.setVolume(volume);
			}
		});
		Set.setFont(new Font("Arial", Font.PLAIN, 12));
		Set.setBounds(84, 134, 65, 23);
		frame.getContentPane().add(Set);
		
		
	}
}
