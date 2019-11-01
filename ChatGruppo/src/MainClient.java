import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainClient {

	public static void main(String args[]) {
		
		// Creo il client
		// Rimango in ascolto per RICEVERE messaggi
		// Rimango in ascolto per MANDARE messaggi
		new Client(getSocket("localhost", 6000));
		
	}
	
	public static Socket getSocket(String host, int porta) {
		Socket s = null;
		
		try {
			s = new Socket(host, porta);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
}
