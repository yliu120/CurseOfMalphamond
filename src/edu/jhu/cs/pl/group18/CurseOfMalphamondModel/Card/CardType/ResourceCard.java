package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.CardContainer;

/**
 * This is the Resource Card type, which composes the resource deck.
 * @author Vincent Yan
 *
 */
public class ResourceCard implements CardType {

	public static final ResourceCard SINGLETON = new ResourceCard();
	
	/**
	 * Private constructor
	 */
	private ResourceCard() {
	
	}
	
	@Override
	public CardContainer whereToDiscard(CurseOfMalphamondModelImpl model) {
		return model.getUsedResourceCards();
	}

}
