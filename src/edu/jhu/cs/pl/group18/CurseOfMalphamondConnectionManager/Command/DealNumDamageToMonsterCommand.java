package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Position;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.MonsterTile;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.Tile;

/**
 * This class specifies a command that causes damage to the monster.
 * @author Yunlong
 * @version 1.2
 * @since 1.2
 */
public class DealNumDamageToMonsterCommand implements Command {

	private int num;
	
	/**
	 * The command to deal (10 + 2 * character level) damage to a monster
	 */
	public DealNumDamageToMonsterCommand() {
		super();
		this.num = -1;
	}

	/**
	 * The command to deal a number of damage to a monster
	 * @param num The number of damage
	 */
	public DealNumDamageToMonsterCommand(int num) {
		super();
		this.num = num;
	}
	
	
	/** 
	 * Override method.
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.Command#execute(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel)
	 */
	public void execute(CurseOfMalphamondModel model) {
		
		if (this. num == -1) {
			this.num = 10 + ((CurseOfMalphamondModelImpl) model).getCurrentActivePlayer().getCharacter().getLevel() * 2;
		}
		Position currentPos = ((CurseOfMalphamondModelImpl) model).getCurrentActivePlayer()
				.getCharacter().getCurrentPosition();
		Tile currentTile = ((CurseOfMalphamondModelImpl) model).getBoard().get(currentPos);
		
		if ( currentTile instanceof MonsterTile ) {
			int health = ((MonsterTile) currentTile).getMonster().getHealth();
			((MonsterTile) currentTile).getMonster().setHealth( health - this.num );
		}

	}

	
}
