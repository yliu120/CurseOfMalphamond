/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer;

import java.util.Collections;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;

/**
 * This class extends the super class CardContainer to implement a resource deck containing the cards that
 * players can draw from a Resource Tile.
 * @author Vincent Yan
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.CardContainer
 */
public class ResourceDeck extends CardContainer {
	
	/**
	 * Constructor
	 */
	public ResourceDeck() {
		super();
		// TODO Auto-generated method stub
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
	 * Shuffle the cards in the container
	 */
	public void shuffle() {
		Collections.shuffle(this.cards);
	}

}
