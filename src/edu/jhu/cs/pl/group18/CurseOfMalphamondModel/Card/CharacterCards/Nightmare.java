package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards;

import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.DiscardRandomCardAction;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.DuringTurnCard;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.CardType;

/**
 * This is the Demon character card which allows the player to:
 * Discard a random card from an opponent's hand.
 * @author Vincent Yan
 *
 */
public class Nightmare extends DuringTurnCard {

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
		return "Nightmare";
	}

	@Override
	public String getDescription() {
		return "Discard a random card from an opponent's hand.";
	}

	@Override
	public void play(CurseOfMalphamondModelImpl model, int choice) {
		List<Player> players = model.getPlayers();
		players.remove(model.getCurrentActivePlayer());
		(new DiscardRandomCardAction(players.get(choice), model)).act();
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
		listener.handChanged(player.getHand(), player.getUsername());
	}

}
