//GITHUB TAG

package stickynotes;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class StickyNotes {
	
	JFrame console = new JFrame("NOTES CONSOLE");
	NotesPanel panel = new NotesPanel();
	
	public StickyNotes() {
		console.setSize(600, 800);
		console.setLayout(new BorderLayout());
		console.add(panel, BorderLayout.CENTER);
		
		console.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		console.setVisible(true);
	}

	public static void main(String[] args) {
		new StickyNotes();

	}

}
