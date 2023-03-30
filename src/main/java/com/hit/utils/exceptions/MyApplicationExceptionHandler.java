package com.hit.utils.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.hit.dto.MessageResponse;

import lombok.extern.slf4j.Slf4j;

@Provider
@Slf4j
public class MyApplicationExceptionHandler implements ExceptionMapper<MyCustomException> {
	@Override
	public Response toResponse(MyCustomException e) {
		log.error("", e);
		return Response.status(400).entity(MessageResponse.builder().code(e.getMessageResponse().getCode())
				.message(e.getMessageResponse().getMessage()).build()).build();
	}
}
