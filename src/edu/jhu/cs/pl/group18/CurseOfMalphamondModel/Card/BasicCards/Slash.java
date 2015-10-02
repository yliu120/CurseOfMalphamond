package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards;

import java.util.Arrays;
import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.DealNumDamageToActorAction;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BeforeBattleCard;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.CardType;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.MonsterTile;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.Tile;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.TileType;

/**
 * This is the Slash level 1 basic card which allows the player to:
 * Deal 10 damage to a monster.
 * @author Vincent Yan
 *
 */
public class Slash extends BeforeBattleCard {

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
		return "Slash";
	}

	@Override
	public String getDescription() {
		return " deals 10 damage to a monster!\n";
	}

	@Override
	public void play(CurseOfMalphamondModelImpl model, int choice) {
		
		Tile tile = ((CurseOfMalphamondModelImpl) model).getBoard().get(model.getCurrentActivePlayer().getCharacter().getCurrentPosition());
		if ( tile instanceof MonsterTile ){
			(new DealNumDamageToActorAction(10, ((MonsterTile) tile).getMonster())).act();
		}
		
	}

	@Override
	public List<Player> getTargetScope(CurseOfMalphamondModel model) {
		return (List<Player>) Arrays.asList(model.getCurrentActivePlayer());
	}

	@Override
	public void notifyListener(ModelListener listener, CurseOfMalphamondModelImpl model) {
		
		if (model.getCurrentTile().getTileType().equals(TileType.MonsterTile)) {
			listener.monsterAttacked(model.getCurrentActivePlayer().getUsername() + " deals 10 damage to "
					+ ((MonsterTile) model.getCurrentTile()).getMonster().getName() + ".");
		}	
	}
}
