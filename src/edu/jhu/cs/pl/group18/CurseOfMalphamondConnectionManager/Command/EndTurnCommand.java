package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import java.io.IOException;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.InvalidTimeException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;

/**
 * The command to end turn
 * @author Vincent Yan
 *
 */
public class EndTurnCommand implements Command {
	
	/**
	 * Default constructor for serialization
	 */
	public EndTurnCommand () {
		
	}

	@Override
	public void execute(CurseOfMalphamondModel model) throws IOException,
			InterruptedException {

		if (model instanceof CurseOfMalphamondModelImpl) {
			try {
				model.endTurn();
			} catch (InvalidTimeException e) {
				// TODO deal with this exception message.
				System.out.println(e.getMessage());
			}
		}
	}

}
