import java.io.*;
import java.net.*;
public class Server {
	ServerSocket server;
	Socket socket; 
	BufferedReader br;
	PrintWriter out;

	public Server() {
		try {
			server = new ServerSocket(3333);
			System.out.println("Sever is ready to accept connection to the toilet");
			System.out.println("Waiting...");
			socket = server.accept();
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			startReading();
			startWriting();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void startReading() {
		Runnable r1 = ()->{
			System.out.println("reader started....");
			while(true) {

				try {
					String msg = br.readLine();

					if(msg.equals("quit")) {
						System.out.println("client left the chat");
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
		System.out.println("this is server that is going to get started, a fart time away");
		new Server();
	}

}
