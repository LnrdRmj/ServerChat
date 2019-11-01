import java.io.IOException;
import java.net.ServerSocket;

public class MainServer {

	public static void main(String args[]) {
		
		//Creo il ServerSocket e rimnago in ascolto di una connessione
		Server server = getServer(6000);
		
	}
	
	public static Server getServer(int porta) {
		
		Server server = null;
		
		try {
			server = new Server (new ServerSocket(porta));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return server;
		
	}
	
}
