// Gary Mannion -- G00319609 -- OOP Project
// 8-1-17
package gmit.sw.client;
// import javax.xml.parsers.*;
// import org.w3c.dom.*;

public class ClientParser{
	private ClientContext ctx;
	
	public ClientParser(ClientContext ctx) {//  implements ClientContext class
		super(); // super class
		this.ctx = ctx;
	}
	
	// getter & setter context
	public ClientContext getCtx() {
		return ctx;
	}

	public void setCtx(ClientContext ctx) {
		this.ctx = ctx;
	}
}// end 