package _09_latest_tweet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import twitter4j.*;
import twitter4j.auth.AccessToken;

public class GetLatestTweet implements ActionListener {
	JFrame frame = new JFrame("Not having any ears.");
	JPanel panel = new JPanel();
	JTextField field = new JTextField(15);	
	JButton button = new JButton("Dumpster");
	
	public static void main(String[] args) {
		GetLatestTweet tweeter = new GetLatestTweet();
		tweeter.run();
	}
	
	public void run() {
		frame.add(panel);
		panel.add(field);
		panel.add(button);
		frame.setVisible(true);
		frame.pack();
		button.addActionListener(this);
	}
	
	private String getLatestTweet(String searchingFor) {

	      Twitter twitter = new TwitterFactory().getInstance();

	      AccessToken accessToken = new AccessToken(
	            "2453751158-IVD2VGZsvwZiRKxNe3Gs2lMjg30nvSkV1xSuPFf",
	            "vBa5PjKfuMTK1LLBG51nCUI9r5d6Ph5cAHrS73spg6Nvu");

	      twitter.setOAuthConsumer("YqeZdD2hYxOKv4QOkmp0i2djN",
	            "6XUB1r8KXBvd8Pk9HHW3NgphMxHvHWBLAr5TihnckMU0ttyGST");

	      twitter.setOAuthAccessToken(accessToken);

	      Query query = new Query(searchingFor);
	      try {
	            QueryResult result = twitter.search(query);
	            return result.getTweets().get(0).getText();
	      } catch (Exception e) {
	            System.err.print(e.getMessage());
	            return "What the heck is that?";
	      }
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(getLatestTweet(field.getText()));
	}
}
