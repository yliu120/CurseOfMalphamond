package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.ResourceCards;

import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.MoveNumTilesAction;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.DuringTurnCard;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.CardType;

/**
 * This is the Deceive resource card which allows the player to:
 * An opponent moves backward 5 tiles.
 * @author Vincent Yan
 *
 */
public class Deceive extends DuringTurnCard {

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
		return "Deceive";
	}

	@Override
	public String getDescription() {
		return " makes an opponent move backward 5 tiles!\n";
	}

	@Override
	public void play(CurseOfMalphamondModelImpl model, int choice) {
		List<Player> players = model.getPlayers();
		players.remove(model.getCurrentActivePlayer());
		(new MoveNumTilesAction(-5, players.get(choice))).act();
	}

	@Override
	public List<Player> getTargetScope(CurseOfMalphamondModel model) {
		List<Player> players = model.getPlayers();
		players.remove(model.getCurrentActivePlayer());
		return players;
	}

	@Override
	public void notifyListener(ModelListener listener, CurseOfMalphamondModelImpl model) {
		Player player = model.getPlayers().get(model.getChoice());
		listener.characterChanged(player.getCharacter(), player.getUsername(), player.getUsername() + this.getDescription());
	}

}
