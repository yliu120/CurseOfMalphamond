package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards;

import java.util.Arrays;
import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.AfterRollDiceCard;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.CardType;

/**
 * This is the Hunter class card Crippling Trap, but this is an extension feature that we are not implementing
 * right now.
 * @author Vincent Yan
 *
 */
public class CripplingTrap extends AfterRollDiceCard {

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
		return "Crippling Trap";
	}

	@Override
	public String getDescription() {
		return "[Trap]: Lose -2/3/4/5/6 defense";
	}

	@Override
	public void play(CurseOfMalphamondModelImpl model, int choice) {
		//TODO
	}

	@Override
	public List<Player> getTargetScope(CurseOfMalphamondModel model) {
		return (List<Player>) Arrays.asList(model.getCurrentActivePlayer());
	}
	
	@Override
	public void notifyListener(ModelListener listener, CurseOfMalphamondModelImpl model) {		
		//TODO	
	}

}
