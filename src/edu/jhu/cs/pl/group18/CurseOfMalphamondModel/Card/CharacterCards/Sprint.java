package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards;

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
 * This is the Scout character card which allows the player to:
 * Move 2/2/3/4/5 tiles, depending on the character's level.
 * @author Vincent Yan
 *
 */
public class Sprint extends DuringTurnCard {

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
		return "Sprint";
	}

	@Override
	public String getDescription() {
		return " moves 2/2/3/4/5 tiles!\n";
	}

	@Override
	public void play(CurseOfMalphamondModelImpl model, int choice) {
		int numTiles = model.getCurrentActivePlayer().getCharacter().getLevel();
		if (numTiles == 1) numTiles = 2;
		(new MoveNumTilesAction(numTiles, model.getCurrentActivePlayer())).act();
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
