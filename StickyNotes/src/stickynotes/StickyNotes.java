//GITHUB TAG

package stickynotes;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StickyNotes implements ActionListener, MouseListener {
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
	JLabel title = new JLabel("JNotes Console");
	Container north = new Container();
	Container south = new Container();
	Container body = new Container();
	
	public StickyNotes() {
		console.setSize(600, 800);
		console.setLayout(new BorderLayout());
		console.add(panel, BorderLayout.CENTER);
		north.setLayout(new GridLayout(1,1));
		north.add(addNoteB);
		south.setLayout(new GridLayout(1,1));
		addNoteB.addActionListener(this);
		
		console.add(north, BorderLayout.NORTH);
		
		console.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		console.setVisible(true);
	}
//main funciton is ok for testing, but at end there should only be teh main function in the main file
	public static void main(String[] args) {
		new StickyNotes();

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
			System.out.println("Hello");
			//Add a new JPanel, put in
		}
		
	}

}
