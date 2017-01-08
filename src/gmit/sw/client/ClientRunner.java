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
	
	// connecting to socket.. input and ouput initalisation
	Socket request;
	ObjectOutputStream out;
	ObjectInputStream in;
	
	// parser
	ClientParser cp;
	
	// client context file 
	ClientContext ctx;
	
	// send message to the server.. setting a variable
	String message = "";
	
	//scanner calling from keyboard 
	UI tab = new UI(); 
	String s = ""; 
	Boolean flag = true;
	
	//Main method 
	public static void main(String args[]) throws Throwable {
		
		// iniatilise the runner class
		ClientRunner r = new ClientRunner();
		r.run();
	}

	public void run() throws Throwable {
		try {
			while (flag) {
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
							System.out.println(" You have already connected");
						}
						break;	
						
					} else if (s.equals("2")) { // if number two is selected
						if (socket == null) {
							System.out.println("Connect");
						}
						/*else {
							getList(); 
						}*/
						
			break;
					} else if (s.equals("3")) { // if number three is selected
						if (socket == null) {
							System.out.println("Connect ");
						} /*else {
							downloadFile();
						}*/
						break;
						
					} else if (s.equals("4")) {
						System.out.println("Quiting from server");
						flag = false;
						break;
					} else {
						System.out.println("Choose different choice");
						break;
					}
				} // end public void run() 
			} //end while looop
			
		} catch (ClassNotFoundException | IOException e) {
		
		} finally {
			// closing connections made
			try {
				in.close();
				out.close();
				request.close();
			} catch (IOException ioException) {
			}
		} // finally
	} // 


	void connection() throws Throwable {
		try {

			// get context object from conf.xml
			cp = new ClientParser(new ClientContext());
			
			//p.init();
			ctx = cp.getCtx();
			String ipaddress = ctx.getServerHostName();
			
			// socket connection 
			request = new Socket(ipaddress, 7777);
			System.out.println("Connected to " + ipaddress + " in port 2004");
			System.out.println();
			// Input and Output streams
			out = new ObjectOutputStream(request.getOutputStream());
			out.flush();
			in = new ObjectInputStream(request.getInputStream());
			// Communicating with the server
			message = (String) in.readObject();
			System.out.println("<<<<< " + message + " >>>>>");
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
			System.out.println("client> " + msg);
		} catch (IOException ioException) {
		}
	}
	
	 class UI {
		//
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