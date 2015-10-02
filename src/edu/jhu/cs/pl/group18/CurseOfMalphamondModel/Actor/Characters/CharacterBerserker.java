/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards.SeismicSlam;

/**
 * This class extends the character class and provides an implementation
 * of the Character Berserker in the game.
 * @author Home
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterBerserker
 */
public class CharacterBerserker extends Character{

	/**
	 * Default Constructor
	 */
	public CharacterBerserker() {
		super(20, 5, 3, "Berserker", "+1 extra attack at level 1/3/5");
	}

	/**
	 *  +1 attack at level 1/3/5
	 */
	@Override
	public void levelUp() {
		super.levelUp();
		if (this.getLevel() % 2 == 1) {
			this.setAttack(this.getAttack() + 1);
		}
	}

	@Override
	public Card getCharacterCard() {
		return new SeismicSlam();
	}
}