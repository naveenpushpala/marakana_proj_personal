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
import com.marakana.contacts.entities.Company;
import com.marakana.contacts.entities.Office;
import com.marakana.contacts.repositories.CompanyRepository;
import com.marakana.contacts.repositories.OfficeRepository;

@Controller
public class OfficeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Autowired
	private  OfficeRepository officeRepository;

	@Autowired
	private CompanyRepository companyRepository;

	/*@RequestMapping(value= "/contacts" , method=RequestMethod.GET)
	public void getContactList(HttpServletRequest request, HttpServletResponse response)
	throws ServletException,IOException{
		request.setAttribute("contacts", contactRepository.findAll());
		RequestDispatcher view = request.getRequestDispatcher("view/contact/list.jsp");
		view.forward(request, response);
	}*/
	
	
	
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
	}
*/
	
	@RequestMapping(value="/office",params="add", method=RequestMethod.GET)
	public String getAddOffice(@RequestParam("company_id") long companyId,Model model){
		model.addAttribute("company",companyRepository.findOne(companyId));
		return "office/add";
	}
	
	@RequestMapping(value="/office",params="edit", method=RequestMethod.GET)
	public String getEditOffice(@RequestParam long id, Model model)
	{
		model.addAttribute("office", officeRepository.findOne(id));
		return "office/edit";
	}

	@RequestMapping(value="/office", method=RequestMethod.GET)
	public String getViewOffice(@RequestParam long id,Model model)
	{
		model.addAttribute("office", officeRepository.findOne(id));
		return "office/view";
	}	
	@RequestMapping(value="/office",params="add", method=RequestMethod.POST)
	public String postAddOffice(@RequestParam("company_id") long companyId,@RequestParam String name, @RequestParam String street,@RequestParam String city, @RequestParam String state, @RequestParam String zip)
	{
		Address address = new Address(street,city,state,zip);
		Company company = companyRepository.findOne(companyId);
		Office office = new Office(name,address,company);
		office= officeRepository.save(office);
		return "redirect:office?id="+office.getId();
	}	
	
	@RequestMapping(value="/office",params="edit", method=RequestMethod.POST)
	public String postEditOffice(@RequestParam long id,@RequestParam String name,@RequestParam String street, @RequestParam String city, @RequestParam String state, @RequestParam String zip)
	{
		Office office = officeRepository.findOne(id);
		Address address =office.getAddress();
		office.setName(name);
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setZip(zip);
		officeRepository.save(office);
		
		return "redirect:office?id=" +office.getId();
	}
	
	@RequestMapping(value="/office", params="delete",method=RequestMethod.POST)
	public String postDeleteOffice(@RequestParam long id)
	{
		Office office = officeRepository.findOne(id);
		officeRepository.delete(id);
		return "redirect:" +office.getCompany().getUrl();
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
		
	}*/

}