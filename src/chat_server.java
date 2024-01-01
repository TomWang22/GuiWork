import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.css.CSSStyleDeclaration;

import java.awt.TextArea;
import java.awt.TextField;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.awt.Button;
import java.net.ServerSocket;
import java.net.Socket;
public class chat_server extends JFrame {
	static ServerSocket ss;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chat_server frame = new chat_server();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		String msgin = "";
		try {
			ss = new ServerSocket(3333);
			s = ss.accept();
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			while(!msgin.equals("exit")) {
				msgin = din.readUTF();
				System.out.println(msgin);
			}
		}catch(Exception e) {
			
		}
	}

	/**
	 * Create the frame.
	 */
	public chat_server() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(10, 10, 433, 195);
		contentPane.add(textArea);
		
		TextField textField = new TextField();
		textField.setBounds(10, 221, 265, 41);
		contentPane.add(textField);
		
		Button button =  new Button("New button");
		button.setBounds(302, 221, 126, 41);
		contentPane.add(button);
	}

}
