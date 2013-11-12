package net.hitesh.webservice.processor;

import java.util.List;

import net.hitesh.webservice.data.out.ContactServiceResponse;

public interface ContactProcessor {

	ContactServiceResponse getContactById(Integer id);

	List<ContactServiceResponse> getContactByName(String name);
}
