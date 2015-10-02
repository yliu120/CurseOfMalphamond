/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards.Nightmare;

/**
 * This class extends the character class and provides an implementation
 * of the Character Demon in the game.
 * @author Home
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterDemon
 */
public class CharacterDemon extends Character{

	/**
	 * Default Constructor
	 */
	public CharacterDemon() {
		super(19, 4, 3, "Demon", "Once every 2 turns, you can discard a card to draw another card once (no function yet)");
	}

	@Override
	public Card getCharacterCard() {
		return new Nightmare();
	}

}
