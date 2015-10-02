/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Position;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.RestoreNumHealthAction;

/**
 * The Healing Fountain is at the opposite corner of the starting point. If a character steps on this tile,
 * the character restores to full health.
 * @author Vincent Yan
 *
 */
public class HealingFountainTile extends ActionTile {

	/**
	 * Default constructor
	 */
	public HealingFountainTile() {

	}

	/**
	 * Constructor
	 * @param position The position of the tile
	 */
	public HealingFountainTile(Position position) {
		super(position, "Healing Fountain");
	}

	@Override
	public void act(CurseOfMalphamondModelImpl model) {
		model.healingFountainAct();
	}
	
	
}
