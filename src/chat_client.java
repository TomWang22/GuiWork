import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Button;

public class chat_client extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chat_client frame = new chat_client();
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
	public chat_client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(10, 10, 428, 191);
		contentPane.add(textArea);
		
		TextField textField = new TextField();
		textField.setBounds(10, 223, 251, 39);
		contentPane.add(textField);
		
		Button button = new Button("New button");
		button.setBounds(285, 223, 138, 39);
		contentPane.add(button);
	}

}
