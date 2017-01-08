package gmit.sw.server;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRunner {
	public static void main(String[] args) throws Exception {
	
		// creates the server location address
		ServerSocket myServerSocket = new ServerSocket(7777, 100 , 
				InetAddress.getByName ("127.0.0.1") );
		
<<<<<<< HEAD
	}
=======
/*		int id = 0;
		while (true)
		{
			Socket clientSocket = m_ServerSocket.accept();
			ClientServiceThread cliThread = new ClientServiceThread(clientSocket, id++);
			cliThread.start();
*/
/*		}//end while 
*/	}
>>>>>>> 343bb2637adebdb820f50bf35f682d9df5238d53
}//end main file