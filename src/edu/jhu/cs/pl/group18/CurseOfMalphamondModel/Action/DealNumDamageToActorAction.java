/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Actor;

/**
 * The action to deal a number of damage to an actor
 * @author Yunlong
 *
 */
public class DealNumDamageToActorAction implements Action {

	private final Actor actor;
	private final int num;
	/**
	 * Constructor
	 * @param num The number of damage
	 * @param actor The target actor
	 */
	public DealNumDamageToActorAction( int num, Actor actor ) {
		this.actor = actor;
		this.num = num;
	}

	/**
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.Action#act()
	 */
	@Override
	public void act() {
		actor.setHealth( actor.getHealth() - this.num );
	}

}
