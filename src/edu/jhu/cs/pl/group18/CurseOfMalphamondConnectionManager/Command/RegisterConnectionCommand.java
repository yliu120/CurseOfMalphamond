/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;

/**
 * Command to register a connection
 * @author Yunlong
 *
 */
public class RegisterConnectionCommand implements Command {
	
	private Player player;
	
	/**
	 * Default constructor
	 */
	public RegisterConnectionCommand() {
	}
	
	/**
	 * The constructor that params player
	 * @param player the player
	 */
	public RegisterConnectionCommand( Player player ) {
		this.player = player;
	}
	/** (non-Javadoc)
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.Command#execute(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel)
	 */
	@Override
	public void execute(CurseOfMalphamondModel model) {
		
		model.addPlayer(player);

	}
	
	public Player getPlayer() {
		return this.player;
	}

}
