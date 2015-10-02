package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import java.io.IOException;
import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;

/**
 * Command to update the player
 * @author Vincent Yan
 *
 */
public class UpdatePlayersCommand implements Command {
	
	private List<Player> players;
	
	/**
	 * Default Constructor
	 */
	public UpdatePlayersCommand() {
	}
	
	/**
	 * Constructor for setting up players for modelProxy
	 * @param players the renewed player list
	 */
	public UpdatePlayersCommand( List<Player> players ) { 
		this.players = players;
	}

	@Override
	public void execute(CurseOfMalphamondModel model) throws IOException,
			InterruptedException {
		
		if ( model instanceof CurseOfMalphamondModelProxy ) {
			((CurseOfMalphamondModelProxy) model).setPlayers(this.players);
		}

	}

}
