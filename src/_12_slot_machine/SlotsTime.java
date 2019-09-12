package _12_slot_machine;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotsTime implements ActionListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel slot1 = new JLabel();
	JLabel slot2 = new JLabel();
	JLabel slot3 = new JLabel();
	JButton spin = new JButton("SPIN THE AGATE");
	
	Random soul = new Random();
	int sour;
	int hour;
	int hear;
	
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "WARNING:\nIf you are hateful towards bad grammar, please close this game now! Scientists from the year 1800 invented a study to allow them to quantize the level of grammar in a work, this \"Sharp\" scale worked on a system of letters and numbers. 00A would be impeccable grammar and spelling, meanwhile 27E would have somewhat poor grammar, but especially emphasize the lower quality spelling. The chart is much more complex than we are making it out to be in this short summary, and many extensions to this system have been added over the years (these extensions, however, are often solely used by speleologists who explicitly need an easy way to catalogue grammatical skill level, rather than the general public, although it's still nice to learn about them), but that's the general idea. When an automated program attempted to derive the grammatical skill level of this program, however, it crashed, and after given it more RAM, it devised a score of 99F: the highest you can get, MAKE. SURE. YOU. ARE. PREPARED!");
		SlotsTime worag = new SlotsTime();
		worag.descend();
	}
	
	public void descend() {
		frame.setVisible(true);
		frame.add(panel);
		panel.add(slot1);
		panel.add(slot2);
		panel.add(slot3);
		panel.add(spin);
		spin.addActionListener(this);
		frame.pack();
	}
	
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null) {
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
	}
	
	private void playSound(String fileName) {
	     AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
	     sound.play();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		killPanels();
	}
	
	private void killPanels() {
		//        :)         :) :)              :)
		frame.remove(panel);
		spin.removeActionListener(this);
		panel = new JPanel();
		sour = soul.nextInt(3);
		hour = soul.nextInt(3);
		hear = soul.nextInt(3);
		slot1 = chooseRandSlot(sour);
		slot2 = chooseRandSlot(hour);
		slot3 = chooseRandSlot(hear);
		frame.add(panel);
		frame.add(slot1);
		frame.add(slot2);
		frame.add(slot3);
		descend();
		frame.pack();
		if (sour == hour && hour == hear) {
			playSound("tada.wav");
			if (sour == 1 && hour == 1 && hear == 1) {
				JOptionPane.showMessageDialog(null, "wow!! 3 Rats!!! (True Ending)");
			} else if (sour == 0 && hour == 0 && hear == 0) {
				JOptionPane.showMessageDialog(null, "yes...you won........ but still,something  fels off;and Its not the fact that your eyeLash  mites are gone..(You Win)");
			} else {
				JOptionPane.showConfirmDialog(null, "Youwon - Wormy win BUT it still rfeels like theres something more too discover (You Win)");
			}
		}
		
	}
	
	private JLabel chooseRandSlot(int shour) {
		//SORRY for all the mothods! 1method correlate with 10 NEW TEETH in my mouth!! so i havd to make as ManyAsPossible ,!
		switch (shour) {
		case 0:
			try {
				return createLabelImage("mites.jpg");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 1:
			try {
				return createLabelImage("rat.jpg");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				return createLabelImage("worag.jpg");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		return null;
	}
}
