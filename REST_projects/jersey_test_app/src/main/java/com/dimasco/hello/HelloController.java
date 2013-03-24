package com.dimasco.hello;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Sets the path to base URL + /hello
@Path("/hello")
public class HelloController {
	
	// This method is called when TEXT_PLAIN is requested.
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String seyPlainTextHello() {
		return "Hello Jersey";
	}
	
	// This method is called when XML is requested.
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	}
	
	// This method is called when HTML is requested.
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHTMLHello() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
		        + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
	}

}
