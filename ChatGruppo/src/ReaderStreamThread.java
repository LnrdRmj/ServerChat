import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReaderStreamThread extends Thread{

	protected Socket socketListener;
	
	protected DataInputStream reader;
	
	public ReaderStreamThread(Socket socketListener) {
		this.socketListener = socketListener;
		
		this.reader = getReader();
	}

	public void run() {
		while(true) {
			//Ascolta sul socket
			listen();
			
		}
	}
	
	// Ascolta tramite Scanner.nextLine() se ci sono dei messaggi in arrivo
	public void listen() {
		String letto = null;
		
		try {
			letto = reader.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (letto != null) 
			System.out.println(letto);
		
		
	}
	
	private DataInputStream getReader() {
		
		DataInputStream reader = null;
		
		try {
			reader = new DataInputStream(socketListener.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return reader;
	}
	
}
