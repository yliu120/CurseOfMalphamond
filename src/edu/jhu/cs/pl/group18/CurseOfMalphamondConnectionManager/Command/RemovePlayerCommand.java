/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import java.io.IOException;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;

/**
 * Command to remove player
 * @author Yunlong
 *
 */
public class RemovePlayerCommand implements Command {

	private Player playerRemoved;

	/**
	 * Default Constructor
	 */
	public RemovePlayerCommand() {
	}

	/**
	 * Constructor with a playerAdded parameter.
	 * @param playerRemoved the player removed
	 */
	public RemovePlayerCommand(Player playerRemoved) {
		super();
		this.playerRemoved = playerRemoved;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.Command
	 * #execute
	 * (edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel)
	 */
	@Override
	public void execute(CurseOfMalphamondModel model) throws IOException,
			InterruptedException {

		if (model instanceof CurseOfMalphamondModelProxy) {
			((CurseOfMalphamondModelProxy) model).removePlayer(this.playerRemoved);
		}

	}

}
