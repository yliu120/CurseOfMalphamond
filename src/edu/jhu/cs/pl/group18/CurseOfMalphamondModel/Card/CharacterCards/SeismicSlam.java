package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards;

import java.util.Arrays;
import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.InvalidTileTypeException;
import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.NoMonsterOnTileException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.DealNumDamageToActorAction;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BeforeBattleCard;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.CardType;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.MonsterTile;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.Tile;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.TileType;

/**
 * This is the Berserker character card which allows the player to:
 * Deal 12/14/16/18/20 damage to a monster, depending on the character's level.
 * @author Vincent Yan
 *
 */
public class SeismicSlam extends BeforeBattleCard {

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
		return "Seismic Slam";
	}

	@Override
	public String getDescription() {
		return "Deal 12/14/16/18/20 damage to a monster.";
	}

	@Override
	public void play(CurseOfMalphamondModelImpl model, int choice) {
		Tile tile = ((CurseOfMalphamondModelImpl) model).getBoard().get(model.getCurrentActivePlayer().getCharacter().getCurrentPosition());
		if ( tile instanceof MonsterTile ){
			(new DealNumDamageToActorAction(10 + 2 * model.getCurrentActivePlayer().getCharacter().getLevel(), ((MonsterTile) tile).getMonster())).act();
		} else {
			try {
				throw new NoMonsterOnTileException();
			} catch (NoMonsterOnTileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Player> getTargetScope(CurseOfMalphamondModel model) {
		return (List<Player>) Arrays.asList(model.getCurrentActivePlayer());
	}

	@Override
	public void notifyListener(ModelListener listener, CurseOfMalphamondModelImpl model) {
		if (model.getCurrentTile().getTileType().equals(TileType.MonsterTile)) {
			listener.monsterAttacked(model.getCurrentActivePlayer().getUsername() + " deals " + 
					(10 + 2 * model.getCurrentActivePlayer().getCharacter().getLevel()) + " damage to "
					+ ((MonsterTile) model.getCurrentTile()).getMonster().getName() + ".");
		} else {
			try {
				throw new InvalidTileTypeException();
			} catch (InvalidTileTypeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
