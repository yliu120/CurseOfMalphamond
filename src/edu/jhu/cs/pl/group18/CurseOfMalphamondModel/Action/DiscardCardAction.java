package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;

/**
 * The action to discard a card from a player
 * @author Vincent Yan
 *
 */
public class DiscardCardAction implements Action {

	private final int cardPos;
	private final Player player;
	private final CurseOfMalphamondModelImpl model;
	/**
	 * Constructor
	 * @param cardPos The position of the card with respect to the player's hand from left to right.
	 * @param player The player who discards the card
	 */
	public DiscardCardAction(int cardPos, Player player, CurseOfMalphamondModelImpl model) {
		this.cardPos = cardPos;
		this.player = player;
		this.model = model;
	}

	@Override
	public void act() {
		try {
			player.discardCard(this.cardPos, this.model);
		} catch (CardNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
