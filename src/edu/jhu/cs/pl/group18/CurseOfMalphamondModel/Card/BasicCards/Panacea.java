package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards;

import java.util.Arrays;
import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.GainNumMaxHealthAction;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.DuringTurnCard;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.CardType;

/**
 * This is the Panacea level 2 basic card which allows the player to:
 * Gain +5 max health.
 * @author Vincent Yan
 *
 */
public class Panacea extends DuringTurnCard {

	@Override
	public CardType getCardType() {
		return CardType.BASIC_CARD;
	}

	@Override
	public int getLevel() {
		return 2;
	}

	@Override
	public String getName() {
		return "Panacea";
	}

	@Override
	public String getDescription() {
		return " gains +5 max health!\n";
	}

	@Override
	public void play(CurseOfMalphamondModelImpl model, int choice) {
		(new GainNumMaxHealthAction(5, model.getCurrentActivePlayer())).act();
	}

	@Override
	public List<Player> getTargetScope(CurseOfMalphamondModel model) {
		return (List<Player>) Arrays.asList(model.getCurrentActivePlayer());
	}
	
	@Override
	public void notifyListener(ModelListener listener, CurseOfMalphamondModelImpl model) {
		Player player = model.getCurrentActivePlayer();
		listener.characterChanged(player.getCharacter(), player.getUsername(), player.getUsername() + this.getDescription());
	}

}
