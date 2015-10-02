/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Position;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Monster;

/**
 * This class implements the Tile interface to provide an implementation
 * for monster tiles in the game.
 * @author Yunlong
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.MonsterTile
 */
public class MonsterTile implements Tile {

	private Monster monster;
	private Position position;
	private String description;

	/**
	 * Default Constructor
	 */
	public MonsterTile () {
	}
	
	/**
	 * Constructor
	 */
	public MonsterTile (Monster monster, Position position, String description) {
		this.monster = monster;
		this.position = position;
		this.description = description;
	}

	@Override
	public TileType getTileType() {
		return TileType.MonsterTile;
	}

	@Override
	public boolean buildable() {
		return false;
	}

	/**
	 * Get the monster in this tile
	 * @return monster the monster
	 */
	public Monster getMonster() {
		return this.monster;
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
