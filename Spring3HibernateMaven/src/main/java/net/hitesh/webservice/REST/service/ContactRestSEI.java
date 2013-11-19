package net.hitesh.webservice.REST.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.hitesh.webservice.data.out.ContactServiceResponse;

@Path("/contactService")
public interface ContactRestSEI {
	
	@GET
	@Produces (MediaType.APPLICATION_XML)
	@Path("/contact/{contactid}")
	public ContactServiceResponse getContact(@PathParam ("contactid") int id);
	
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path("/contactName/{fname}")
	public List<ContactServiceResponse> getContactListByName(@PathParam("fname")String name);

}
