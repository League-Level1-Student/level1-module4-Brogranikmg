package _99_extra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Riddled implements ActionListener {
	
	JFrame frame = new JFrame("Riddle me This!");
	JPanel panel = new JPanel();
	JLabel riddle = new JLabel("I build up castles. I tear down mountains. I make some men blind, I help others to see. What am I?");
	JButton submit = new JButton("Submit");
	JButton hint = new JButton("Hint");
	JTextField field = new JTextField(30);
	
	public static void main(String[] args) {
		Riddled rid = new Riddled();
		rid.run();
	}
	
	public void run() {
		frame.setVisible(true);
		frame.add(panel);
		panel.add(riddle);
		panel.add(submit);
		panel.add(hint);
		panel.add(field);
		frame.pack();
		submit.addActionListener(this);
		hint.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			if (field.getText().equalsIgnoreCase("sand")) {
				JOptionPane.showMessageDialog(null, "Clever though I thought I was, you solved my riddle (as one does).");
			} else {
				JOptionPane.showMessageDialog(null, "I asked for truth, but yet you lied. The answer you seek will forever hide. GOODBYE!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Soon you'll see through me, but now I am silt.");
		}
		
	}
}
