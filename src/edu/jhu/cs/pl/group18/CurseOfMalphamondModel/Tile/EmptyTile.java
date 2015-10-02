/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Position;

/**
 * This class implements the Tile interface to provide an implementation of
 * a particular type of tile - EmptyTile
 * @author Home
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.EmptyTile
 */
public class EmptyTile implements Tile {

	private Position position;
	private String description;

	
	/**
	 * Default Constructor
	 */
	public EmptyTile () {
	}
	
	
	/**
	 * Constructor
	 */
	public EmptyTile (Position position, String description) {
		this.position = position;
		this.description = description;
	}

	@Override
	public TileType getTileType() {
		return TileType.EmptyTile;
	}

	@Override
	public boolean buildable() {
		return true;
	}

	/**
	 * Get the position of this tile
	 * @return position the position
	 */
	public Position getPosition() {
		return this.position;
	}
	
	@Override
	public String getDescription() {
		return this.description;
	}
}
