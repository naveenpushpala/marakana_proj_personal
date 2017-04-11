/*package com.marakana.contacts.servlets;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.marakana.contacts.entities.Address;
import com.marakana.contacts.entities.Contact;
import com.marakana.contacts.repositories.AddressRepository;
import com.marakana.contacts.repositories.ContactRepository;
//import com.marakana.contacts.repositories.ContactRepository;

@WebListener
public class Setup implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		// instantiate Address Repository
		
		 * try { AddressRepository addressRepository = new AddressRepository();
		 * try { addressRepository.init(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } Address address =
		 * new Address("150 West Tasman Dr.", "San Jose", "CA", "505111"); try {
		 * addressRepository.create(address); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * } catch (NamingException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 

		ContactRepository contactRepository = null;
		contactRepository = new ContactRepository();
		AddressRepository addressRepository = new AddressRepository();

		try {
			addressRepository.init();
			contactRepository.init();
			new AddressRepository().create(new Address("Boston","New Jersey","23 street","hi" ));
			new ContactRepository().create(new Contact("dan", 0L));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}*/