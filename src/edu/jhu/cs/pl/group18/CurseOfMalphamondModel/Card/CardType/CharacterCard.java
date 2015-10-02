/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.CardContainer;

/**
 * This is the Character Card type, which composes part of the deck of its specific character.
 * @author Vincent Yan
 *
 */
public class CharacterCard implements CardType {

	public static final CharacterCard SINGLETON = new CharacterCard();
	
	/**
	 * Private constructor
	 */
	private CharacterCard() {
	
	}
	
	@Override
	public CardContainer whereToDiscard(CurseOfMalphamondModelImpl model) {
		return model.getCurrentActivePlayer().getUsedCards();
	}

}
