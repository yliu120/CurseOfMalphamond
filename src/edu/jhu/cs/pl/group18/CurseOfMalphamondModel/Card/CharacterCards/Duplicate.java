package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards;

import java.util.Arrays;
import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.MageDuplicateAction;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.DuringTurnCard;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.CardType;

/**
 * This is the Mage character card which allows the player to:
 * Copy a card from your hand into your hand.
 * @author Vincent Yan
 *
 */
public class Duplicate extends DuringTurnCard {

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
		return "Duplicate";
	}

	@Override
	public String getDescription() {
		return "Copy a card from your hand into your hand.";
	}

	@Override
	public void play(CurseOfMalphamondModelImpl model, int choice) {
		(new MageDuplicateAction(model, choice)).act( );
	}

	@Override
	public List<Player> getTargetScope(CurseOfMalphamondModel model) {
		//TODO improve
		return (List<Player>) Arrays.asList(model.getCurrentActivePlayer());
	}
	
	@Override
	public void notifyListener(ModelListener listener, CurseOfMalphamondModelImpl model) {		

	}

}
