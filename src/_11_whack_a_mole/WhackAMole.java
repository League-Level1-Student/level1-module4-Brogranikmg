package _11_whack_a_mole;

import java.applet.AudioClip;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {
	
	Date timeNow = new Date();
	int molesGot = 0;
	int moleMiss = 0;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	
	public static void main(String[] args) {
		WhackAMole mole = new WhackAMole();
		mole.go();
	}
	
	public void go() {
		Random rand = new Random();
		int mole = rand.nextInt(24);
		panel.setLayout(new GridLayout(4, 6, 5, 5));
		for (int i = 0; i < 24; i++) {
			JButton button = new JButton();
			panel.add(button);
			if (i == mole) {
				button.setText("X");
			}
			button.addActionListener(this);
		}
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(307, 211);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void speak(String words) {
	     try {
	          Runtime.getRuntime().exec("say " + words).waitFor();
	     } catch (Exception e) {
	          e.printStackTrace();
	     }
	}
	
	private void playSound(String fileName) {
	     AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
	     sound.play();
	}
	
	private void endGame(Date timeAtStart, int molesWhacked) {
	     Date timeAtEnd = new Date();
	     System.out.println(timeAtStart.getTime());
	     System.out.println(timeAtEnd.getTime());
	     JOptionPane.showMessageDialog(null, "Your whack rate is 1 mole per "
	          + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	          + " seconds.");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		frame.remove(panel);
		frame.dispose();
		panel = new JPanel();
		if (((JButton) arg0.getSource()).getText().equals("")) {
			playSound("wrong song.wav");
			moleMiss++;
		} else {
			playSound("mole song.wav");
			molesGot++;
		}
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		if (molesGot + moleMiss >= 2) {
			endGame(timeNow, molesGot);
		} else {
			go();
		}
	}
}
