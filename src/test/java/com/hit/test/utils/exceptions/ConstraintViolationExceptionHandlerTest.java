package com.hit.test.utils.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.junit.jupiter.api.Test;

import com.hit.dto.PersonRequest;
import com.hit.utils.exceptions.ConstraintViolationExceptionHandler;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ConstraintViolationExceptionHandlerTest {
	
	@Inject
	ConstraintViolationExceptionHandler constraintViolationExceptionHandler;
	
	@Inject
	Validator validator;

	@Test
	void toResponseTest() {
		Set<ConstraintViolation<PersonRequest>> violations = validator.validate(new PersonRequest());
		assertEquals(400, constraintViolationExceptionHandler.toResponse(new ConstraintViolationException(violations)).getStatus());
	}
	
}
