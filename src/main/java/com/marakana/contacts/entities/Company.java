package com.marakana.contacts.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Company extends Contact {

	public Company(){}
	
	public Company(String name, Set<Office> offices)
	{
		super(name);
		this.offices=offices;
	}
	
	

	@OneToMany(mappedBy="company",fetch=FetchType.EAGER,cascade= CascadeType.ALL,orphanRemoval=true)
	private Set<Office> offices;

	//	@JoinTable(joinColumns=@JoinColumn(name="company_id"),inverseJoinColumns=@JoinColumn(name="office_id"))

	public Set<Office> getOffices() {
		return offices;
	}

	public void setOffices(Set<Office> offices) {
		this.offices = offices;
	}

	
	
}