package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.ResourceCards;

import java.util.Arrays;
import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.GainNumAttackAction;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.GainNumDefenseAction;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.DuringTurnCard;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.CardType;

/**
 * This is the Physical Training resource card which allows the player to:
 * Gain +1 attack, +1 health.
 * @author Vincent Yan
 *
 */
public class PhysicalTraining extends DuringTurnCard {

	@Override
	public CardType getCardType() {
		return CardType.RESOURCE_CARD;
	}

	@Override
	public int getLevel() {
		return 1;
	}

	@Override
	public String getName() {
		return "Physical Training";
	}

	@Override
	public String getDescription() {
		return "Gain +1 attack, +1 health.";
	}

	@Override
	public void play(CurseOfMalphamondModelImpl model, int choice) {
		Player target = model.getCurrentActivePlayer();
		(new GainNumAttackAction(1, target)).act();
		(new GainNumDefenseAction(1, target)).act( );
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
