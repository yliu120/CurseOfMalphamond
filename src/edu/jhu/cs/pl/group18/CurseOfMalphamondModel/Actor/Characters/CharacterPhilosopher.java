/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards.Meditate;

/**
 * This class extends the character class and provides an implementation
 * of the Character Philosopher in the game.
 * @author Home
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterPhilosopher
 */
public class CharacterPhilosopher extends Character{

	
	/**
	 * Default Constructor
	 */
	public CharacterPhilosopher() {
		super(20, 3, 3, "Philosopher", "+1 starting hand, +1 maximum hand size (no function yet)");
	}

	@Override
	public Card getCharacterCard() {
		return new Meditate();
	}

}