package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import java.io.IOException;
import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;

/**
 * Command to updateDice
 * @author Vincent Yan
 *
 */
public class UpdateDiceCommand implements Command {
	
	private String commandName;
	private int diceNum;
	
	/**
	 * Default Constructor
	 */
	public UpdateDiceCommand() {
	}
	
	/**
	 * Constructor for setting up players for modelProxy
	 * @param diceNum the dice number model Impl would like to set
	 */
	public UpdateDiceCommand(int diceNum) { 
		this.diceNum = diceNum;
	}

	@Override
	public void execute(CurseOfMalphamondModel model) throws IOException,
			InterruptedException {
		
		if ( model instanceof CurseOfMalphamondModelProxy ) {
			((CurseOfMalphamondModelProxy) model).setDiceNumber(this.diceNum);
		}

	}
	
	/**
	 * setter for Commandname
	 */
	public void setCommandName( String commandName ) {
		this.commandName = commandName;
	}
	
	/**
	 * getter for Commandname
	 * @return
	 */
	public String getCommandName () {
		return this.commandName;
	}

}
