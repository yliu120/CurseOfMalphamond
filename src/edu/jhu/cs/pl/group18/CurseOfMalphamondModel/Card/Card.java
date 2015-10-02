package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card;

import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.UseTimeType;
/**
 * 
 */
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.CardType;

/**
 * This is the interface of a card
 * @author Vincent Yan
 * @version 1.0
 */

public interface Card {
	/**
	 * Get the card type of the card
	 * @return The card type
	 */
	public CardType getCardType();
	
	/**
	 * Tell if the card can be used in the current useTimeType
	 * @param useTimeType The useTimeType the model currently is in
	 * @return True if the card can be used, false otherwise
	 */
	public boolean canBeUsedNow(UseTimeType useTimeType);
	
	/**
	 * Get the level of the card
	 * @return The level
	 */
	public int getLevel();
	
	/**
	 * Get the name of the card
	 */
	public String getName();
	
	/**
	 * Get the description of the card
	 */
	public String getDescription();
	
	/**
	 * Play the card
	 * @param model The model of the game
	 * @param choice The player's choice in the utility of the card
	 */
	public void play(CurseOfMalphamondModelImpl model, int choice);
	
	/**
	 * Get the target scope, i.e. the list of valid targets, of this card. The player him/herself is a target.
	 * @param model The model of the game
	 * @return The target scope
	 */
	public List<Player> getTargetScope(CurseOfMalphamondModel model);
	
	/**
	 * Notify a listener of the model after the card is played 
	 * @param listener The model listener
	 * @param model The model
	 */
	public void notifyListener( ModelListener listener, CurseOfMalphamondModelImpl model );
}
