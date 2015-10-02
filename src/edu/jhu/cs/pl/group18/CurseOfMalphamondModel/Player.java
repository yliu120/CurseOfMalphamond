package edu.jhu.cs.pl.group18.CurseOfMalphamondModel;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.CardContainer;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.Deck;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.Hand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.UsedCards;

/**
 * This class implements the player object in the game. The player should have
 * some essential properties: hand, usedCards, and deck are the three card containers
 * that every player has; the player chooses its username and character when the
 * game starts; the player should be aware of its current position.
 * @author Aaron
 * @version 1.0
 */
public class Player {

	private Hand hand;
	private UsedCards usedCards;
	private Deck deck;
	private Integer ID;
	private String username;
	private Character character;
	private boolean active;
	private int maxHandSize;
	
	/**
	 * Empty Constructor
	 */
	public Player() {
		
	}
	
	/**
	 * Initialize the player
	 * @param username The user name
	 * @param character The character
	 */
	public void initialize(String username, Character character) {
		this.hand = new Hand();
		this.usedCards = new UsedCards();
		this.deck = new Deck(character);
		this.username = username;
		this.character = character;
		this.active = false;
		this.maxHandSize = 5;
		if (character.getName().equals("Philosopher")) {
			this.maxHandSize++;
		}
	}
	
	/**
	 * The player can move its character to another position.
	 * @param pos The position to move to
	 */
	public void moveCharacter(Position pos){
		this.character.setCurrentPosition(pos);
	}
	
	/**
	 * This method should be called if the player would like to end its turn.
	 */
	public void endTurn(){
		this.active = false;
	}
	
	/**
	 * @return the hand
	 */
	public Hand getHand() {
		return hand;
	}

	/**
	 * @param hand the hand to set
	 */
	public void setHand(Hand hand) {
		this.hand = hand;
	}

	/**
	 * @return the usedCards
	 */
	public UsedCards getUsedCards() {
		return usedCards;
	}

	/**
	 * @param usedCards the usedCards to set
	 */
	public void setUsedCards(UsedCards usedCards) {
		this.usedCards = usedCards;
	}

	/**
	 * @return the deck
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * @param deck the deck to set
	 */
	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	/**
	 * @return the iD
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(Integer iD) {
		ID = iD;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the character
	 */
	public Character getCharacter() {
		return character;
	}

	/**
	 * @param character the character to set
	 */
	public void setCharacter(Character character) {
		this.character = character;
	}

	/**
	 * See if the player is the active player
	 * @return True if the player is the active player, false otherwise
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Set this player to be the active player
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	/**
	 * Draw the card from the top of the deck
	 * @throws CardNotFoundException 
	 */
	public void drawTopDeck() throws CardNotFoundException {
		if (this.deck.getNumCards() == 0) {
			throw new CardNotFoundException();
		}
		Card card = this.deck.getCards().get(0);
		this.deck.remove(card);
		this.hand.add(card);
		this.checkCardContainerConditions();
	}
	
	/**
	 * Draw a specific card
	 * @param card The card
	 * @param model The model
	 * @throws CardNotFoundException 
	 */
	public void drawCard(Card card, CurseOfMalphamondModelImpl model) throws CardNotFoundException {
		this.hand.add(card);
		while (this.getHand().getNumCards() > this.getMaxHandSize()) {
			this.discardCard(this.getHand().getNumCards() - 1, model);
			model.myHandIsTooFull();
		}
	}
	
	
	/**
	 * Discard a card
	 * @param cardPos The position of the card with respect to the player's hand from left to right.
	 * @param model The model
	 * @throws CardNotFoundException 
	 */
	public void discardCard(int cardPos, CurseOfMalphamondModelImpl model) throws CardNotFoundException {
		if (this.hand.getNumCards() <= cardPos) {
			throw new CardNotFoundException();
		}
		Card card = this.hand.getCards().get(cardPos);
		this.hand.remove(this.hand.getCards().get(cardPos));
		CardContainer discardLocation = card.getCardType().whereToDiscard(model);
		if (discardLocation != null) {
			discardLocation.add(card);
		}
	}
	
	/**
	 * Draw a card from the resource deck
	 * @param model The model where the resource deck is in
	 * @throws CardNotFoundException 
	 */
	public void drawResourceCard(CurseOfMalphamondModelImpl model) throws CardNotFoundException {
		Card card = model.getResourceDeck().getCards().get(0);
		model.getResourceDeck().remove(card);
		this.hand.add(card);
		while (this.getHand().getNumCards() > this.getMaxHandSize()) {
			this.discardCard(this.getHand().getNumCards() - 1, model);
			model.myHandIsTooFull();
		}
		if (model.getResourceDeck().isEmpty()) {
			int numCardsToMove = model.getUsedResourceCards().getNumCards();
			Card temp;
			for (int i = 0; i < numCardsToMove; i++) {
				temp = model.getUsedResourceCards().getCards().get(0);
				model.getUsedResourceCards().remove(temp);
				model.getResourceDeck().add(temp);
			}
			model.getResourceDeck().shuffle();
		}
	}

	/**
	 * Check if the player's hand is full. If so, discard the card drawn.
	 * Check if the player's deck is empty. If so, move all cards from the player's used cards to the deck.
	 * Check if the resource deck is empty. If so, move all cards from the used resource cards to the resource deck.
	 * @throws CardNotFoundException  
	 */
	private void checkCardContainerConditions() throws CardNotFoundException {
		while (this.getHand().getNumCards() > this.getMaxHandSize()) {
			int cardPos = this.getHand().getNumCards() - 1;
			if (this.hand.getNumCards() <= cardPos) {
				throw new CardNotFoundException();
			}
			Card card = this.hand.getCards().get(cardPos);
			this.hand.remove(this.hand.getCards().get(cardPos));
			this.usedCards.add(card);
		}
		if (this.getDeck().isEmpty()) {
			int numCardsToMove = this.getUsedCards().getNumCards();
			Card temp;
			for (int i = 0; i < numCardsToMove; i++) {
				temp = this.getUsedCards().getCards().get(0);
				this.getUsedCards().remove(temp);
				this.getDeck().add(temp);
			}
			this.getDeck().shuffle();
		}
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		Player other = (Player) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	/**
	 * Get the max hand size
	 * @return The max hand size
	 */
	public int getMaxHandSize() {
		return this.maxHandSize;
	}

	/**
	 * Set the max hand size
	 * @param maxHandSize The max hand size
	 */
	public void setMaxHandSize(int maxHandSize) {
		this.maxHandSize = maxHandSize;
	}
	
	
	
	
}
