package com.dimasco.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	/**
	 * Default generated serial version id.
	 */
	private static final long serialVersionUID = 2343454353L;

}
