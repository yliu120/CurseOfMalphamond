/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.UseTimeType;


/**
 * This class represents all cards that can be played during the player's turn
 * @author Vincent Yan
 *
 */
public abstract class DuringTurnCard implements Card {

	@Override
	public boolean canBeUsedNow(UseTimeType useTimeType) {
		return useTimeType == UseTimeType.BeforeRollDice || useTimeType == UseTimeType.AfterRollDice;
	}

}
