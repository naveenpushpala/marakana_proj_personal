package com.marakana.contacts.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marakana.contacts.entities.Address;
import com.marakana.contacts.entities.Contact;
import com.marakana.contacts.repositories.ContactRepository;

@Controller
public class ContactController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Autowired
	private  ContactRepository contactRepository;


	/*@RequestMapping(value= "/contacts" , method=RequestMethod.GET)
	public void getContactList(HttpServletRequest request, HttpServletResponse response)
	throws ServletException,IOException{
		request.setAttribute("contacts", contactRepository.findAll());
		RequestDispatcher view = request.getRequestDispatcher("view/contact/list.jsp");
		view.forward(request, response);
	}*/
	
	@RequestMapping(value="/contacts", method=RequestMethod.GET)
	public String getContactList(Model model)
	{
		model.addAttribute("contacts",contactRepository.findAll());
		return "contact/list";
	}
	
 	/*@RequestMapping(value= "/contact" , method=RequestMethod.GET)
	public void getContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("add") != null) {
			request.getRequestDispatcher("view/contact/add.jsp").forward(request, response);
		} 
		
		else {
			//get contact id from request parameter, and populate model with
			// the contact and address objects
		long id = Long.parseLong(request.getParameter("id"));
			Contact contact = contactRepository.findOne(id);
			request.setAttribute("contact", contact);
			if(request.getParameter("edit") != null){
				
				request.getRequestDispatcher("view/contact/edit.jsp").forward(request, response);
			}
			
			request.getRequestDispatcher("view/contact/view.jsp").forward(request, response);
		
		}
	}*/

	
	@RequestMapping(value="/contact",params="add", method=RequestMethod.GET)
	public String getAddContent(){
		return "contact/add";
	}
	
	@RequestMapping(value="/contact",params="edit", method=RequestMethod.GET)
	public String getEditContact(@RequestParam long id, Model model)
	{
		model.addAttribute("contact", contactRepository.findOne(id));
		return "contact/edit";
	}

	@RequestMapping(value="/contact", method=RequestMethod.GET)
	public String getViewContact(@RequestParam long id,Model model)
	{
		model.addAttribute("contact", contactRepository.findOne(id));
		return "contact/view";
	}	
	@RequestMapping(value="/contact",params="add", method=RequestMethod.POST)
	public String postAddContact(@RequestParam String name, @RequestParam String street,@RequestParam String city, @RequestParam String state, @RequestParam String zip)
	{
		Address address = new Address(street,city,state,zip);
		Contact contact = new Contact(name,address);
		contact= contactRepository.save(contact);
		return "redirect:contact?id="+contact.getId();
	}	
	
	@RequestMapping(value="/contact",params="edit", method=RequestMethod.POST)
	public String postEditContact(@RequestParam long id,@RequestParam String name,@RequestParam String street, @RequestParam String city, @RequestParam String state, @RequestParam String zip)
	{
		Contact contact = contactRepository.findOne(id);
		Address address = contact.getAddress();
		contact.setName(name);
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setZip(zip);
		contactRepository.save(contact);
		
		return "redirect:contact?id=" +contact.getId();
	}
	
	@RequestMapping(value="/contact", params="delete",method=RequestMethod.POST)
	public String postDeleteContact(@RequestParam long id)
	{
		contactRepository.delete(id);
		return "redirect:contacts";
	}
	
	/*@RequestMapping(value= "/contact" , method=RequestMethod.POST)
	public void postContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			if (request.getParameter("add") != null) {
				Address address = new Address(request.getParameter("street"), request.getParameter("city"),
						request.getParameter("state"), request.getParameter("zip"));
				Contact contact = new Contact(request.getParameter("name"), address);
				contact = contactRepository.save(contact);
			//	response.sendRedirecst("contacts");
				response.sendRedirect("contact?id=" +contact.getId());
			}
			else if(request.getParameter("edit") != null) 
			{
				long id = Long.parseLong(request.getParameter("id"));
				Contact contact = contactRepository.findOne(id);
				Address address = contact.getAddress();
				contact.setName(request.getParameter("name"));
				address.setStreet(request.getParameter("street"));
				address.setCity(request.getParameter("city"));
				address.setState(request.getParameter("state"));
				address.setZip(request.getParameter("zip"));
				response.sendRedirect("contact?id=" +request.getParameter("id"));
				contactRepository.save(contact);
			}
			else if(request.getParameter("delete") != null)
			{
				long id = Long.parseLong(request.getParameter("id"));
				Contact contact = contactRepository.findOne(id);
				Address address = contact.getAddress();
				contactRepository.delete(contact);
				//response.sendRedirect("contact?id=" +contact.getId());
				response.sendRedirect("contacts");
			}	
		
			else
			{
				request.getRequestDispatcher("jsp/view.jsp").forward(request, response);
			}
		
	}
*/
}