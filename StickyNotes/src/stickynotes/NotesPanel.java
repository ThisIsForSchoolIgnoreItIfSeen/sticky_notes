//GITHUB TAG

package stickynotes;

import java.awt.Graphics;

import javax.swing.JPanel;

public class NotesPanel extends JPanel {
	
	public NotesPanel() {
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(0, 0, 100, 200);
	}
	
}
