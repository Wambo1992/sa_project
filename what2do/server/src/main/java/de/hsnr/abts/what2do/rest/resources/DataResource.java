package de.hsnr.abts.what2do.rest.resources;

import java.util.List;
import java.util.logging.LogManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;

import de.hsnr.abts.what2do.business.BusinessFactory;
import de.hsnr.abts.what2do.business.User;
import de.hsnr.abts.what2do.commons.rest.RestDefinition;

/**
 * Example resource class hosted at the URI path "/myresource"
 */
@Path("/data")
public class DataResource {
	BusinessFactory factory;
	public DataResource() {
		factory = new BusinessFactory();
		System.out.println("Neue Instanz von HelloResource: " + this);
	}

	@Path(RestDefinition.GET_DATA_USER_ALL)
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getUsers() {
		List<User> list = factory.getUsers();
		StringBuilder builder = new StringBuilder();
		for(User u : list) {
			builder.append(u);
		}
		return builder.toString();
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
