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
			//Add a new JPanel
		}
		
	}

}
