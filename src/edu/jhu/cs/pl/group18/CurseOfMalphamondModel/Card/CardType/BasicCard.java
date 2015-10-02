package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.CardContainer;

/**
 * This is the Basic Card type, which composes part of the deck of all characters.
 * @author Vincent Yan
 *
 */
public class BasicCard implements CardType {

	public static final BasicCard SINGLETON = new BasicCard();
	
	/**
	 * Private constructor
	 */
	private BasicCard() {
	
	}

	@Override
	public CardContainer whereToDiscard(CurseOfMalphamondModelImpl model) {
		return model.getCurrentActivePlayer().getUsedCards();
	}

}
