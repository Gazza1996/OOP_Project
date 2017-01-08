// Gary Mannion -- G00319609 -- OOP Project
// 8-1-17
package gmit.sw.client;

import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientRunner {
	
	// main setting up of client runner
	String socket;
	// connecting to socket.. input and output initalisation
	Socket request;
	ObjectOutputStream out;
	ObjectInputStream in;
	// parser variable
	ClientParser cp;
	// client context file 
	ClientContext ctx;
	// send message to the server.. setting a variable
	String message = "";
	// user interface instances
	UI tab = new UI(); 
	String s = ""; 
	Boolean flag = true;
	
	// Main method 
	public static void main(String args[]) throws Throwable {
		
		// initialise the runner class
		ClientRunner r = new ClientRunner();
		r.run();
	}

	public void run() throws Throwable {
		try {
			while (flag) { // while loop for picking an option
				System.out.println("1. Connect to Server");
				System.out.println("2. Print File Listing");
				System.out.println("3. Download a File");
				System.out.println("4. Quit");
				System.out.println("Type option [1-4]>");
				s = tab.getString();
				
				// while loop start
				while (true) {
					if (s.equals("1")) { // if number one is selected
						if (socket == null) {
							System.out.println("Attempting to connect.... ");
							connection();
							System.out.println();
							// else if connection already made
						} else {
							System.out.println("You have already connected");
						}
						break;	
						
					} else if (s.equals("2")) { // if number two is selected
						if (socket == null) {
							System.out.println("Listing");
						}
						else {
							listing(); 
						}
						
			break;
					} else if (s.equals("3")) { // if number three is selected
						if (socket == null) {
							System.out.println("Downloading");
						} /*else {
							downloadFile();
						}*/
						break;
						
					} else if (s.equals("4")) {
						System.out.println("Quiting!!");
						flag = false;
						break;
					} else {
						System.out.println("Choose different choice");
						break;
					}
				} // end public void run() 
			} //end while loop
			
		} catch (ClassNotFoundException | IOException e) { // error 
		
		} finally {
			// closing connections made
			try {
				in.close(); // input stream
				out.close(); // output stream 
				request.close(); // close request to server
			} catch (IOException ioException) {
			}
		} // finally
	} // 


	void connection() throws Throwable {
		try {

			// get context object from conf.xml
			cp = new ClientParser(new ClientContext());
			ctx = cp.getCtx();
			String ipaddress = ctx.getServer_host();
			
			// socket connection 
			request = new Socket(ipaddress, 7777);
			System.out.println("Connected to " + ipaddress + " in port 2004");
			System.out.println();
			
			// Input and Output streams
			out = new ObjectOutputStream(request.getOutputStream());
			out.flush();
			in = new ObjectInputStream(request.getInputStream());
			
			// Communicating with the server
			message = (String) in.readObject(); // read in string object
			System.out.println("#### " + message + "####");
			socket = "ok"; // used to ignore repeat connection

		} catch (UnknownHostException unknownHost) {
			System.err.println("unknown host!");
		} catch (IOException ioException) {
		}
	}

	void sendMessage(String msg) {
		try {
			out.writeObject(msg);
			out.flush();
			System.out.println("client" + msg);
		} catch (IOException ioException) {
		}
	}
	
	void listing() throws ClassNotFoundException, IOException {
		sendMessage("listing");
		message = (String) in.readObject(); // read string object
		
		int amt= Integer.parseInt(message);
		System.out.println("listing:");
		System.out.println();
		
		for (int i = 0; i < amt; i++) {// for loop to read object
 			message = (String) in.readObject();
			System.out.println(message); // print out listing
		}
		System.out.println();
	}
	
	 class UI { // user interface class
		// one for strings and one for int
		public String getString(){
		@SuppressWarnings("resource")
		Scanner tab = new Scanner(System.in);
		return tab.nextLine();
		}
		
		public int getInt(){
		@SuppressWarnings("resource")
		Scanner tab = new Scanner(System.in);
		return tab.nextInt();
		}
		
	} 
} // end