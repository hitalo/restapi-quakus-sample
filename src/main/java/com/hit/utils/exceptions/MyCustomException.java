package com.hit.utils.exceptions;

import com.hit.dto.MessageResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyCustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private MessageResponse messageResponse;

	public MyCustomException(MessageResponse messageResponse) {
		super(messageResponse.getCode() + ": " + messageResponse.getMessage());
		this.messageResponse = messageResponse;
	}
}
