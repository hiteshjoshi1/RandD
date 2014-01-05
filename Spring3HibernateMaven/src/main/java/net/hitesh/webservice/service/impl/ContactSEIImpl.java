package net.hitesh.webservice.service.impl;


import java.util.List;
import javax.jws.WebService;

import org.apache.cxf.annotations.Policies;
import org.apache.cxf.annotations.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.hitesh.webservice.data.out.ContactServiceResponse;
import net.hitesh.webservice.processor.ContactProcessor;
import net.hitesh.webservice.service.ContactSEI;


//@Policies({@Policy(uri = "MySecurityPolicy.xml")}) 
@Transactional
@WebService(endpointInterface="net.hitesh.webservice.service.ContactSEI",
targetNamespace="http://hitesh.net/webservice/service",
portName="ContactSEIImplPort",
serviceName="ContactService"
)
@Service
public class ContactSEIImpl implements ContactSEI {
	@Autowired
	private ContactProcessor  contactProcessor;

	
	public ContactServiceResponse getContactThruId(Integer id) {

		return contactProcessor.getContactById(id);
	}

	
	public List<ContactServiceResponse> getContactThruName( String name) {
		
		return contactProcessor.getContactByName(name);
	}

}
