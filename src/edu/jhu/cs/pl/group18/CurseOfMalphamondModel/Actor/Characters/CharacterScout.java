/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards.Sprint;

/**
 * This class extends the character class and provides an implementation
 * of the Character Scout in the game.
 * @author Home
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterScout
 */
public class CharacterScout extends Character{
	
	/**
	 * Default Constructor
	 */
	public CharacterScout() {
		super(22, 3, 4, "Scout", "Move one extra tile each turn (no function yet)");
	}

	@Override
	public Card getCharacterCard() {
		return new Sprint();
	}

}