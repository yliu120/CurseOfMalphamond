package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;
import java.io.IOException;
import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.Tile;

/**
 * Command to update the current 
 * @author Vincent Yan
 *
 */
public class UpdateCurrentTileCommand implements Command {
	
	private String commandName;
	private Tile currentTile;
	
	/**
	 * Default Constructor
	 */
	public UpdateCurrentTileCommand() {
	}
	
	/**
	 * Constructor for setting up players for modelProxy
	 */
	public UpdateCurrentTileCommand(Tile tile) { 
		this.currentTile = tile;
	}

	@Override
	public void execute(CurseOfMalphamondModel model) throws IOException,
			InterruptedException {
		
		if ( model instanceof CurseOfMalphamondModelProxy ) {
			((CurseOfMalphamondModelProxy) model).setCurrentTile(this.currentTile);
		}
	}
	
	/**
	 * setter for commandName
	 * @param commandName
	 */
	public void setCommandName( String commandName ) {
		this.commandName = commandName;
	}
	
	/**
	 * Getter for commandName
	 * @return
	 */
	public String getCommandName () {
		return this.commandName;
	}

}
