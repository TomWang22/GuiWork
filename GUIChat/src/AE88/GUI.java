package AE88;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class GUI implements ActionListener{

	public static void main(String[] args) {
		 JFrame frame = new JFrame();
		 JPanel panel = new JPanel();
		 frame.setSize(100,100);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.add(panel);
	     panel.setLayout(null);
	     JLabel label = new JLabel("Cologuard");
	     label.setBounds(10,20,80,25);
	     panel.add(label);
	     JTextField userText = new JTextField(20);
	     userText.setBounds(100,20,165,25);
	     panel.add(userText);
	 
	     JLabel label1 = new JLabel("Shipping company");
	     label1.setBounds(10,50,80,25);
	     panel.add(label1);
	     
	     JPasswordField passwordLabel = new JPasswordField();
	     passwordLabel.setBounds(100,50,165,25);
	     panel.add(passwordLabel);
	     
	     JTextField userText1 = new JTextField();
	     userText.setBounds(100,20,165,25);
	     panel.add(userText1);
	     
	     JButton button = new JButton("Ship");
	     button.setBounds(10,80,80,25);
	     button.addActionListener(new GUI());
	     panel.add(button);
	     
	     JLabel success = new JLabel("");
	     success.setBounds(10,110,300,25);
	     panel.add(success);
	     
	     frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("shit shipped");
		
	}

}
