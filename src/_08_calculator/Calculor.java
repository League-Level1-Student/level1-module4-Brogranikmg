package _08_calculator;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculor implements ActionListener {
	JFrame frame = new JFrame("CALCULOR DEUM");
	JPanel input = new JPanel();
	JPanel buttons = new JPanel();
	JTextField num1 = new JTextField(10);
	JTextField num2 = new JTextField(10);
	JButton add = new JButton("ADD");
	JButton sub = new JButton("SUB");
	JButton mul = new JButton("MUL");
	JButton div = new JButton("DIV");
	JLabel ans = new JLabel();
	Font font = new Font("Purisa", Font.BOLD, 20);
	
	public void run() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(2, 2));
		frame.add(input);
		frame.add(buttons);
		input.add(num1);
		input.add(num2);
		buttons.add(add);
		buttons.add(sub);
		buttons.add(mul);
		buttons.add(div);
		frame.add(ans);
		frame.pack();
		add.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		ans.setFont(font);
	}
	
	double add(double num1, double num2) {
		return num1 + num2;
	}
	
	double sub(double num1, double num2) {
		return num1 - num2;
	}
	
	double mul(double num1, double num2) {
		return num1 * num2;
	}
	
	double div(double num1, double num2) {
		return num1 / num2;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		double int1 = Double.parseDouble(num1.getText());
		double int2 = Double.parseDouble(num2.getText());
		if (arg0.getSource() == add) {
			ans.setText(add(int1, int2) + "");
		} else if (arg0.getSource() == sub) {
			ans.setText(sub(int1, int2) + "");
		} else if (arg0.getSource() == mul) {
			ans.setText(mul(int1, int2) + "");
		} else if (arg0.getSource() == div) {
			ans.setText(div(int1, int2) + "");
		}
		
	}
}
