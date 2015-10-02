/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import java.io.IOException;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;

/**
 * THe command to start a fight
 * @author andyyang
 *
 */
public class FightCommand implements Command {

	/**
	 * default constructor
	 */
	public FightCommand() {
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
				model.fight();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
