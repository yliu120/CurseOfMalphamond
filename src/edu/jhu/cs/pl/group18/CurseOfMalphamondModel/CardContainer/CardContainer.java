/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer;

import java.util.ArrayList;
import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;

/**
 * This is a public super class interface for all kinds of CardContainer.
 * 
 * @author Vincent Yan
 *
 */
public abstract class CardContainer {
	
	protected int numCards;
	protected List<Card> cards;

	/**
	 * Constructor
	 */
	public CardContainer() {
		super();
		this.cards = new ArrayList<Card>();
		this.numCards = 0;
	}
	
	/**
	 * Get the number of cards in the container
	 * @return The number of cards
	 */
	public int getNumCards() {
		return numCards;
	}
	
	/**
	 * Get the list of cards in the container
	 * @return The list of cards
	 */
	public List<Card> getCards() {
		return cards;
	}
	
	/**
	 * Tells whether the card container is empty.
	 * @return True if empty, false otherwise
	 */
	public boolean isEmpty(){
		return numCards==0;
	}
	
	/**
	 * Add a card into the container.
	 * @param card The card being added.
	 */
	public void add(Card card){
		this.cards.add(card);
		this.numCards++;
	}
	
	/**
	 * Remove a card from the container.
	 * @param card The card being removed.
	 * @throws CardNotFoundException 
	 */
	public void remove(Card card) throws CardNotFoundException{
		if (! this.cards.contains(card)) {
			throw new CardNotFoundException();
		}
		this.cards.remove(card);
		this.numCards--;
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cards == null) ? 0 : cards.hashCode());
		result = prime * result + numCards;
		return result;
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardContainer other = (CardContainer) obj;
		if (cards == null) {
			if (other.cards != null)
				return false;
		} else if (!cards.equals(other.cards))
			return false;
		if (numCards != other.numCards)
			return false;
		return true;
	}
	
	

}
