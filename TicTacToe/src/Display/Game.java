// package Display;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game extends JFrame{
	static JLabel label;
	static int column = 3;
	static int row = 3;
	static int i = 0;
	static int j = 0;
	static int check = 0;
	static JButton b[][];
	static JButton clear;
	public Game() {
		clear = new JButton("Replay");
		clear.setBounds(196,420,100,30);
		clear.setBackground(Color.GREEN);
		clear.setFocusable(false);
		clear.addActionListener(new CustomListener());
		b = new JButton[row][column];
		label = new JLabel("");
		label.setSize(100,100);
		label.setFont(new Font(label.getName(),Font.BOLD,20));
		label.setBounds(200,0,100,50);
		// label.setForeground(Color.blue);
				for(i = 0 ; i < row; i++) {
			for(j = 0 ; j < column ; j++) {
				b[i][j] = new JButton("");
				b[i][j].setBounds(i*100 + i*30 + 65,j*100 + j*30 + 50, 100, 100);
				b[i][j].setBackground(Color.WHITE);
				b[i][j].addActionListener(new CustomListener());
				b[i][j].setFont(new Font(b[i][j].getName(),Font.BOLD,30));
				b[i][j].setFocusable(false);
				add(b[i][j]);
			}
		}
//		add(b);
		add(label);
		add(clear);
		setSize(500,500);
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Game();

	}
	public static boolean check() {
		boolean result = false;
		if(b[0][0].getText() == b[1][1].getText() && b[1][1].getText() == b[2][2].getText()) {
			if(b[0][0].getText() != "")
			result = true;
			
		}
		if(b[0][2].getText() == b[1][1].getText() && b[1][1].getText() == b[2][0].getText()) {
			if(b[0][2].getText() != "")
			result = true;
		}
		if(b[0][0].getText() == b[0][1].getText() && b[0][1].getText() == b[0][2].getText()) {
			if(b[0][2].getText() != "")
			result = true;
		}
		if(b[1][0].getText() == b[1][1].getText() && b[1][1].getText() == b[1][2].getText()) {
			if(b[1][2].getText() != "")
			result = true;
		}
		if(b[2][0].getText() == b[2][1].getText() && b[2][1].getText() == b[2][2].getText()) {
			if(b[2][2].getText() != "")
			result = true;
		}
		if(b[0][0].getText() == b[1][0].getText() && b[1][0].getText() == b[2][0].getText()) {
			if(b[2][0].getText() != "")
			result = true;
		}
		if(b[0][1].getText() == b[1][1].getText() && b[1][1].getText() == b[2][1].getText()) {
			if(b[2][1].getText() != "")
			result = true;
		}
		if(b[0][2].getText() == b[1][2].getText() && b[1][2].getText() == b[2][2].getText()) {
			if(b[2][2].getText() != "")
			result = true;
		}
		return result;
	}
	class CustomListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i = 0 ; i < row ; i++) {
				for(int j = 0 ; j < column ; j++) {{
					if(e.getSource() == b[i][j]) {
						if(check % 2 == 0) {
							if(b[i][j].getText() == "") {
								b[i][j].setForeground(new Color(255,0,0));
								b[i][j].setText("X");
								check += 1;
							}
						}
						else { 
							if(b[i][j].getText() == "") {
								b[i][j].setForeground(new Color(0,0,255));
								b[i][j].setText("0");
								check += 1;
							}
						}
					}
				}
			}
		}
		if(check() == true) {
			if((check-1) % 2 == 0) label.setText("1 Win");
			else label.setText("2 Win");
		}
		if(label.getText() != "" && e.getSource() == clear){
			label.setText("");
			Clear();
		}
	}

	}
	public static void Clear(){
		for (int i = 0 ; i < row ; i++){
			for(int j = 0 ; j < column ; j++){
				b[i][j].setText("");
			}
		}
	}
}
