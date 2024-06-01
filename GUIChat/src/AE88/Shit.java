package AE88;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Shit implements ActionListener{
	int count = 0;
	private JFrame frame;
	private JPanel panel;
	private JButton buttom;
	private JLabel label;
    public Shit() {
    	frame = new JFrame();
        panel = new JPanel();
    	buttom = new JButton("shit me");
    	buttom.addActionListener(this);
        label = new JLabel("Number of shits: 0");
    	frame.setSize(300,300);
    	panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
    	panel.setLayout(new GridLayout(0,1));
    	frame.add(panel, BorderLayout.CENTER);
    	panel.add(buttom);
    	panel.add(label); 
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setTitle("Shit producer");
    	frame.pack();
    	frame.setVisible(true);
    }
	public static void main(String[] args) {
		new Shit();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		label.setText("Number of clicks: " + count) ;
		
		 
		
	}

}
