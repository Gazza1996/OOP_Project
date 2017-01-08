// Gary Mannion -- G00319609 -- OOP Project
// 8-1-17
package gmit.sw.server;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRunner {
	public static void main(String[] args) throws Exception {
	
		// creates the server location address
		ServerSocket myServerSocket = new ServerSocket(7777, 100, InetAddress.getByName ("127.0.0.1") );
		
		int id = 0;
		while (true)
		{
			Socket cs = myServerSocket.accept();
			ThreadServer Thread = new ThreadServer(cs, id++);
			Thread.start();

		}//end while 
	}
}//end main file