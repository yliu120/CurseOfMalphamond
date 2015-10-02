/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import java.io.IOException;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;

/**
 * Command to roll dice
 * @author andyyang
 *
 */
public class RollDiceCommand implements Command {

	/**
	 * Default constructor
	 */
	public RollDiceCommand() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.Command#execute(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelInterface)
	 */
	@Override
	public void execute(CurseOfMalphamondModel model)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		try {
			if ( model instanceof CurseOfMalphamondModelImpl ) {
				model.rollDice();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
