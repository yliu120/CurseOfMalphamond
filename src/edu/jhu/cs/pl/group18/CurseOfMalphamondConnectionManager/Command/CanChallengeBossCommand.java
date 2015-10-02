package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import java.io.IOException;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;

/**
 * Command to allow challenge boss
 * @author Vincent Yan
 *
 */
public class CanChallengeBossCommand implements Command {
	
	private String commandName;
	private String result;

	/**
	 * Default Constructor
	 */
	public CanChallengeBossCommand() {
	}
	
	/**
	 * Constructor that params the result
	 * @param result
	 */
	public CanChallengeBossCommand(String result) {
		this.result = result;
	}

	@Override
	public void execute(CurseOfMalphamondModel model) throws IOException,
			InterruptedException {
		
		if ( model instanceof CurseOfMalphamondModelProxy ) {
			((CurseOfMalphamondModelProxy) model).canChallengeBoss(this.result);
		}

	}
	
	/**
	 * Sets the commandname
	 * @param commandName the name
	 */
	public void setCommandName( String commandName ) {
		this.commandName = commandName;
	}
	
	/**
	 * Getter for commandname
	 * @return the commandname
	 */
	public String getCommandName () {
		return this.commandName;
	}

}
