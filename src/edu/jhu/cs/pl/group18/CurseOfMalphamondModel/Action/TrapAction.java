/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;


/**
 * This class implements the Action class and provides an implementation
 * of the Action Trap in the game.
 * @author Home
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.HealingAction
 */
public class TrapAction implements Action{

	/**
	 * This action deducts the character health by 5.
	 */
	private Player player;
	
	public TrapAction(Player player){
		this.player = player;
	}
	@Override
	public void act() {
		int currentHealth = player.getCharacter().getHealth();
		if (currentHealth - 5 < 0) {
			player.getCharacter().setHealth(0);
		} else {
			player.getCharacter().setHealth(currentHealth - 5);
		}
	}

}
