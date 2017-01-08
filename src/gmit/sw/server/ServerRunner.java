package gmit.sw.server;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRunner {
	public static void main(String[] args) throws Exception {
	
		// creates the server location address
		ServerSocket myServerSocket = new ServerSocket(7777, 100 , 
				InetAddress.getByName ("127.0.0.1") );
		
	}
}//end main file