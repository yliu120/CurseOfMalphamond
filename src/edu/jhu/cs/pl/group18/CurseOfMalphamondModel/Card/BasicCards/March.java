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
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.MoveNumTilesAction;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.DuringTurnCard;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.CardType;


/**
 * This is the March level 1 basic card which allows the player to:
 * Move forward 1 tile.
 * @author Vincent Yan
 *
 */
public class March extends DuringTurnCard {

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
		return "March";
	}

	@Override
	public String getDescription() {
		return " moves forward 1 tile!\n";
	}
	
	@Override
	public void play(CurseOfMalphamondModelImpl model, int choice) {
		(new MoveNumTilesAction(1, model.getCurrentActivePlayer())).act();
	}

	@Override
	public List<Player> getTargetScope(CurseOfMalphamondModel model) {
		return (List<Player>) Arrays.asList(model.getCurrentActivePlayer());
	}
	
	@Override
	public void notifyListener(ModelListener listener, CurseOfMalphamondModelImpl model) {
		listener.characterChanged(model.getCurrentActivePlayer().getCharacter(), model.getCurrentActivePlayer().getUsername(), model.getCurrentActivePlayer().getUsername() + this.getDescription());
		//listener.characterChanged(model.getCurrentActivePlayer().getCharacter(), model.getCurrentActivePlayer().getUsername(), null);
		listener.currentTileChanged();
	}

}
