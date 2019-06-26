package _04_chuckle_clicker;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {
	public static void main(String[] args) {
		ChuckleClicker chuckle = new ChuckleClicker();
		chuckle.makeButtons();
		
	}
	JButton joke = new JButton("joke");
	JButton punchline = new JButton("punchline");
	public void makeButtons() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.add(joke);
		panel.add(punchline);
		frame.pack();
		joke.addActionListener(this);
		punchline.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == joke) {
			JOptionPane.showMessageDialog(null, "Why are Communists anti-money?");
		} else {
			JOptionPane.showMessageDialog(null, "<html><body><p style='width: 750px;'>Because they're not durable enough to make currency! The joke is that 'anti-money' sounds similar to 'antimony', a chemical element that was used to mint coins by the Chinese province of Guizhou in 1931, before being discontinued, because the material was not durable enough. Henceforth, Communists are not durable enough to make (as in 'be used as a material in the production of') currency because they're antimony. This joke plays off of the classic stereotype that Communists simply advocate for abolishing currency due to sheer laziness, before reversing one's expectations with a historical joke.</p></body></html>");
		}
	}
}