/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception;

/**
 * This exception is thrown when the use time is invalid.
 * @author andyyang
 *
 */
public class InvalidTimeException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "The action you performed is in an invalid time";
	}

}
