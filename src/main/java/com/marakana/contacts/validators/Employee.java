package com.marakana.contacts.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Documented
@Constraint(validatedBy = EmployeeValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Employee {

	String message() default "manager and employee must work for same company, manaement chain must be acyclic";
	Class<?>[] groups() default {};
	Class<?>[] payload() default {};
	
	
}
