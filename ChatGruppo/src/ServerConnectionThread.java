import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnectionThread extends Thread{

	private ServerSocket server;
	
	public ServerConnectionThread(ServerSocket server) {
		
		this.server = server;
		
	}
	
	public void run() {
		while(true) {
			System.out.println("Aspetto connessione");
			Server.setClientSocket(this.accept());
			System.out.println("Un client accettato");	
		}
	}
	
	public Socket accept() {
		
		Socket socket = null;
		
		try {
			socket = server.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return socket;
	}
	
}
