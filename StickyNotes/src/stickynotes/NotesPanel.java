//GITHUB TAG

package stickynotes;

/*
Okay Nathan, I'm less sure about how you're using your file structure and which of your two files is for what,
so I'm putting in some comments on your classes and files, and I'm going to just write your goals here, you can code them as you wish

you need to have a function called panelFromNote that can take a note object and create a jpanel with two text boxes
first text box should have the note title, second should have the note contents

whenevera  note is instantiated the ntoe title should be displayed on the master panel, if you know how,
make it so that when a note's title is pressed the note pops to the front

note panels should resize automatically if too much text is put in them - this doesn't have to to be put in a function as it
isn't relevant to the main file at runtime, it should just happen automatically


*/

import java.awt.Graphics;

import javax.swing.JPanel;

public class NotesPanel extends JPanel {
	//what is this class for, if it is the panel that stores a note, then it should contain
	// a pointer to a note object that it will read information from and to during runtime
	public NotesPanel() {
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawLine(0, 0, 100, 200);
	}
	
}
