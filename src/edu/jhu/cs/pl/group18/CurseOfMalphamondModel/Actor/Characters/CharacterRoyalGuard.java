/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards.ShieldToss;

/**
 * This class extends the character class and provides an implementation
 * of the Character Royal Guard in the game.
 * @author Home
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterRoyalGuard
 */
public class CharacterRoyalGuard extends Character{
	
	
	/**
	 * Default Constructor
	 */
	public CharacterRoyalGuard() {
		super(22, 3, 4, "RoyalGuard", "+1 extra defense at level 1/3/5");
	}

	/**
	 *  +1 defense at level 1/3/5
	 */
	@Override
	public void levelUp() {
		super.levelUp();
		if (this.getLevel() % 2 == 1) {
			this.setDefense(this.getDefense() + 1);
		}
	}

	@Override
	public Card getCharacterCard() {
		return new ShieldToss();
	}

}