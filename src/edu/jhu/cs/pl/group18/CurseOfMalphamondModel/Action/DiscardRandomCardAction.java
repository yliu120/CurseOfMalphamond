package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;

/**
 * The action to discard a random card from a player
 * @author Vincent Yan
 *
 */
public class DiscardRandomCardAction implements Action {

	private final Player player;
	private final CurseOfMalphamondModelImpl model;
	/**
	 * Constructor
	 * @param player The player who discards the card
	 */
	public DiscardRandomCardAction(Player player, CurseOfMalphamondModelImpl model) {
		this.player = player;
		this.model = model;
	}

	@Override
	public void act() {
		try {
			int numCardsInHand = player.getHand().getNumCards();
			player.discardCard((int) Math.random() * numCardsInHand, this.model);
		} catch (CardNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
