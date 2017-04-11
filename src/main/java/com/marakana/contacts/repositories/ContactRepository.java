package com.marakana.contacts.repositories;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.marakana.contacts.entities.Contact;

public class ContactRepository extends Repository<Contact> {

	private final EntityManager em = Persistence.createEntityManagerFactory("training").createEntityManager();
	

	public ContactRepository(){
		super(Contact.class);
	}
}