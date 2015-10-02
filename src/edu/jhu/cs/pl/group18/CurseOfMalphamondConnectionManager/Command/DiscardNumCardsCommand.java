package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;

/**
 * The command to discard a number of cards
 * @author Vincent Yan
 *
 */
public class DiscardNumCardsCommand implements Command {

	private int num;
	/**
	 * The constructor
	 * @param num the number of cards
	 */
	public DiscardNumCardsCommand(int num) {
		this.num = num;
	}

	@Override
	public void execute(CurseOfMalphamondModel model) {
		// TODO Auto-generated method stub

	}

}
