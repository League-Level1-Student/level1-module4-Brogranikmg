package _05_typing_tutor;

import java.awt.Color;
import java.awt.color.ColorSpace;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

public class TypingTutor implements KeyListener {
	public static void main(String[] args) {
		TypingTutor type = new TypingTutor();
		type.makeThings();
	}
	
	char generateRandomLetter() {
	      Random r = new Random();
	      return (char) (r.nextInt(26) + 'a');
	}
	
	char currentLetter = generateRandomLetter();
	
	Boolean correct;
	
	int numberType = 0;
	int correctType = 0;
	
	JFrame frame = new JFrame("Type or Die");
	JPanel panel = new JPanel();
	JLabel label = new JLabel("" + currentLetter);
	
	public void makeThings() {
		frame.add(panel);
		panel.add(label);
		frame.setVisible(true);
		label.setFont(label.getFont().deriveFont(72f));
		label.setHorizontalAlignment(JLabel.CENTER);
		frame.pack();
		frame.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getKeyChar() == currentLetter) {
			correct = true;
			correctType++;
		} else {
			correct = false;
		}
		currentLetter = generateRandomLetter();
		label.setText("" + currentLetter);
		frame.pack();
		if (correct) {
			panel.setBackground(Color.green);
		} else {
			panel.setBackground(Color.red);
		}
		numberType++;
		if (numberType >= 50) {
			showTypingSpeed(correctType);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	Date timeAtStart = new Date();

	private void showTypingSpeed(int numberOfCorrectCharactersTyped) {
	      Date timeAtEnd = new Date();
	      long gameDuration = timeAtEnd.getTime() - timeAtStart.getTime();
	      long gameInSeconds = (gameDuration / 1000) % 60;
	      double charactersPerSecond = ((double) numberOfCorrectCharactersTyped / (double) gameInSeconds);
	      int charactersPerMinute = (int) (charactersPerSecond * 60);
	      JOptionPane.showMessageDialog(null, "Your typing speed is " + charactersPerMinute + " characters per minute.");
	}
	
	//currentLetter = generateRandomLetter();
}
