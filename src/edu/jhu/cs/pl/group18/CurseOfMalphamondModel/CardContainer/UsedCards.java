/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.UsedCardsIsEmptyException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;

/**
 * This class extends the super class CardContainer to implement the used cards pile of the player. When a
 * card is discarded or played from the hand, it is put into this pile. When the deck of a player
 * is empty, the cards from this pile is added into the deck and then the deck is shuffled.
 * @author Vincent Yan
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.CardContainer
 */
public class UsedCards extends CardContainer {

	/**
	 * Constructor
	 */
	public UsedCards() {
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
	 * Get the most recently used card
	 * @return The card
	 * @throws UsedCardsIsEmptyException 
	 */
	public Card getRecentlyUsedCard() throws UsedCardsIsEmptyException {
		if (this.cards.size() == 0) {
			throw new UsedCardsIsEmptyException();
		}
		return this.cards.get(this.cards.size() - 1);
	}

}
