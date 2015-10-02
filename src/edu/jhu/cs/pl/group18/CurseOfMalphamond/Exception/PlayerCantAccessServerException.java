package edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception;

/**
 * This exception is thrown when a player can't access the server.
 * @author Vincent Yan
 *
 */
public class PlayerCantAccessServerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public PlayerCantAccessServerException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "The player cannot reach server!";
	}
	
	
	
}
