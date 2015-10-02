package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.UseTimeType;

/**
 * This class represents all cards that can be played after move phase.
 * @author Vincent Yan
 *
 */
public abstract class AfterMoveCard implements Card {

	@Override
	public boolean canBeUsedNow(UseTimeType useTimeType) {
		return useTimeType == UseTimeType.AfterMove || useTimeType == UseTimeType.AfterBattle;
	}

}
