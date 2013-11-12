package net.hitesh.webservice.processor.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.hitesh.contact.form.Contact;
import net.hitesh.contact.service.ContactService;
import net.hitesh.webservice.data.marshaller.ResponseMarshaller;
import net.hitesh.webservice.data.out.ContactServiceResponse;
import net.hitesh.webservice.processor.ContactProcessor;

@Component
public class ContactProcessorImpl implements ContactProcessor {
	
	@Autowired
	private ContactService contactService;

	public ContactServiceResponse getContactById(Integer id) {
	
	Contact contact=contactService.getContactById(id);
		return 	ResponseMarshaller.marshall(contact);
	}

	public List<ContactServiceResponse> getContactByName(String name) {
		List<Contact> contactList=contactService.getContactByName(name);
		return ResponseMarshaller.marshall(contactList);
	}

}
