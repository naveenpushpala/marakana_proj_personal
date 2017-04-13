package com.marakana.contacts.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ZipCodeValidator implements ConstraintValidator<ZipCode,String>{

	private int length;
	
	
	@Override
	public void initialize(ZipCode zipCode) {

		this.length = zipCode.length();
	}

	@Override
	public boolean isValid(String string, ConstraintValidatorContext context) {
		if(string.length() !=5)
			return false;
		for(Character c: string.toCharArray()){
			if(!c.isDigit(c))
				return false;
		}
		return true;
	
	}

		
}
