package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;


/**
 * The action to let the character gain a number of attack
 * @author Vincent Yan
 *
 */
public class GainNumAttackAction implements Action {

	private final int num;
	private final Player player;
	/**
	 * Constructor
	 * @param num The number of attack
	 * @param player The player who has the character
	 */
	public GainNumAttackAction(int num, Player player) {
		this.num = num;
		this.player = player;
	}
	
	@Override
	public void act() {
		
		int attack = player.getCharacter().getAttack();
		player.getCharacter().setAttack( attack + this.num );
		
	}

}
