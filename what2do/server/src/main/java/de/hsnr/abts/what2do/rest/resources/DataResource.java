
package de.hsnr.abts.what2do.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/data")
public class DataResource {
	public DataResource() {
		System.out.println("Neue Instanz von HelloResource: " + this);
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getPlainMessage() {
		return "Herzlich willkommen!";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHtmlMessage() {
		return "<html><body><h1>Herzlich willkommen!<h1></body></html>";
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String getXmlMessage() {
		return "<?xml version=\"1.0\"?><hello>Herzlich willkommen!</hello>";
	}
	
	@Path("/extended")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getPlainMessageExtended() {
		return "Herzlich willkommen! Und gute Unterhaltung.";
	}
}

