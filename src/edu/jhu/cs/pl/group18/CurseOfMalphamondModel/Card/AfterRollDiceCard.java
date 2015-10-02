/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.UseTimeType;

/**
 * This class represents all cards that can be played after rolling the dice.
 * @author Home
 *
 */
public abstract class AfterRollDiceCard implements Card {

	@Override
	public boolean canBeUsedNow(UseTimeType useTimeType) {
		return useTimeType == UseTimeType.AfterRollDice;
	}
	
}
