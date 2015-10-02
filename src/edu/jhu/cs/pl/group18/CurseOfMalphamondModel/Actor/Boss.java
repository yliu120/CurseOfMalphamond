/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor;

/**
 * This class extends the Actor abstract class and provides an implementation
 * of the Boss in the game.
 * @author Home
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Actor
 */
public class Boss extends Actor {
	
	/**
	 * Constructor
	 */
	public Boss() {
		super(20, 10, 10, "Malphamond");
	}

	/**
	 * Override the abstract class method attack().
	 */
	@Override
	public String attack(Actor target) {
		return super.attack(target);
		// TODO special abilities of boss
	}

	/**
	 * Override the abstract class method isDead().
	 */
	@Override
	public boolean isDead() {
		// TODO special abilities of boss
		return super.isDead();
	}

}
