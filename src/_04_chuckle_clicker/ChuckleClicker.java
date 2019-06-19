package _04_chuckle_clicker;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChuckleClicker {
	public static void main(String[] args) {
		ChuckleClicker chuckle = new ChuckleClicker();
		chuckle.makeButtons();
		
	}
	public void makeButtons() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		JPanel panel = new JPanel();
		frame.add(panel);
		JButton joke = new JButton("joke");
		JButton punchline = new JButton("punchline");
		panel.add(joke);
		panel.add(punchline);
		frame.pack();
	}
}