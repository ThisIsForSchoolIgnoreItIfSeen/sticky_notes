//GITHUB TAG

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.util.ArrayList;
import java.util.Iterator;

class Notes_Display implements DocumentListener, WindowListener {
	StickyNotes root;
	JFrame console = new JFrame("note #n");
	NotesPanel panel = new NotesPanel();
	JTextArea title = new JTextArea("type something");
	JTextArea content = new JTextArea("type something");
	Notes data;
	Container north = new Container();
	Container east = new Container();
	Container south = new Container();
	Container west = new Container();
	
	public Notes_Display(StickyNotes master, Notes stuff) {
		//takes in
		root = master;
		data = stuff;
		title.setText(data.title);
		title.setLineWrap(true);
		title.setWrapStyleWord(true);
		content.setText(data.content);
		content.setLineWrap(true);
		content.setWrapStyleWord(true);
		console.setSize(600, 800);
		console.setLayout(new BorderLayout());
		//console.add(panel, BorderLayout.CENTER);
		console.add(north, BorderLayout.NORTH);
		console.add(east, BorderLayout.EAST);
		console.add(west, BorderLayout.WEST);
		console.add(south, BorderLayout.SOUTH);
		north.setLayout(new GridLayout(1,1));
		south.setLayout(new GridLayout(1,1));
		north.add(title);
		JScrollPane scroll = new JScrollPane(content);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		console.add(scroll, BorderLayout.CENTER);
		title.getDocument().addDocumentListener(this);
		content.getDocument().addDocumentListener(this);
		console.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		console.addWindowListener(this);
		console.setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		root.deleteNote(data);
		console.dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertUpdate(DocumentEvent e) {
		data.title=title.getText();
		data.content=content.getText();
		root.updateActiveNotes();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		data.title=title.getText();
		data.content=content.getText();
		root.updateActiveNotes();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		data.title=title.getText();
		data.content=content.getText();
		root.updateActiveNotes();
	}
}

public class StickyNotes implements ActionListener, MouseListener, WindowListener {
	//if this your main class make it contain a arraylist of note objects for convinient storage,
	// whenever a note is instantiated, add another object to the arraylist
	//at start of runtime, when prior session notes are retrieveed, they will be stored in this arraylist

	//include an actionlistener for jpanel closed, if user presses x on main jpanel it should call the
	// storeInFiles function from data_management

	//also make sure that if a note panel is deleted the action taken is consistient, eihter it deletes the note
	// from the arraylist as well or it keeps it htere and there is osme way for the user to retrieve the note
	// if you go with option #2, make sure there is a different way for users to delete notes,
	// what exactly that is I leave to your imagination
	
	JFrame console = new JFrame("JNotes Console");
	NotesPanel panel = new NotesPanel();
	JButton addNoteB = new JButton("ADD A NOTE");
	ArrayList<JFrame> notePanels = new ArrayList<JFrame>();
	ArrayList<Notes> notes;
	JLabel title = new JLabel("JNotes Console");
	//list active notes' titles
	JLabel activeNotes = new JLabel("");
	Container north = new Container();
	Container south = new Container();
	Container body = new Container();
	data_management longTermStorer = new data_management();
	
	public StickyNotes() {
		console.setSize(600, 800);
		console.setLayout(new BorderLayout());
		console.add(panel, BorderLayout.CENTER);
		north.setLayout(new GridLayout(2,1));
		north.add(addNoteB);
		north.add(activeNotes);
		south.setLayout(new GridLayout(1,1));
		addNoteB.addActionListener(this);
		
		console.add(north, BorderLayout.NORTH);

		console.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		console.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				exitProcedure();
			}
		});
		console.setVisible(true);
		notes = longTermStorer.retrieveNotes();
		if (notes != null) {
			for (Notes i : notes) {
				instantiateNote(i);
			}
		} else {
			notes = new ArrayList<Notes>();
		}
	}
	public void exitProcedure() {
		longTermStorer.storeInFiles(notes);
		System.exit(0);
	}
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(addNoteB)) {//When the add note button is pressed
			//adda new note to arraylist of notes, create a new jpanel passing self and new note as arguments
			notes.add(new Notes());
			new Notes_Display(this, notes.get(notes.size()-1));
			updateActiveNotes();
		}
		
	}
	public void instantiateNote(Notes i) {
		//add note i to arraylist of notes, create a new jpanel passing self and i as arguments
		new Notes_Display(this, i);
		updateActiveNotes();
	}
	public void updateActiveNotes() {
		String ANS = "<html>";
		for (Notes i : notes) {
			ANS += i.title + "<p>";
		}
		ANS += "</html>";
		activeNotes.setText(ANS);
	}
	public void deleteNote(Notes tbd) {
		//delete note from arraylist and corresponding jpanel, update active notes label
		Iterator throughNotes = notes.iterator();
		while (throughNotes.hasNext()) {
			Notes x = (Notes) throughNotes.next();
			if (x == tbd) {
				throughNotes.remove();
			}
		}
		updateActiveNotes();
	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {

	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}
}
