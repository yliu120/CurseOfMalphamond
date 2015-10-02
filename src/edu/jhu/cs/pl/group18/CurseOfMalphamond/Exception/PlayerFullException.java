/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception;

/**
 * Call this exception when player number reaches maximum.
 * @author Yunlong
 *
 */
public class PlayerFullException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Players number reaches 4 - WE ARE FULL.";
	}

}
