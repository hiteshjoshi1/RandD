package net.hitesh.contact.service;

import java.util.List;

import net.hitesh.contact.form.Contact;

public interface ContactService {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
	public Contact getContactById(Integer id);
	public List<Contact> getContactByName(String name);
}
