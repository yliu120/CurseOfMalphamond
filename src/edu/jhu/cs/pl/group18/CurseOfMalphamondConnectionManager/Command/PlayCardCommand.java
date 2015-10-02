/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import java.io.IOException;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;

/**
 * Call this command to let the model impl play a card
 * @author Yunlong
 *
 */
public class PlayCardCommand implements Command {

	/**
	 * 
	 */
	private int cardPos;
	private int choice;
	
	public PlayCardCommand() {
	}

	/**
	 * Constructor that should take a card as parameter
	 */
	public PlayCardCommand( int cardPos, int choice ) {
		this.cardPos = cardPos;
		this.choice = choice;
	}

	/**
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.Command#execute(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel)
	 */
	@Override
	public void execute(CurseOfMalphamondModel model) throws IOException, InterruptedException {
		
		try {
			if ( model instanceof CurseOfMalphamondModelImpl ) {
				try {
					model.playCard(this.cardPos, this.choice);
				} catch (CardNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
