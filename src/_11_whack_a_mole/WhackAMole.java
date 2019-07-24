package _11_whack_a_mole;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WhackAMole {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	
	public static void main(String[] args) {
		WhackAMole mole = new WhackAMole();
		mole.go();
	}
	
	public void go() {
		panel.setLayout(new GridLayout(4,6));
		for (int i = 0; i < 24; i++) {
			panel.add(new JButton());
		}
		frame.setVisible(true);
		frame.pack();
	}
}
