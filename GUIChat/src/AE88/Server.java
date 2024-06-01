package AE88;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.*;

import javax.swing.*;
public class Server extends JFrame{
	ServerSocket server;
	Socket socket; 
	BufferedReader br;
	PrintWriter out;

	private JLabel heading = new JLabel("Server area");
	private JTextArea messageArea = new JTextArea();
	private JTextField messageInput = new JTextField();
	private Font font = new Font("Roboto",Font.PLAIN,20);

	public Server() {
		try {
			server = new ServerSocket(3333);
			System.out.println("Sever is ready to accept connection");
			System.out.println("Waiting...");
			socket = server.accept();
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			startReading();
			startWriting();
			createGUI();
			handleEvent();
		} catch (Exception e) {
		}
	}
	private void handleEvent() {
		messageInput.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {

			}
			public void keyPressed(KeyEvent e) {

			}
			@Override
			public void keyReleased(KeyEvent e) {
				//System.out.println("key relesed " + e.getKeyCode());
				if(e.getKeyCode()==10) {
					String contentToSend = messageInput.getText();
					messageArea.append("Me :" + contentToSend + "\n");
					out.println(contentToSend);
					out.flush();
					messageInput.setText("");
					messageInput.requestFocus();
				}

			}
		});
	}
	private void createGUI() {
		this.setTitle("Client Messager[END]");
		this.setSize(600,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//coding for compoent
		heading.setFont(font);
		messageArea.setFont(font);
		messageInput.setFont(font);
		heading.setIcon(new ImageIcon("fartcan.jpeg"));
		heading.setHorizontalTextPosition(SwingConstants.CENTER);
		heading.setVerticalTextPosition(SwingConstants.BOTTOM);
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		messageInput.setHorizontalAlignment(SwingConstants.CENTER);
		this.setLayout(new BorderLayout());
		this.add(heading,BorderLayout.NORTH);
		this.add(messageArea,BorderLayout.CENTER);
		this.add(messageInput,BorderLayout.SOUTH);
		messageArea.setEditable(false);

		JScrollPane jScrollPane = new JScrollPane(messageArea);
		this.add(jScrollPane,BorderLayout.CENTER);

		this.setVisible(true);
	}

	public void startReading() {
		Runnable r1 = ()->{
			System.out.println("reader started....");
			try {
				while(true) {


					String msg = br.readLine();

					if(msg.equals("quit")) {
						System.out.println("client left the chat");
						socket.close();
						break;
					}
					System.out.println("Client: " + msg);

				} 
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		new Thread(r1).start();
	}
	public void startWriting() {
		Runnable r2 = ()->{
			System.out.println("writer started");
			try {
				while(true && !socket.isClosed()) {

					BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
					String content = br1.readLine();
					out.println(content);
					out.flush();
					if(content.equals("exit")){
						socket.close();
						break;
					}

				}
			}catch(Exception e) {
				//e.printStackTrace();
				System.out.println("Connection closed");
			}
			System.out.println("connection closed");
		};
		new Thread(r2).start();
	}
	public static void main(String[] args) {
		System.out.println("this is server that is going to get started");
		new Server();
	}

}
