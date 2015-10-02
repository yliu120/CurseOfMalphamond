/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards.CripplingTrap;

/**
 * @author Vincent Yan
 *
 */
public class CharacterHunter extends Character {

	/**
	 * Default Constructor
	 */
	public CharacterHunter() {
		super(22, 3, 4, "Hunter", "Whenever your trap activates, draw a card; Hunters bow grants +5 attack instead (no function yet)");
	}
	
	@Override
	public Card getCharacterCard() {
		return new CripplingTrap();
	}

}
