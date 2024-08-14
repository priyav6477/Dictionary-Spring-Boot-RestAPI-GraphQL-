package com.dictionary.exception;

public class WordAlreadyExistsException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WordAlreadyExistsException(String message) {
        super(message);
    }
}
