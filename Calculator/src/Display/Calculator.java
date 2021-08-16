// package Display;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
public class Calculator extends JFrame {
	static final int WIDTH = 418;
	static final int HEIGHT = 493;
	JTextField result;
	JButton[][] button;
	public Calculator() {
		button = new JButton[4][4];
		result = new JTextField();
		result.setSize(400, 50);
		result.setBackground(Color.WHITE);
		result.setFont(new Font(result.getName(),Font.BOLD,30));
		result.setEditable(false);
		int number = 1;
		for(int i = 0 ; i < 4; i ++) {
			for(int j = 0 ; j < 4 ; j++) {
				button[i][j] = new JButton();
				button[i][j].setBounds(j*100, i*100 + 50, 100, 100);
				if(number == 4) {
					button[i][j].setText("+");
				}else if(number == 8) {
					button[i][j].setText("-");
				}else if(number == 12) {
					button[i][j].setText("x");
				}else if(number == 16) {
					button[i][j].setText("/");
				}else if(number == 13) {
					button[i][j].setText("del");
				}else if(number == 14) {
					button[i][j].setText("C");
				}else if(number == 15) {
					button[i][j].setText("=");
				}else {
					button[i][j].setText(String.valueOf(number));
				}
				button[i][j].addActionListener(new CustomListener());
				// button[i][j].setBackground(Color.WHITE);
				button[i][j].setFont(new Font(button[i][j].getName(),Font.BOLD,30));
				add(button[i][j]);
				number += 1;
			}
		}
		add(result);
		setSize(WIDTH,HEIGHT);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new Calculator();
	}
	class CustomListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i = 0 ; i < 4 ; i++) {
				for(int j = 0 ; j < 4 ; j++) {
					if(e.getSource() == button[i][j]) {
						if(button[i][j].getText() == "C") {
							String tmp = result.getText();
							tmp = tmp.substring(0,tmp.length()-1);
							result.setText(tmp);
						}
						else if(button[i][j].getText() == "del") {
							result.setText("");
						}else if(button[i][j].getText() == "=") {
							if(result.getText() == "") {
								result.setText(result.getText());;
							}else {
								result.setText(String.valueOf(Convert(result.getText())));
//								int a = Convert(result.getText());
							}
						}
						else {
							result.setText(result.getText() + button[i][j].getText());
						}
					}
						
				}
			}
		}	
	}
	public static int Convert(String s) {
		String form = "";
		String a = "";
		String b = "";
		System.out.println(s);
		for(int i = 0 ; i < s.length() ; i++) {
			
			if(s.charAt(i) == '+' || s.charAt(i) == '/' || s.charAt(i) == '*' || s.charAt(i) == '-') {
				form += s.charAt(i);
			}else{
				if(form == "") a += s.charAt(i);
				if(form != "") b += s.charAt(i);
			}
		}
		System.out.println(a);
		System.out.print(b);
		if(form.equals("+")) return Sum(Integer.parseInt(a),Integer.parseInt(b));
		if(form.equals("-")) return T(Integer.parseInt(a),Integer.parseInt(b));
		if(form.equals("+*")) return Multi(Integer.parseInt(a),Integer.parseInt(b));
		if(form.equals("/")) return Div(Integer.parseInt(a),Integer.parseInt(b));
		return 0;
	}
	public static int Sum(int a,int b) {
		return a + b;
	}
	public static int Multi(int a,int b) {
		return a*b;
	}
	public static int Div(int a,int b) {
		return a/b;
	}
	public static int T(int a,int b) {
		return a-b;
	}
}
