package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards;

import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.SkipTurnAction;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.DuringTurnCard;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.CardType;

/**
 * This is the Royal Guard character card which allows the player to:
 * Stun an opponent for 1 turn.
 * @author Vincent Yan
 *
 */
public class ShieldToss extends DuringTurnCard {

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
		return "Shield Toss";
	}

	@Override
	public String getDescription() {
		return "Stun an opponent for 1 turn.";
	}

	@Override
	public void play(CurseOfMalphamondModelImpl model, int choice) {
		List<Player> players = model.getPlayers();
		players.remove(model.getCurrentActivePlayer());
		(new SkipTurnAction(players.get(choice))).act();
	}

	@Override
	public List<Player> getTargetScope(CurseOfMalphamondModel model) {
		List<Player> players = model.getPlayers();
		players.remove(model.getCurrentActivePlayer());
		return players;
	}

	@Override
	public void notifyListener(ModelListener listener, CurseOfMalphamondModelImpl model) {
		// TODO Stun?
		
	}

}
