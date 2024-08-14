package com.dictionary.exception;

public class WordAlreadyExistsException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7829282381100797360L;

	public WordAlreadyExistsException(String message) {
        super(message);
    }
}
