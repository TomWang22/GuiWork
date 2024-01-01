import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Button;

public class Chats extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chats frame = new Chats();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Chats() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(10, 10, 430, 179);
		contentPane.add(textArea);
		
		TextField textField = new TextField();
		textField.setBounds(10, 213, 273, 49);
		contentPane.add(textField);
		
		Button button = new Button("New button");
		button.setBounds(306, 213, 117, 29);
		contentPane.add(button);
	}

}
