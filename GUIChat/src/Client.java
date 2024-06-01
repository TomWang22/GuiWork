as limport java.io.*;
import java.net.*;

public class Client {
	Socket socket;
	BufferedReader br;
	PrintWriter out;
	public Client() {
		try {
			System.out.println("sending request to server");
			socket = new Socket("localhost", 3333);
			System.out.println("connection done");
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			startReading();
			startWriting();
		}catch(Exception e) {
			
		}
	}
	public void startReading() {
		Runnable r1 = ()->{
			System.out.println("reader started....");
			while(true) {

				try {
					String msg = br.readLine();

					if(msg.equals("quit")) {
						System.out.println("Server terminated the chat");
						break;
					}
					System.out.println("Server: " + msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		new Thread(r1).start();
	}
	public void startWriting() {
		Runnable r2 = ()->{
			System.out.println("writer started to fart");
           while(true) {
        	   try {
        		   BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        		   String content = br1.readLine();
        		   out.println(content);
        		   out.flush();
        	   }catch(Exception e) {
        		   e.printStackTrace();
        	   }
           }
		};
		new Thread(r2).start();
	}
	public static void main(String[] args) {
        System.out.println("THis is client...");
        new Client();
	}
}
