package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards;

import java.util.Arrays;
import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.DrawNumCardAction;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.DuringTurnCard;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.CardType;

/**
 * This is the Philosopher character card which allows the player to:
 * Draw 2 cards.
 * @author Vincent Yan
 *
 */
public class Meditate extends DuringTurnCard {

	@Override
	public CardType getCardType() {
		return CardType.CHARACTER_CARD;
	}

	@Override
	public int getLevel() {
		return 1;
	}

	@Override
	public String getName() {
		return "Meditate";
	}

	@Override
	public String getDescription() {
		return "Draw 2 cards.";
	}

	@Override
	public void play(CurseOfMalphamondModelImpl model, int choice) {
		(new DrawNumCardAction(2, model.getCurrentActivePlayer())).act();
	}

	@Override
	public List<Player> getTargetScope(CurseOfMalphamondModel model) {
		return (List<Player>) Arrays.asList(model.getCurrentActivePlayer());
	}
	
	@Override
	public void notifyListener(ModelListener listener, CurseOfMalphamondModelImpl model) {		
			
	}

}
