import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class WriterStreamThread extends Thread{

	private Socket socketWriter;
	
	//private PrintWriter writer;
	private DataOutputStream writer;
	private Scanner tastiera;
	
	public WriterStreamThread(Socket socketWriter) {
		this.socketWriter = socketWriter;
		
		writer = getWriter();
		tastiera = new Scanner(System.in);
	}
	
	public void run() {
		while(true) {
			//Scrivo sulla connessione
			write();
			
		}
	}
	
	//Manda un messaggio tramite la connessione appena scriviamo qualcosa sulla tastiera
	public void write() {
		String daScrivere = tastiera.nextLine(); 
		//System.out.println("Scrivo " + daScrivere);
		try {
			writer.writeUTF(daScrivere);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public DataOutputStream getWriter() {
		
		DataOutputStream pw = null;
		
		try {
			pw = new DataOutputStream(this.socketWriter.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return pw;
		
	}
	
}
