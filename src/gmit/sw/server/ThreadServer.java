// Gary Mannion -- G00319609 -- OOP Project
// 8-1-17
package gmit.sw.server;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

// main method
// very same to my client runner class
public class ThreadServer extends Thread {

	Socket cs;
	String message;
	int id;
	ObjectOutputStream out;
	ObjectInputStream in;

	ThreadServer(Socket s, int i) {
		cs = s;
		id = i;
	}

	void sendMessage(String msg) {
		try {
			out.writeObject(msg);
			out.flush();
			System.out.println("server" + msg);
			
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	public void run() {
		try {
			out = new ObjectOutputStream(cs.getOutputStream());
			out.flush();
			in = new ObjectInputStream(cs.getInputStream());
			System.out.println("Accepted Client : ID - " + id
					+ " : Address - "
					+ cs.getInetAddress().getHostName());
			sendMessage("connected");

			askOperation();

		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
		
		}finally {
		
			try {
				in.close(); // closing
				out.close(); // closing
				cs.close(); // closing
			} catch (IOException ioException) {
			}
		}
	}

	void askOperation() throws IOException, ClassNotFoundException {
		while (true) {
			message = (String) in.readObject();
			
			
			// error here
			/*if (message.equals("listing")) {
				listing();
			}*/
		}
	}
}