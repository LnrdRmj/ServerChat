import java.io.IOException;
import java.net.Socket;

public class ServerReaderStreamThread extends ReaderStreamThread{

	public ServerReaderStreamThread(Socket socketListener) {
		super(socketListener);
	}

	@Override
	public void listen() {
		String letto = null;
		
		try {
			letto = super.reader.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Server.broadCast(letto, super.socketListener);
	}
	
}
