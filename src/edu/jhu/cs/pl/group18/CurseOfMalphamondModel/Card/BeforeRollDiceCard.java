/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.UseTimeType;

/**
 * This class represents all cards that can be played before rolling the dice.
 * @author Vincent Yan
 *
 */
public abstract class BeforeRollDiceCard implements Card {

	@Override
	public boolean canBeUsedNow(UseTimeType useTimeType) {
		return useTimeType == UseTimeType.BeforeRollDice;
	}
}
