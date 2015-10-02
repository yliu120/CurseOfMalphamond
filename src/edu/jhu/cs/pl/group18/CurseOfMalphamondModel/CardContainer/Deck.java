/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer;

import java.util.Collections;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.Courage;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.Fortitude;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.GrandMarch;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.GrandRetreat;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.GreatCourage;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.GreatFortitude;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.HealthPotion;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.Longevity;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.March;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.Panacea;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.Retreat;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.Slash;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;

/**
 * This class extends the super class CardContainer to implement the deck of the player where the player
 * draws cards from.
 * @author Vincent Yan
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.CardContainer
 */
public class Deck extends CardContainer {
	
	/**
	 * Empty Constructor 
	 */
	public Deck() {
	}

	/**
	 * Constructor for a character
	 * @param character The character 
	 */
	public Deck(Character character) {
		super();
		this.add(new Courage());
		//Dart
		this.add(new Fortitude());
		this.add(new GrandMarch());
		this.add(new GrandRetreat());
		this.add(new GreatCourage());
		this.add(new GreatFortitude());
		this.add(new HealthPotion());
		this.add(new Longevity());
		this.add(new March());
		this.add(new Panacea());
		//Reroll
		this.add(new Retreat());
		this.add(new Slash());
		//this.add(character.getCharacterCard());
		this.shuffle();
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
	
	/**
	 * Put a card into a specific position in the deck
	 * @param card The card to put
	 * @param position The position of the card in the deck, 0 being top deck
	 */
	public void putCard(Card card, int position) {
		this.cards.add(position, card);
	}

}
