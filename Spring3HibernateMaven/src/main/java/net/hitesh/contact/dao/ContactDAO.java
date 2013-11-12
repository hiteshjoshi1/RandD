package net.hitesh.contact.dao;

import java.util.List;

import net.hitesh.contact.form.Contact;

public interface ContactDAO {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
	public Contact fetch(Integer id);
	public List<Contact> fetch(String name);
}
