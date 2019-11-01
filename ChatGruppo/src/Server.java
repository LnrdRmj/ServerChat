import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {

	private static ServerSocket serverSocket;
	private static Vector <Socket> clientSockets;
	
	public Server(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
		
		//Avvio l'ascolto di una connessione sulla porta
		new ServerConnectionThread(serverSocket).start();
		
		clientSockets = new Vector <Socket>();
	}
	
	//Setto il client socket quando si instaura una connessione
	public static void setClientSocket(Socket clientSocket) {
		Server.clientSockets.add(clientSocket);
		System.out.println("Socket server " + clientSocket.toString());
		
		new ServerReaderStreamThread(clientSocket).start();
		new WriterStreamThread(clientSocket).start();
		
	}

	public static void broadCast(String letto, Socket emittente) {
		//Invio il messaggio di broadCast a tutti tranne che al mittente
		for (Socket i : clientSockets) {
			if (!i.equals(emittente)) {
				try {
					new DataOutputStream(i.getOutputStream()).writeUTF(letto);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
