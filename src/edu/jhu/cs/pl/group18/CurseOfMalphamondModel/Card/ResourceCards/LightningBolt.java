package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.ResourceCards;

import java.util.Arrays;
import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.DealNumDamageToActorAction;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.DuringTurnCard;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.CardType;

/**
 * This is the Lightning Bolt resource card which allows the player to:
 * Deal 20 damage to a random player.
 * @author Vincent Yan
 *
 */
public class LightningBolt extends DuringTurnCard {

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
		return "Lightning Bolt";
	}

	@Override
	public String getDescription() {
		return "Deal 20 damage to a random player.";
	}

	@Override
	public void play(CurseOfMalphamondModelImpl model, int choice) {
		List<Player> players = model.getPlayers();
		int random = (int) Math.random() * players.size();
		model.setChoice(random);
		(new DealNumDamageToActorAction(20, players.get(random).getCharacter())).act();
	}

	@Override
	public List<Player> getTargetScope(CurseOfMalphamondModel model) {
		return (List<Player>) Arrays.asList(model.getCurrentActivePlayer());
	}

	@Override
	public void notifyListener(ModelListener listener, CurseOfMalphamondModelImpl model) {
		Player player = model.getPlayers().get(model.getChoice());
		listener.characterChanged(player.getCharacter(), player.getUsername(), player.getUsername() + this.getDescription());
	}

}
