/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import java.io.IOException;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;

/**
 * Command to add player
 * @author Yunlong
 *
 */
public class AddPlayerCommand implements Command {
	
	private Player playerAdded;
	
	/**
	 * Default Constructor
	 */
	public AddPlayerCommand() {
	}
	
	/**
	 * Constructor with a playerAdded parameter.
	 * @param playerAdded the player added
	 */
	public AddPlayerCommand(Player playerAdded) {
		super();
		this.playerAdded = playerAdded;
	}

	/* (non-Javadoc)
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.Command#execute(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel)
	 */
	@Override
	public void execute(CurseOfMalphamondModel model) throws IOException,
			InterruptedException {
		
		if ( model instanceof CurseOfMalphamondModelProxy ) {
			((CurseOfMalphamondModelProxy) model).addPlayer(this.playerAdded);
		}

	}

}
