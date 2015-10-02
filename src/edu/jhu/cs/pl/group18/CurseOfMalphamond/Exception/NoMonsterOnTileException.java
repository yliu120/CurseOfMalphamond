/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception;

/**
 * This exception is thrown when there is no monster on the tile.
 * @author Yunlong
 *
 */
public class NoMonsterOnTileException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor
	 */
	public NoMonsterOnTileException() {
		super();
		System.out.println("Here is not a monster tile apparently.");
	}

}
