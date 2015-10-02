/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Position;

/**
 * The action to move the character forward a number of tiles. If the character passes the starting tile,
 * the player draws 2 cards.
 * @author Vincent Yan
 *
 */
public class MoveNumTilesAction implements Action {

	private final int num;
	private final Player player;
	
	/**
	 * Constructor
	 * @param num The number of tiles to move forward
	 * @param player The player who has the character
	 */
	public MoveNumTilesAction(int num, Player player) {
		this.num = num;
		this.player = player;
	}
	
	@Override
	public void act() {
		
		Position pos = player.getCharacter().getCurrentPosition();
		int oldPos = pos.getTilePosition();
		pos.movePosition(num, 28);
		if ((oldPos > pos.getTilePosition()) && (oldPos - pos.getTilePosition() > 10)) {
			
			// player character level up
			player.getCharacter().setLevel(player.getCharacter().getLevel() + 1);
			
			// draw two cards
			(new DrawNumCardAction(2, player)).act();
		}
		player.moveCharacter(pos);
	}
}
