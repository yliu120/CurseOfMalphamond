/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Dice;

/**
 * The action to roll the dice
 * @author Yunlong
 *
 */
public class RollDiceAction implements Action {

	private CurseOfMalphamondModel model;
	
	/**
	 * Constructor
	 * @param model The model
	 */
	public RollDiceAction( CurseOfMalphamondModel model ) {
		this.model = model;
	}

	@Override
	public void act() {
		Dice dice = this.model.getDice();
		dice.rollDice();
		this.model.setDiceNumber(dice.getDiceNumber());
	}
}
