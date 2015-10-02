/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Position;

/**
 * This class implements the Tile interface to provide an implementation
 * for action tiles in the game.
 * @author Yunlong
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.ActionTile
 */
public abstract class ActionTile implements Tile {

	private Position position;
	private String description;

	
	/**
	 * Default Constructor
	 */
	public ActionTile () {
	}
	
	/**
	 * Constructor
	 * @param position The position of the tile
	 */
	public ActionTile (Position position, String description) {
		this.description = description;
		this.position = position;
	}

	@Override
	public TileType getTileType() {
		return TileType.ActionTile;
	}

	/**
	 * Say if the tile is buildable
	 * @return True if buildable, false otherwise
	 */
	@Override
	public boolean buildable() {
		return false;
	}

	/**
	 * Get the position of this tile
	 * @return position the position
	 */
	public Position getPosition() {
		return this.position;
	}
	
	/**
	 * Get the action of this tile
	 * @param model TODO
	 */
	public abstract void act(CurseOfMalphamondModelImpl model);
	
	@Override
	public String getDescription() {
		return this.description;
	}
}
