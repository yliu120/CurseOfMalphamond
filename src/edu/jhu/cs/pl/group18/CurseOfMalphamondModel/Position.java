/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel;

/**
 * This class enclose a position of tiles on the board.
 * @author Yunlong
 * @version 1.0
 */
public class Position {
	
	private int tilePosition;
	
	public Position() {
		this.tilePosition = 0;
	}

	/**
	 * Constructor, using an integer to construct a tile 's position
	 * @param tilePosition
	 */
	public Position( int tilePosition ) {
		this.tilePosition = tilePosition;
	}
	
	/**
	 * move the position forward or backward
	 * @param step how many steps to move
	 * @param size the size of the board.
	 */
	public void movePosition( int step, int size) {
		this.tilePosition = (this.tilePosition + step + size ) % size;
	}

	/**
	 * Call this function to get the tile position.
	 * @return The tile position.
	 */
	public int getTilePosition() {
		return tilePosition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tilePosition;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position thisPos = (Position) obj;
		if ( this.tilePosition != thisPos.tilePosition ) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString(){
		return "Position: " + this.tilePosition;
	}

}
