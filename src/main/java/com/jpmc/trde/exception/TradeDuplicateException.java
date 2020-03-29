package com.jpmc.trde.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TradeDuplicateException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public TradeDuplicateException(String message) {
		super(message);
	}

}
