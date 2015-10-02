/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.CardContainer;

/**
 * This is the interface of all the Card's types
 * @author Vincent Yan
 * @version 1.0
 */
public interface CardType {
	
	public static final CardType BASIC_CARD = BasicCard.SINGLETON;
	public static final CardType CHARACTER_CARD = CharacterCard.SINGLETON;
	public static final CardType MONSTER_CARD = MonsterCard.SINGLETON;
	public static final CardType RESOURCE_CARD = ResourceCard.SINGLETON;
	public static final CardType EXTRA_CARD = ExtraCard.SINGLETON;
	
	/**
	 * Determines where this type of card is added to when discarded from player's hand.
	 * @param model The model
	 * @return The place to add the card to, or null if the card isn't added anywhere
	 */
	public CardContainer whereToDiscard(CurseOfMalphamondModelImpl model);
}
