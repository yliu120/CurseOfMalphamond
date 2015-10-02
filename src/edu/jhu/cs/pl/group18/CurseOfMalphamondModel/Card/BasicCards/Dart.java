/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards;

import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.DealNumDamageToActorAction;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.DuringTurnCard;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.CardType;

/**
 * This is the Dart level 1 basic card which allows the player to:
 * Deal 6 damage to a character.
 * @author Vincent Yan
 *
 */
public class Dart extends DuringTurnCard {

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
		return "Boomerang";
	}

	@Override
	public String getDescription() {
		return "Deal 6 damage to a character.";
	}

	@Override
	public void play(CurseOfMalphamondModelImpl model, int choice) {
		List<Player> players = model.getPlayers();
		players.remove(model.getCurrentActivePlayer());
		(new DealNumDamageToActorAction(6, players.get(choice).getCharacter())).act();
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
