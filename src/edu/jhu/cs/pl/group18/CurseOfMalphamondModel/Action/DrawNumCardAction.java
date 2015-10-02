package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;

/**
 * The action to draw a number of cards
 * @author Vincent Yan
 *
 */
public class DrawNumCardAction implements Action {

	private final int num;
	private final Player player;
	/**
	 * Constructor
	 * @param num The number of cards
	 * @param player The player who draws the cards
	 */
	public DrawNumCardAction(int num, Player player) {
		this.num = num;
		this.player = player;
	}

	@Override
	public void act() {
		for (int i = 0; i < this.num; i++) {
			try {
				player.drawTopDeck();
			} catch (CardNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
