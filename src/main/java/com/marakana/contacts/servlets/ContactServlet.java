package com.marakana.contacts.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marakana.contacts.entities.Address;
import com.marakana.contacts.entities.Contact;
import com.marakana.contacts.repositories.AddressRepository;
import com.marakana.contacts.repositories.ContactRepository;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final AddressRepository addressRepository = new AddressRepository();
	private final ContactRepository contactRepository = new ContactRepository();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("add") != null) {
			request.getRequestDispatcher("jsp/addContact.jsp").forward(request, response);
		} 
		
		else {
			//get contact id from request parameter, and populate model with
			// the contact and address objects
		long id = Long.parseLong(request.getParameter("id"));
			Contact contact = contactRepository.find(id);
			Address address = addressRepository.find(id);
			request.setAttribute("contact", contact);
			request.setAttribute("address", address);
			if(request.getParameter("edit") != null){
				
				request.getRequestDispatcher("jsp/editContact.jsp").forward(request, response);

			}
			
			request.getRequestDispatcher("jsp/viewContact.jsp").forward(request, response);
		
		
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

			if (request.getParameter("add") != null) {
				Address address = new Address(request.getParameter("street"), request.getParameter("city"),
						request.getParameter("state"), request.getParameter("zip"));
				address =addressRepository.save(address);
				Contact contact = new Contact(request.getParameter("name"), address.getId());
				contact = contactRepository.save(contact);
			//	response.sendRedirecst("contacts");
				response.sendRedirect("contact?id=" +contact.getId());
			}
			else if(request.getParameter("edit") != null) 
			{
				long id = Long.parseLong(request.getParameter("id"));
				Contact contact = contactRepository.find(id);
				Address address = addressRepository.find(contact.getAddressId());
				contact.setName(request.getParameter("name"));
				address.setStreet(request.getParameter("street"));
				address.setCity(request.getParameter("city"));
				address.setState(request.getParameter("state"));
				address.setZip(request.getParameter("zip"));
				response.sendRedirect("contact?id=" +request.getParameter("id"));
				contactRepository.save(contact);
				addressRepository.save(address);
			}
			else if(request.getParameter("delete") != null)
			{
				long id = Long.parseLong(request.getParameter("id"));
				Contact contact = contactRepository.find(id);
				Address address = addressRepository.find(contact.getAddressId());
				contactRepository.delete(contact);
				addressRepository.delete(address);
				//response.sendRedirect("contact?id=" +contact.getId());
				response.sendRedirect("contacts");
			}	
		
			else
			{
				request.getRequestDispatcher("jsp/viewContact.jsp").forward(request, response);
			}
		
	}

}