package com.hit.utils.exceptions;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import lombok.extern.slf4j.Slf4j;

@Provider
@Slf4j
public class ConstraintViolationExceptionHandler implements ExceptionMapper<ConstraintViolationException> {
	@Override
	public Response toResponse(ConstraintViolationException e) {
		log.error("", e);
		return Response.status(400).entity(e.getConstraintViolations().stream()
                .map(cv -> cv.getMessage())
                .collect(Collectors.joining(", "))).build();
	}
}