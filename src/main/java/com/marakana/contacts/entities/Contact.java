package com.marakana.contacts.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Contact {

	public Contact(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
		
	}
	
	public Contact(){}
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Address address;
	
	@Column
	private String phoneNumber;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Long addressId) {
		this.address = address;
	}	
	
}