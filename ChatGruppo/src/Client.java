import java.net.Socket;
// Change
public class Client {

	private Socket socket;
	private String name;

	public Client(Socket socket) {
		this.socket = socket;
		//System.out.println("Socket client " + socket.toString());

		new ReaderStreamThread(this.socket).start();
		new WriterStreamThread(this.socket).start();
	}

	public Client(Socket socket, String name) {
		this.socket = socket;
		//System.out.println("Socket client " + socket.toString());

		new ReaderStreamThread(this.socket).start();
		new WriterStreamThread(this.socket).start();
	}

	public Socket getSocket() {
		return this.socket;
	}

}
