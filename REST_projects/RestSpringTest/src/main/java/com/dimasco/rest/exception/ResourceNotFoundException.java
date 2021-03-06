package com.dimasco.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * serial version id generated by default.
	 */
	private static final long serialVersionUID = 819418197540725143L;

}
