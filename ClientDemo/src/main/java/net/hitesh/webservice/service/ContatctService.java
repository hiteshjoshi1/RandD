/**
 * ContatctService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.hitesh.webservice.service;

public interface ContatctService extends java.rmi.Remote {
    public net.hitesh.webservice.service.ContactServiceResponse getContactById(java.lang.Integer contactId) throws java.rmi.RemoteException;
    public net.hitesh.webservice.service.ContactServiceResponse[] getContactByName(java.lang.String contactName) throws java.rmi.RemoteException;
}
