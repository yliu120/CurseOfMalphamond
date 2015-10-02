package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;


/**
 * The action to let the character gain a number of defense
 * @author Vincent Yan
 *
 */
public class GainNumDefenseAction implements Action {

	private final int num;
	private final Player player;
	/**
	 * Constructor
	 * @param num The number of defense
	 * @param player The player who has the character
	 */
	public GainNumDefenseAction(int num, Player player) {
		this.num = num;
		this.player = player;
	}
	
	@Override
	public void act() {
	
		int defense = player.getCharacter().getDefense();
		player.getCharacter().setDefense( defense + this.num );
		
	}
	
}
