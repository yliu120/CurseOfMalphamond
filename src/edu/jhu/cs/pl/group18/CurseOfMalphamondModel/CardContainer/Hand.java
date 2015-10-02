/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;

/**
 * This class extends the super class CardContainer to implement the hand of the player.
 * @author Vincent Yan
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.CardContainer
 */
public class Hand extends CardContainer {

	/**
	 * Constructor
	 */
	public Hand() {
		super();
	}

	@Override
	public boolean isEmpty() {
		return super.isEmpty();
	}

	@Override
	public void add(Card card) {
		super.add(card);
	}

	@Override
	public void remove(Card card) throws CardNotFoundException {
		super.remove(card);
	}


	/**
	 * Remove a card from the hand by its relative position in the hand from left to right
	 * @param cardPos The position of the card
	 * @throws CardNotFoundException 
	 */
	public void removeCardByPos(int cardPos) throws CardNotFoundException {
		this.remove(this.getCards().get(cardPos));
	}

}
