package com.messenger.exception;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8295370162491928885L;
	
	public DataNotFoundException(String mess)
	{
		super(mess);
	}

}
