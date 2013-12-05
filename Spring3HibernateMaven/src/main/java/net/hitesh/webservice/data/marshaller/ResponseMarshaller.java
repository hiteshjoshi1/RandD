package net.hitesh.webservice.data.marshaller;

import java.util.ArrayList;
import java.util.List;
import net.hitesh.contact.form.Contact;
import net.hitesh.webservice.data.out.ContactServiceResponse;

public class ResponseMarshaller {
	
	// Change this and use JaxB later
	public static ContactServiceResponse marshall(Contact contact)
	{
		ContactServiceResponse response= new ContactServiceResponse();
		response.setFirstname(contact.getFirstname());
		response.setLastname(contact.getLastname());
		response.setEmail(contact.getEmail());
		response.setTelephone(contact.getTelephone());
		return response;
	}
	
	public static List<ContactServiceResponse> marshall(List<Contact>contactList)
	{
		 List<ContactServiceResponse>responseList= new ArrayList<ContactServiceResponse>();
		 for(Contact contact:contactList)
		 {
				ContactServiceResponse response= new ContactServiceResponse();
				response.setFirstname(contact.getFirstname());
				response.setLastname(contact.getLastname());
				response.setEmail(contact.getEmail());
				response.setTelephone(contact.getTelephone());
				responseList.add(response);			 
		 }
		 
		return responseList;
	}

}
