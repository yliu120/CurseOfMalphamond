package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.InvalidTimeException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Position;

/**
 * 
 * This class create movement tile. The character will move when step on this kind of tiles.
 * 
 * @author Yijie
 *
 */


public class MovementTile extends ActionTile {
	
	/**
	 * Default Constructor
	 */
	public MovementTile () {
	}

	/**
	 * Constructor
	 * @param position The position of the tile
	 */
	public MovementTile (Position position, String description) {
		super(position, description);
	}

	@Override
	public void act(CurseOfMalphamondModelImpl model) {
		try {
			model.moveCharacter(3);
		} catch (InvalidTimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
