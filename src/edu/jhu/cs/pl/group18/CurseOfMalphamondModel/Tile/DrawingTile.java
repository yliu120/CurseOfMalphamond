/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Position;

/**
 * This class create tile which you can draw a card when you stop on the tile.
 * @author Vincent Yan
 *
 */
public class DrawingTile extends ActionTile {

	/**
	 * Default Constructor
	 */
	public DrawingTile () {
	}

	/**
	 * Constructor
	 * @param position The position of the tile
	 */
	public DrawingTile (Position position, String description) {
		super(position, description);
	}
	
	@Override
	public void act(CurseOfMalphamondModelImpl model) {
		try {
			model.getCurrentActivePlayer().drawTopDeck();
		} catch (CardNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
