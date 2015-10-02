package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Position;

/**
 * This class creates the option tile. When a character steps on the tile, he can 
 * gain attack, defense or health. 
 * @author Yijie
 *
 */
public class OptionTile extends ActionTile {

	/**
	 * Default Constructor
	 */
	public OptionTile () {
	}
	
	/**
	 * Constructor
	 * @param position The position of the tile
	 */
	public OptionTile (Position position, String description) {
		super(position, description);
	}
	
	@Override
	public void act(CurseOfMalphamondModelImpl model) {
		model.randomOptionTileAct();
	}

}
