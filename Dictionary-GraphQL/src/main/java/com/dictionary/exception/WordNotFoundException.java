package com.dictionary.exception;

public class WordNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 905976020202711019L;

	public WordNotFoundException(String message) {
		super(message);
	}
}
