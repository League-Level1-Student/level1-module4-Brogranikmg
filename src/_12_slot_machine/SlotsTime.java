package _12_slot_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SlotsTime implements ActionListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel slot1 = new JLabel();
	JLabel slot2 = new JLabel();
	JLabel slot3 = new JLabel();
	JButton spin = new JButton("SPIN THE AGATE");
	
	public static void main(String[] args) {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		killPanels();
	}
	
	private void killPanels() {
		//        :)         :) :)              :)
		frame.remove(panel);
		frame.remove(slot1);
		frame.remove(slot2);
		frame.remove(slot3);
		panel = new JPanel();
		slot1 = chooseRandSlot();
		slot2 = chooseRandSlot();
		slot3 = chooseRandSlot();
		frame.add(panel);
		frame.add(slot1);
		frame.add(slot2);
		frame.add(slot3);
		
	}
	
	private JLabel chooseRandSlot() {
		//SORRY for all the mothods! 1method correlate with 10 NEW TEETH in my mouth!! so i havd to make as ManyAsPossible ,!
		Random soul = new Random();
		switch (soul.nextInt(2)) {
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
				return createLabelImage("rat.jpeg");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				return createLabelImage("worag.jpeg");
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
