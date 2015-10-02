/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards;

import java.util.Arrays;
import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.RollDiceAction;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.AfterRollDiceCard;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.CardType;

/**
 * This is the Reroll level 1 basic card which allows the player to:
 * Reroll the dice.
 * @author Vincent Yan
 *
 */
public class Reroll extends AfterRollDiceCard {

	@Override
	public CardType getCardType() {
		return CardType.BASIC_CARD;
	}

	@Override
	public int getLevel() {
		return 1;
	}
	
	@Override
	public String getName() {
		return "Reroll";
	}

	@Override
	public String getDescription() {
		return "Reroll the dice.";
	}
	
	@Override
	public void play(CurseOfMalphamondModelImpl model, int choice) {
		//TODO need to cancel previous roll
		(new RollDiceAction( model )).act();
	}

	@Override
	public List<Player> getTargetScope(CurseOfMalphamondModel model) {
		return (List<Player>) Arrays.asList(model.getCurrentActivePlayer());
	}

	@Override
	public void notifyListener(ModelListener listener, CurseOfMalphamondModelImpl model) {
		
		listener.diceRolled();
		
	}

}
