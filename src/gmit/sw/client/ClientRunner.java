package gmit.sw.client;

<<<<<<< HEAD
=======


>>>>>>> 343bb2637adebdb820f50bf35f682d9df5238d53
import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

<<<<<<< HEAD
public class ClientRunner {
	
	// main setting up of client runner
	String socket;
	
	// connecting to socket.. input and ouput initalisation
=======


public class ClientRunner {
	
	String socket;
	
	//connecting socket
>>>>>>> 343bb2637adebdb820f50bf35f682d9df5238d53
	Socket request;
	ObjectOutputStream out;
	ObjectInputStream in;
	
<<<<<<< HEAD
	// parser
=======
	//parser
>>>>>>> 343bb2637adebdb820f50bf35f682d9df5238d53
	ClientParser cp;
	
	// client context file 
	ClientContext ctx;
	
<<<<<<< HEAD
	// send message to the server.. setting a variable
=======
	// send message to the server 
>>>>>>> 343bb2637adebdb820f50bf35f682d9df5238d53
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
<<<<<<< HEAD
				System.out.println("1. Connect to Server");
				System.out.println("2. Print File Listing");
				System.out.println("3. Download a File");
				System.out.println("4. Quit");
				System.out.println("Type option [1-4]>");
=======
				System.out.println("Make a choice of the following!! (1-4)");
				System.out.println("1. Connect to Server");
				System.out.println("2. Print Files");
				System.out.println("3. Download a File");
				System.out.println("4. Quit");
				System.out.println("");
>>>>>>> 343bb2637adebdb820f50bf35f682d9df5238d53
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
<<<<<<< HEAD
			cp = new ClientParser(new ClientContext());
=======
			//p = new Parseator(new Context());
>>>>>>> 343bb2637adebdb820f50bf35f682d9df5238d53
			
			//p.init();
			ctx = cp.getCtx();
			String ipaddress = ctx.getServerHostName();
			
			// socket connection 
<<<<<<< HEAD
			request = new Socket(ipaddress, 7777);
			System.out.println("Connected to " + ipaddress + " in port 2004");
=======
			//request = new Socket(ipaddress, 7777);
			//System.out.println("Connected to " + ipaddress + " in port 2004");
>>>>>>> 343bb2637adebdb820f50bf35f682d9df5238d53
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
	
<<<<<<< HEAD
=======


/*	void getList() throws ClassNotFoundException, IOException {
		sendMessage("list");
		message = (String) in.readObject();
		int sum = Integer.parseInt(message); // get the amount of files
		System.out.println("file list :");
		System.out.println();
		for (int i = 0; i < sum; i++) {
			message = (String) in.readObject();
			System.out.println(message);
		}
		System.out.println();
	}*/

	
/*	void downloadFile() throws ClassNotFoundException, IOException {
		sendMessage("download");
		while (true) {
			System.out.println("Please input the fileName you want to download>");
			s = tab.getString();
			sendMessage(s);
			message = (String) in.readObject();
			if (message.equals("ok")) {
				break;
			}
			if (message.equals("error")) {
				System.out.println("==---------NO FILE !!!--------==");
			}
		}
		sendMessage(s);
		receiveFile();
	}*/


	
/*	void receiveFile() throws IOException {
		byte[] inputByte = null;
		int length = 0;
		//sendMessage(requestSocket.getInetAddress().getHostAddress());
		try {

			FileOutputStream fout = new FileOutputStream(new File(ctx.getDownload_dir() + in.readUTF()));
			inputByte = new byte[1024];
			System.out.println("started  ");
		
			while (true) {
				if (in != null) {
					length = in.read(inputByte, 0, inputByte.length);
				}
				if (length == -1) {
					break;
				}
				System.out.println(length);
				fout.write(inputByte, 0, length);
				fout.flush();
			}
			System.out.println("complete download");
			System.out.println("...................");
			fout.close();
			flag = false;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}*/
	
>>>>>>> 343bb2637adebdb820f50bf35f682d9df5238d53
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
		
<<<<<<< HEAD
	} 
=======
	} // UI
>>>>>>> 343bb2637adebdb820f50bf35f682d9df5238d53
} // end