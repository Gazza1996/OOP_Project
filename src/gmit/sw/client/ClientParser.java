// Gary Mannion -- G00319609 -- OOP Project
// 8-1-17
package gmit.sw.client;
<<<<<<< HEAD
// import javax.xml.parsers.*;
// import org.w3c.dom.*;

public class ClientParser{
	private ClientContext ctx;
	
	public ClientParser(ClientContext ctx) {//  implements ClientContext class
		super(); // super class
		this.ctx = ctx;
	}
	
	// getter & setter context
=======
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class ClientParser{
	private ClientContext ctx;


	public ClientParser(ClientContext ctx) {
		super();
		this.ctx = ctx;
	}
	
	//get set ctx
>>>>>>> 343bb2637adebdb820f50bf35f682d9df5238d53
	public ClientContext getCtx() {
		return ctx;
	}

	public void setCtx(ClientContext ctx) {
		this.ctx = ctx;
	}
<<<<<<< HEAD
}// end 
=======

	// method to parse an XML file into a DOM tree
	public void init() throws Throwable{
		
		//get the factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
		//get a new instance 
		DocumentBuilder db = dbf.newDocumentBuilder();
		//parse the file 
		Document doc = db.parse(ClientContext.CON_FILE);
		
		// returns the root element 
		Element root = doc.getDocumentElement();
		// gets childs node
		NodeList children = root.getChildNodes();
		
		
		//find the elements
		NamedNodeMap atts = root.getAttributes();
		
		for(int j=0;j<atts.getLength();j++)
		{
			if(atts.item(j).getNodeName().equals("username")){
				ctx.setClientUserName(atts.item(0).getNodeValue());
			}
		}//end for
		
		for(int i=0;i<children.getLength();i++){
			Node next = children.item(i);
			
			if(next instanceof Element){
				Element e = (Element)next;
				
			if(e.getNodeName().equals("server-host")){
					ctx.setServerHostName(e.getTextContent());
				}
			else if(e.getNodeName().equals("server-port")){
					ctx.setServerHostName(e.getTextContent());
				}
			else if(e.getNodeName().equals("download-dir")){
					ctx.setDownload(e.getTextContent());
				}
				
			}	//end if 
		} //end for 
	}// init 

}// end parser
>>>>>>> 343bb2637adebdb820f50bf35f682d9df5238d53
