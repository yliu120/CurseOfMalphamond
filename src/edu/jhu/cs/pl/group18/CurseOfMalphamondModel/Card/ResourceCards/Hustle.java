package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.ResourceCards;

import java.util.Arrays;
import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.MoveNumTilesAction;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.DuringTurnCard;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.CardType;

/**
 * This is the Hustle resource card which allows the player to:
 * Move forward 4 tiles.
 * @author Vincent Yan
 *
 */
public class Hustle extends DuringTurnCard {

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
		return "Hustle";
	}

	@Override
	public String getDescription() {
		return " moves forward 4 tiles!\n";
	}

	@Override
	public void play(CurseOfMalphamondModelImpl model, int choice) {
		(new MoveNumTilesAction(4, model.getCurrentActivePlayer())).act();
	}

	@Override
	public List<Player> getTargetScope(CurseOfMalphamondModel model) {
		return (List<Player>) Arrays.asList(model.getCurrentActivePlayer());
	}

	@Override
	public void notifyListener(ModelListener listener, CurseOfMalphamondModelImpl model) {
		listener.characterChanged(model.getCurrentActivePlayer().getCharacter(), model.getCurrentActivePlayer().getUsername(), model.getCurrentActivePlayer().getUsername() + this.getDescription());
		//listener.characterChanged(model.getCurrentActivePlayer().getCharacter(), model.getCurrentActivePlayer().getUsername(), null);
	}

}
