package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;

/**
 * The action to let the character gain a number of maximum health
 * @author Vincent Yan
 *
 */
public class GainNumMaxHealthAction implements Action {

	private final int num;
	private final Player player;
	/**
	 * Constructor
	 * @param num The number of maximum health
	 * @param player The player who has the character
	 */
	public GainNumMaxHealthAction(int num, Player player) {
		this.num = num;
		this.player = player;
	}
	
	@Override
	public void act() {
		
		int maxH = player.getCharacter().getMaxHealth();
		player.getCharacter().setMaxHealth(maxH + this.num); 
		
	}

}
