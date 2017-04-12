package com.marakana.contacts.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Company extends Contact {

	public Company(){}
	
	public Company(String name, Set<Office> offices)
	{
		super(name);
		this.offices=offices;
	}
	
	
	@OneToMany
	private Set<Office> offices;

	public Set<Office> getOffices() {
		return offices;
	}

	public void setOffices(Set<Office> offices) {
		this.offices = offices;
	}
	
}