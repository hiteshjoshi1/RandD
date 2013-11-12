package net.hitesh.contact.dao;

import java.util.List;

import net.hitesh.contact.form.Contact;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addContact(Contact contact) {
		sessionFactory.getCurrentSession().save(contact);
	}

	public List<Contact> listContact() {

		return sessionFactory.getCurrentSession().createQuery("from Contact")
				.list();
	}

	public void removeContact(Integer id) {
		Contact contact = (Contact) sessionFactory.getCurrentSession().load(
				Contact.class, id);
		if (null != contact) {
			sessionFactory.getCurrentSession().delete(contact);
		}

	}
//Web service Methods
	public Contact fetch(Integer id) {
		
		Contact contact = (Contact) sessionFactory.getCurrentSession().load(Contact.class, id);
		return contact;
	}

	public List<Contact> fetch(String name) {

		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Contact.class);
		cr.add(Restrictions.ilike("firstname",name));

		return cr.list();
	}
}
