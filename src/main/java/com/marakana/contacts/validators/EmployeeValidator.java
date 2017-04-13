package com.marakana.contacts.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.marakana.contacts.entities.Company;
import com.marakana.contacts.entities.Person;

public class EmployeeValidator implements ConstraintValidator<Employee,Person>{

	@Override
	public void initialize(Employee employee) 
	{
		
	}

	@Override
	public boolean isValid(Person person, ConstraintValidatorContext context)		
	{
		//person must only have manager if employer is non null
		//person and manager must have same employer
		//person must not have itself in manager
	
		Company employer = person.getEmployer();
		Person manager = person.getManager();
	//	return(employer==null || manager==null || employer.equals(manager.getEmployer()));
		if(employer == null)
		{
			return manager == null;
		}
		while(manager !=null)
		{
			if(person.equals(manager)|| !employer.equals(manager.getEmployer()))
				return false;
			manager = manager.getManager();
		}
		return true;
	}

	
}
