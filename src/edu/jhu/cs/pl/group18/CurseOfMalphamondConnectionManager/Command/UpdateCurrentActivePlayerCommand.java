/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import java.io.IOException;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;

/**
 * This command object is for updating the current active player.
 * @author Yunlong
 * @version 1.5
 * @since 1.5
 */
public class UpdateCurrentActivePlayerCommand implements Command {
	
	private Player player;

	/**
	 * Default constructor for serialization
	 */
	public UpdateCurrentActivePlayerCommand() {
	}
	
	/**
	 * Constructor with a player input.
	 */
	public UpdateCurrentActivePlayerCommand(Player player) {
		super();
		this.player = player;
	}

	/* (non-Javadoc)
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.Command#execute(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel)
	 */
	@Override
	public void execute(CurseOfMalphamondModel model) throws IOException,
			InterruptedException {
		
		if ( model instanceof CurseOfMalphamondModelProxy ) {
			((CurseOfMalphamondModelProxy) model).setCurrentActivePlayer(player);
		}

	}

}
