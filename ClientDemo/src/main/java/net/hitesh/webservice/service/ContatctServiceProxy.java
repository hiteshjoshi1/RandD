package net.hitesh.webservice.service;

import javax.xml.rpc.Stub;

public class ContatctServiceProxy implements net.hitesh.webservice.service.ContatctService {
  private String _endpoint = null;
  private net.hitesh.webservice.service.ContatctService contatctService = null;
  
  public ContatctServiceProxy() {
    _initContatctServiceProxy();
  }
  
  public ContatctServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initContatctServiceProxy();
  }
  
  private void _initContatctServiceProxy() {
    try {
      contatctService = (new net.hitesh.webservice.service.ContactSEIServiceLocator()).getcontatctServicePort();
      if (contatctService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)contatctService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)contatctService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
   //   ((javax.xml.rpc.Stub)contatctService)._setProperty(Stub.USERNAME_PROPERTY, "wsuser");
     // ((javax.xml.rpc.Stub)contatctService)._setProperty(Stub.PASSWORD_PROPERTY, "wspwd");


    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (contatctService != null)
      ((javax.xml.rpc.Stub)contatctService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public net.hitesh.webservice.service.ContatctService getContatctService() {
    if (contatctService == null)
      _initContatctServiceProxy();
    return contatctService;
  }
  
  public net.hitesh.webservice.service.ContactServiceResponse getContactById(java.lang.Integer contactId) throws java.rmi.RemoteException{
    if (contatctService == null)
      _initContatctServiceProxy();
    return contatctService.getContactById(contactId);
  }
  
  public net.hitesh.webservice.service.ContactServiceResponse[] getContactByName(java.lang.String contactName) throws java.rmi.RemoteException{
    if (contatctService == null)
      _initContatctServiceProxy();
    return contatctService.getContactByName(contactName);
  }
  
  
}