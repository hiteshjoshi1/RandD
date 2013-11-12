package net.hitesh.webservice.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.ResponseWrapper;

import net.hitesh.webservice.data.out.ContactServiceResponse;


@WebService(name="contatctService",targetNamespace="http://hitesh.net/webservice/service")
@SOAPBinding(style=Style.DOCUMENT,use=Use.LITERAL)
public interface ContactSEI {

	@WebMethod(operationName="getContactById")  
	@ResponseWrapper(targetNamespace="http://hitesh.net/webservice/types", className=" net.hitesh.webservice.data.out.ContactServiceResponse")
	public @WebResult (name = "contactListResponse", targetNamespace = "http://hitesh.net/webservice/types") ContactServiceResponse getContactThruId(@WebParam(name="ContactId") Integer id);
	
	@WebMethod(operationName="getContactByName") 
	@ResponseWrapper(targetNamespace="http://hitesh.net/webservice/types", className=" net.hitesh.webservice.data.out.ContactServiceResponse")
	public @WebResult (name = "contactListResponse", targetNamespace = "http://hitesh.net/webservice/types")  List<ContactServiceResponse>   getContactThruName(@WebParam(name="ContactName") String name);
}
