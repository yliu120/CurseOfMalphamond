package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;

/**
 * The action to skip a player's turn
 * @author Vincent Yan
 *
 */
public class SkipTurnAction implements Action {

	private final Player player;
	
	/**
	 * Constructor
	 * @param player The player
	 */
	public SkipTurnAction(Player player) {
		this.player = player;
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub

	}

}
