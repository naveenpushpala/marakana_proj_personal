package com.marakana.contacts.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Documented
@Constraint(validatedBy = ZipCodeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ZipCode {
	
	String message() default "zip code must be five : numeric characters";
	
	Class<?>[] groups() default{};
	
	Class<?>[] payload() default{};

	
	int length() default 5;
}
