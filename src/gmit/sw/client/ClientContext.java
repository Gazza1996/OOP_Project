// Gary Mannion -- G00319609 -- OOP Project
// 8-1-17
package gmit.sw.client;

import java.io.Serializable;

// 
public class ClientContext implements Serializable

{
	private static final long serialVersionUID = 1L; 
	public static final String CON_FILE="src/gmit/sw/conf.xml"; // taking from conf.xml file
	private String username;
	private String server_host;
	private String server_port;
	private String download_dir;
	
	// getters & setters set up automatically
	public String getUsername() {
		return username;
	}
	public void setUserName(String clientUsername) {
		this.username = clientUsername;
	}


	public String getServer_host() {
		return server_host;
	}
	public void setServer_host(String server_host) {
		this.server_host = server_host;
	}
	public String getServer_port() {
		return server_port;
	}
	public void setServer_port(String server_port) {
		this.server_port = server_port;
	}
	public String getDownload_dir() {
		return download_dir;
	}
	public void setDownload_dir(String download_dir) {
		this.download_dir = download_dir;
	}
	
	@Override
	public String toString() {
		return "Context [username=" + username + ", server_host=" + server_host + ", server_port=" + server_port
				+ ", download_dir=" + download_dir + "]";
	}
	
}//end main