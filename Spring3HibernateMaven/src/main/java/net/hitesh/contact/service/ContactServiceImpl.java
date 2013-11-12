package net.hitesh.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.hitesh.contact.dao.ContactDAO;
import net.hitesh.contact.form.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO contactDAO;
	
	@Transactional
	public void addContact(Contact contact) {
		contactDAO.addContact(contact);
	}

	@Transactional
	public List<Contact> listContact() {

		return contactDAO.listContact();
	}

	@Transactional
	public void removeContact(Integer id) {
		contactDAO.removeContact(id);
	}

	public Contact getContactById(Integer id) {
		
		return contactDAO.fetch(id);
	}

	public List<Contact> getContactByName(String name) {
		
		return contactDAO.fetch(name);
	}
}
