package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards;

import java.util.Arrays;
import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.RestoreNumHealthAction;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.DuringTurnCard;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.CardType;

/**
 * This is the Priest character card which allows the player to:
 * Restore 12/14/16/18/20 health, depending on the character's level.
 * @author Vincent Yan
 *
 */
public class Prayer extends DuringTurnCard {

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
		return "Prayer";
	}

	@Override
	public String getDescription() {
		return "Restore 12/14/16/18/20 health.";
	}

	@Override
	public void play(CurseOfMalphamondModelImpl model, int choice) {
		Player target = model.getCurrentActivePlayer();
		(new RestoreNumHealthAction(10 + 2 * target.getCharacter().getLevel(), target)).act();
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
