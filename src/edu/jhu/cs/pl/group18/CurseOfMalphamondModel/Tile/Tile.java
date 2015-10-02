/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile;

/**
 * This is a Tile interface for providing common reference to different
 * type of tiles.
 * @author Yijie
 * @version 1.0
 */
public interface Tile {

	/**
	 * This method is a common method of Tile. An important getter.
	 * @return The type of tile.
	 */
	public TileType getTileType();
	
	/**
	 * This method is a common method of Tile. It tells whether the
	 * tile can be buildable.
	 * @return True if buildable, false otherwise
	 */
	public boolean buildable();
	
	/**
	 * This method is a common method of Tile. An important getter.
	 * @return description The description of the tile.
	 */
	public String getDescription();
}
