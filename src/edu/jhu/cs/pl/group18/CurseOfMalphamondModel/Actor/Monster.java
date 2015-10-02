/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;


/**
 * This class extends the Actor abstract class and provides an implementation
 * of the Monster in the game.
 * @author Home
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Actor
 */
public abstract class Monster extends Actor {

	
	/**
	 * Default Constructor
	 */
	public Monster() {
	}
	
	
	/**
	 * Constructor
	 */
	public Monster(int maxHealth, int attack, int defense,
			String name) {
		super(maxHealth, attack, defense, name);
	}

	/**
	 * Override the abstract class method attack().
	 */
	@Override
	public String attack(Actor target) {
		// TODO special abilities of monsters
		return super.attack(target);
	}

	/**
	 * Override the abstract class method isDead().
	 */
	@Override
	public boolean isDead() {
		// TODO special abilities of monsters
		return super.isDead();
	}
	
	/**
	 * This method can reset the Monster to be fully active.
	 */
	public void reset(){
		this.setHealth(this.getMaxHealth());
	}
	
	/**
	 * Rewards the player when the monster is killed.
	 */
	public abstract void killReward(CurseOfMalphamondModelImpl model) throws CardNotFoundException;
}
