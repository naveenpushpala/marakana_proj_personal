package com.marakana.contacts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Address extends BaseEntity{

	
	@Column(nullable=false)
	@NotBlank
	private String Street;
	@Column(nullable=false)
	private String city;
	@Column(nullable=false,length=64)
	private String state;
	@Column(nullable=false,length=64)
	private String zip;
	
	public Address(){}
	
	public Address(String street, String city, String state, String zip) {
		super();
		this.Street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	
	
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
}