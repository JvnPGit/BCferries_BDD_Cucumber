package com.cucumberbdd.automationFramework.logUtils;

public class UserDefinedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	 * This method is a constructor
	 */
	public UserDefinedException() {
		super();
	}
	
	/**
	 * This method is used to define a User Defined Excpetion
	 * @param e
	 */
	public UserDefinedException(Exception e) {
		super(e);
	}
}
