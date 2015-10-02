package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.CardContainer;

/**
 * This is the Extra Card type, which is obtained by a player under special conditions.
 * @author Vincent Yan
 *
 */
public class ExtraCard implements CardType {

	public static final ExtraCard SINGLETON = new ExtraCard();
	
	/**
	 * Private constructor
	 */
	private ExtraCard() {
	
	}
	
	@Override
	public CardContainer whereToDiscard(CurseOfMalphamondModelImpl model) {
		return null;
	}

}
