/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer;

import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;

/**
 * This class extends the super class CardContainer to implement the used resource cards pile. When a
 * resource card is discarded or played from the hand, it is put into this pile. When the resource deck
 * is empty, the cards from this pile is added into the resource deck and then the resource deck is shuffled.
 * @author Vincent Yan
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.CardContainer
 */
public class UsedResourceCards extends CardContainer {

	@Override
	public int getNumCards() {
		return super.getNumCards();
	}

	@Override
	public List<Card> getCards() {
		return super.getCards();
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

}
