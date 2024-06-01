package AE88;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.*;

import javax.swing.*;
public class Cliente extends JFrame{
	Socket socket; 
	DataInputStream br;
	DataOutputStream out;

	private JLabel heading = new JLabel("Client area");
	private JTextArea messageArea = new JTextArea();
	private JTextField messageInput = new JTextField();
	private Font font = new Font("Roboto",Font.PLAIN,20);
	
	
	public Cliente() {
		try {
			System.out.println("sending request to server");
			socket = new Socket("localhost", 3333);
			System.out.println("connection done");
			br = new DataInputStream(System.in);
			out = new DataOutputStream(socket.getOutputStream());
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
				if(e.getKeyCode()==10) {
					String name = messageInput.getText();
					String contentToSend = messageInput.getText();
					messageArea.append(name + ": " + contentToSend + "\n");
					try {
						out.writeUTF(contentToSend);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
				DataInputStream din = new DataInputStream(socket.getInputStream());
				String name = din.readUTF();
				while(true) {
					String msg = din.readUTF();
					System.out.println(name + ": " + msg);
					if(msg.equals("quit")) {
						System.out.println("client left the chat");
						JOptionPane.showMessageDialog(this, "Server shut down the chat");
						messageInput.setEnabled(false);
						socket.close();
						break;
					}
					messageArea.append(name+ ": " + msg + "\n");
				} 
			}catch (IOException e) {
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
				BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
				String name = br1.readLine();
				while(true && !socket.isClosed()) {
					String content = br1.readLine();
					out.writeUTF(name + ": " + content + "/n");
					if(content.equals("exit")){
						socket.close();
						break;
					}
					
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		};
		new Thread(r2).start();
	}
	public static void main(String[] args) {
		 System.out.println("THis is client...");
		new Cliente();
	}

}

 