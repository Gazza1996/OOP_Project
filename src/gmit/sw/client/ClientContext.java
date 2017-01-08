// Gary Mannion -- G00319609 -- OOP Project
// 8-1-17
package gmit.sw.client;

import java.io.Serializable;

// 
public class ClientContext implements Serializable

{
	private static final long serialVersionUID = 1L; // 
	public static final String CON_FILE="src/gmit/sw/conf.xml"; // taking from conf.xml file
	private String clientUserName;
	private String serverHostName;
	private String serverPort;
	private String download;
	
	// getters & setters set up automcatically
	public String getClientUserName() {
		return clientUserName;
	}
	public void setClientUserName(String clientUserName) {
		this.clientUserName = clientUserName;
	}
	public String getServerHostName() {
		return serverHostName;
	}
	public void setServerHostName(String serverHostName) {
		this.serverHostName = serverHostName;
	}
	public String getServerPort() {
		return serverPort;
	}
	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}
	public String getDownload() {
		return download;
	}
	public void setDownload(String download) {
		this.download = download;
	}
	
/*	@Override
	public String toString() {
		return "Context [username=" + username + ", server_host=" + server_host + ", server_port=" + server_port
				+ ", download_dir=" + download_dir + "]";
	}*/
	
}//end main