package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import java.io.IOException;
import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;

/**
 * Command to update the character
 * @author Vincent Yan
 *
 */
public class UpdateCharacterCommand implements Command {
	
	private String commandName;
	private Character character;
	private String username;
	private String result;
	
	/**
	 * Default Constructor
	 */
	public UpdateCharacterCommand() {
	}
	
	/**
	 * Constructor for setting up players for modelProxy
	 * @param username the username of the player
	 * @param result the final result of the character
	 */
	public UpdateCharacterCommand(Character character, String username, String result) { 
		this.character = character;
		this.username = username;
		this.result = result;
	}

	@Override
	public void execute(CurseOfMalphamondModel model) throws IOException,
			InterruptedException {
		
		if ( model instanceof CurseOfMalphamondModelProxy ) {
			((CurseOfMalphamondModelProxy) model).setPlayerCharacter(this.character, this.username, this.result);
		}

	}
	
	/**
	 * Setter for commandName
	 * @param commandName the name
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
