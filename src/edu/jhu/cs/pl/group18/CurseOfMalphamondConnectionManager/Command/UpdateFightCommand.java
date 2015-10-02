package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import java.io.IOException;
import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;

/**
 * Command to updateFight
 * @author Vincent Yan
 *
 */
public class UpdateFightCommand implements Command {
	
	private String commandName;
	private String result;
	
	/**
	 * Default Constructor
	 */
	public UpdateFightCommand() {
	}
	
	/**
	 * Constructor for setting up players for modelProxy
	 * @param result the result og this fighting
	 */
	public UpdateFightCommand(String result) { 
		this.result = result;
	}

	@Override
	public void execute(CurseOfMalphamondModel model) throws IOException,
			InterruptedException {
		
		if ( model instanceof CurseOfMalphamondModelProxy ) {
			((CurseOfMalphamondModelProxy) model).setFightResult(this.result);
		}
	}
	
	/**
	 * sets the command name
	 * @param commandName the name
	 */
	public void setCommandName( String commandName ) {
		this.commandName = commandName;
	}
	
	/**
	 * getter for command name
	 * @return the anme
	 */
	public String getCommandName () {
		return this.commandName;
	}

}
