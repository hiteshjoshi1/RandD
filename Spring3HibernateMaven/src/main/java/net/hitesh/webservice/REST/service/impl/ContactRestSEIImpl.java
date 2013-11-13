package net.hitesh.webservice.REST.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import net.hitesh.webservice.REST.service.ContactRestSEI;
import net.hitesh.webservice.data.out.ContactServiceResponse;
import net.hitesh.webservice.processor.ContactProcessor;

@Service
@Transactional
public class ContactRestSEIImpl implements ContactRestSEI {
	
	@Autowired
	ContactProcessor contactProcessor;

	@Override
	public ContactServiceResponse getContact( int id) {
		
		return contactProcessor.getContactById(id);
	}

	@Override
	public List<ContactServiceResponse> getContactListByName(String name) {

		return contactProcessor.getContactByName(name);
	}

}
