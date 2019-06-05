package _01_nasty_surprise;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NastySurprise implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton trick = new JButton("Trick");
	JLabel or = new JLabel("or");
	JButton treat = new JButton("Treat");
	public NastySurprise() {
		frame.setVisible(true);
		frame.add(panel);
		panel.add(trick);
		panel.add(or);
		panel.add(treat);
		frame.pack();
		trick.addActionListener(this);
		treat.addActionListener(this);
	}
	
	public static void main(String[] args) {
		NastySurprise surprise = new NastySurprise();
	}
	
	private void showPictureFromTheInternet(String imageUrl) {
	    try {
	         URL url = new URL(imageUrl);
	         Icon icon = new ImageIcon(url);
	         JLabel imageLabel = new JLabel(icon);
	         JFrame frame = new JFrame();
	         frame.add(imageLabel);
	         frame.setVisible(true);
	         frame.pack();
	    } catch (MalformedURLException e) {
	         e.printStackTrace();
	    }
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == trick) {
			showPictureFromTheInternet("https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/Alberta_Department_of_Public_Health_Rat_Poster_%2826497442131%29.jpg/463px-Alberta_Department_of_Public_Health_Rat_Poster_%2826497442131%29.jpg");
		} else {
			showPictureFromTheInternet("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/Karl_Marx_001.jpg/379px-Karl_Marx_001.jpg");
		}
		
	}
}