/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Position;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;

/**
 * This class extends the Actor abstract class and provides an implementation
 * of the Character in the game.
 * @author Home
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Actor
 */
public abstract class Character extends Actor {
	
	protected int level;
	protected String description;
	protected int cardNumber;
	protected Position currentPosition;
	
	/**
	 * Default Constructor
	 */
	public Character() {
	}

	/**
	 * Constructor
	 */
	public Character(int maxHealth, int attack, int defense,
			String name, String description) {
		super(maxHealth, attack, defense, name);
		this.description = description;
		this.level = 1;
		this.cardNumber = 3;
		this.currentPosition = new Position(0);
	}

	/**
	 * This method can revive the character to be fully active.
	 */
	public void revive(){
		this.health = this.maxHealth;
	}

	/**
	 * Get the level of the character
	 * @return level
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * Character level up
	 */
	public void levelUp() {
		this.level += 1;
	}

	/**
	 * Set the level of the character
	 * @param level the level of character
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
	 * Get the description for the character
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Get the character specific card of the character
	 * @return The card
	 */
	public abstract Card getCharacterCard();

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * Get the current position of the character.
	 * @return The current position
	 */
	public Position getCurrentPosition() {
		return this.currentPosition;
	}
	
	/**
	 * Set the current position of the character.
	 */
	public void setCurrentPosition(Position pos) {
		this.currentPosition = pos;
	}

	/** 
	 * Call this function to hash
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + cardNumber;
		result = prime * result
				+ ((currentPosition == null) ? 0 : currentPosition.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + level;
		return result;
	}

	/** 
	 * Call this functions to compare equal
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		/*
		if (cardNumber != other.cardNumber)
			return false;
		if (currentPosition == null) {
			if (other.currentPosition != null)
				return false;
		} else if (!currentPosition.equals(other.currentPosition))
			return false;
			*/
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		/*
		if (level != other.level)
			return false;
			*/
		return true;
	}
	
	
	
}
