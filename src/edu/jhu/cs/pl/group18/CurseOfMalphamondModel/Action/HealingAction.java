/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;


/**
 * This class implements the Action class and provides an implementation
 * of the Action Healing in the game.
 * @author Home
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.HealingAction
 */
public class HealingAction implements Action{

	/**
	 * This action heals the character health by 10.
	 */
	private Player player;
	
	public HealingAction(Player player) {
		super();
		this.player = player;
	}

	@Override
	public void act() {
		int currentHealth = player.getCharacter().getHealth();
		player.getCharacter().setHealth(currentHealth + 10);
	}
}
