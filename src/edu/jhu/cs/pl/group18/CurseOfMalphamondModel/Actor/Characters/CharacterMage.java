/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards.Duplicate;

/**
 * This class extends the character class and provides an implementation
 * of the Character Mage in the game.
 * @author Home
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterMage
 */
public class CharacterMage extends Character{

	
	/**
	 * Default Constructor
	 */
	public CharacterMage() {
		super(24, 4, 4, "Mage", "If you play 4 card in a turn, draw an additional card (no function yet)");
	}

	@Override
	public Card getCharacterCard() {
		return new Duplicate();
	}

}