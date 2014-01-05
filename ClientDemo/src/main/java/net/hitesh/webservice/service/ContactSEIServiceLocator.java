/**
 * ContactSEIServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.hitesh.webservice.service;

public class ContactSEIServiceLocator extends org.apache.axis.client.Service implements net.hitesh.webservice.service.ContactSEIService {

    public ContactSEIServiceLocator() {
    }


    public ContactSEIServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ContactSEIServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for contatctServicePort
    private java.lang.String contatctServicePort_address = "http://localhost:9090/contatctServicePort";

    public java.lang.String getcontatctServicePortAddress() {
        return contatctServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String contatctServicePortWSDDServiceName = "contatctServicePort";

    public java.lang.String getcontatctServicePortWSDDServiceName() {
        return contatctServicePortWSDDServiceName;
    }

    public void setcontatctServicePortWSDDServiceName(java.lang.String name) {
        contatctServicePortWSDDServiceName = name;
    }

    public net.hitesh.webservice.service.ContatctService getcontatctServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(contatctServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getcontatctServicePort(endpoint);
    }

    public net.hitesh.webservice.service.ContatctService getcontatctServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            net.hitesh.webservice.service.ContactSEIServiceSoapBindingStub _stub = new net.hitesh.webservice.service.ContactSEIServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getcontatctServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setcontatctServicePortEndpointAddress(java.lang.String address) {
        contatctServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (net.hitesh.webservice.service.ContatctService.class.isAssignableFrom(serviceEndpointInterface)) {
                net.hitesh.webservice.service.ContactSEIServiceSoapBindingStub _stub = new net.hitesh.webservice.service.ContactSEIServiceSoapBindingStub(new java.net.URL(contatctServicePort_address), this);
                _stub.setPortName(getcontatctServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("contatctServicePort".equals(inputPortName)) {
            return getcontatctServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://hitesh.net/webservice/service", "ContactSEIService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://hitesh.net/webservice/service", "contatctServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("contatctServicePort".equals(portName)) {
            setcontatctServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
