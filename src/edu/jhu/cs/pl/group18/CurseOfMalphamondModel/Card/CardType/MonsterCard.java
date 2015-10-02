package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.CardContainer;


/**
 * This is the Monster Card type, which is obtained by a player by killing a monster.
 * @author Vincent Yan
 *
 */
public class MonsterCard implements CardType {

	public static final MonsterCard SINGLETON = new MonsterCard();
	
	/**
	 * Private constructor
	 */
	private MonsterCard() {
	
	}
	
	@Override
	public CardContainer whereToDiscard(CurseOfMalphamondModelImpl model) {
		return null;
	}

}
