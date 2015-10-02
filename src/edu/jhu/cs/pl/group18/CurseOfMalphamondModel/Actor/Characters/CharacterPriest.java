/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards.Prayer;

/**
 * This class extends the character class and provides an implementation
 * of the Character Priest in the game.
 * @author Home
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterPriest
 */
public class CharacterPriest extends Character{

	
	/**
	 * Default Constructor
	 */
	public CharacterPriest() {
		super(20, 3, 4, "Priest", "+1 maximum health per level");
	}
	
	@Override
	public void levelUp() {
		super.levelUp();
		this.setMaxHealth(this.getMaxHealth()+1);
	}
	@Override
	public Card getCharacterCard() {
		return new Prayer();
	}

}