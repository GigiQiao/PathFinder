package assign_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class Graph extends JPanel{

	public void paint(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);
		g.setColor(Color.BLACK);
		g.drawRect(350, 100, 600, 600);
	}	
	
}
