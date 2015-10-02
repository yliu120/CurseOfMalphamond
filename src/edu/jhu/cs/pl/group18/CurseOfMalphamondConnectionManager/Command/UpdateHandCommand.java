/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import java.io.IOException;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.Hand;

/**
 * Command to update hand
 * @author andyyang0830
 *
 */
public class UpdateHandCommand implements Command {

	private String commandName;
	private String username;
	private Hand hand;
	
	/**
	 * Default Constructor
	 */
	public UpdateHandCommand() {
	}
	
	/**
	 * Constructor for setting up players for modelProxy
	 * @param username the username of the player
	 * @param hand the new hand
	 */
	public UpdateHandCommand(Hand hand, String username) { 
		this.hand = hand;
		this.username = username;
	}

	@Override
	public void execute(CurseOfMalphamondModel model) throws IOException,
			InterruptedException {
		
		if ( model instanceof CurseOfMalphamondModelProxy ) {
			((CurseOfMalphamondModelProxy) model).setLocalPlayerHand(this.hand, this.username);

		}

	}
	
	/**
	 * setter for the name
	 * @param commandName the name
	 */
	public void setCommandName( String commandName ) {
		this.commandName = commandName;
	}
	
	/**
	 * getter for the name
	 * @return the name
	 */
	public String getCommandName () {
		return this.commandName;
	}

}
