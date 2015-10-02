package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;

/**
 * The action to let the character restore a number of health.
 * @author Vincent Yan
 *
 */
public class RestoreNumHealthAction implements Action {

	private final int num;
	private final Player player;
	
	/**
	 * Constructor
	 * @param num The number of health
	 * @param player The player who has the character
	 */
	public RestoreNumHealthAction(int num, Player player) {
		this.num = num;
		this.player = player;
	}

	@Override
	public void act() {
		int health = player.getCharacter().getHealth();
		player.getCharacter().setHealth(health + this.num);
	}

}
