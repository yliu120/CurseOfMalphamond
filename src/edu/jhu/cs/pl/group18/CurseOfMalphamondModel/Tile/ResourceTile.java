/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Position;

/**
 * This class create resouce tile. 
 * When a character step on this kind of tiles, he will draw a resource card.
 * @author Yunlong
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.ResourceTile
 */
public class ResourceTile implements Tile {

	private Position position;
	private String description;

	/**
	 * Default Constructor
	 */
	public ResourceTile () {
	}
	
	/**
	 * Constructor
	 */
	public ResourceTile (Position position, String description) {
		this.position = position;
		this.description = description;
	}

	@Override
	public TileType getTileType() {
		return TileType.ResourceTile;
	}

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

	@Override
	public String getDescription() {
		return this.description;
	}
}
