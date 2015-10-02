package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards;

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
 * This is the Grand Retreat level 2 basic card which allows the player to:
 * Move backward 2 tiles.
 * @author Vincent Yan
 *
 */
public class GrandRetreat extends DuringTurnCard {

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
		return "Grand Retreat";
	}

	@Override
	public String getDescription() {
		return " moves backward 2 tiles!\n";
	}

	@Override
	public void play(CurseOfMalphamondModelImpl model, int choice) {
		(new MoveNumTilesAction(-2, model.getCurrentActivePlayer())).act();
	}

	@Override
	public List<Player> getTargetScope(CurseOfMalphamondModel model) {
		return (List<Player>) Arrays.asList(model.getCurrentActivePlayer());
	}
	
	/** (non-Javadoc)
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card#notifyListener(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener, CurseOfMalphamondModelImpl)
	 */
	@Override
	public void notifyListener(ModelListener listener, CurseOfMalphamondModelImpl model) {
		
		listener.characterChanged(model.getCurrentActivePlayer().getCharacter(), model.getCurrentActivePlayer().getUsername(), model.getCurrentActivePlayer().getUsername() + this.getDescription());
		//listener.characterChanged(model.getCurrentActivePlayer().getCharacter(), model.getCurrentActivePlayer().getUsername(), null);
		listener.currentTileChanged();
	}

}
