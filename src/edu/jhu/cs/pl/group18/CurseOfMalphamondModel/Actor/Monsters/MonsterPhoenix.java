/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Monsters;

import java.util.Random;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Actor;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Monster;

/**
 * This class extends the Monster class and provides an implementation
 * of the Monster Phoenix in the game.
 * @author Home
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Monsters.MonsterPhoenix
 */
public class MonsterPhoenix extends Monster{

	
	/**
	 * Default Constructor
	 */
	public MonsterPhoenix() {
		super(20, 6, 2, "Phoenix");
	}

	/**
	 * Override the monster class method attack().
	 * instead of attacking target, phoenix may gain 5 health.
	 */
	@Override
	public String attack(Actor target) {
		Random rand = new Random();
		int randomNum = rand.nextInt(4);
		if (randomNum == 1) {
			this.setHealth(this.getHealth() + 5);
			String s = super.attack(target);
			return this.getName() + " gains 5 health!\n" + s;
		} else {
			return super.attack(target);
		}
	}

	/**
	 * Let the actor draw a card from resource if the monster is killed.
	 */
	@Override
	public void killReward(CurseOfMalphamondModelImpl model) throws CardNotFoundException {
		model.getCurrentActivePlayer().drawResourceCard(model);
	}
}