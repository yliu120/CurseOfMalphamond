package edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception;

/**
 * This exception is thrown when the server can't bind the port your appointed.
 * @author Vincent Yan
 *
 */
public class ServerPortUnbindException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public ServerPortUnbindException() {
		super();
		System.out.println("Server can't bind the port your appointed.");
	}

}
