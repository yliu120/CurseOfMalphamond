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
 * of the Monster Dragon in the game.
 * @author Yijie
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Monsters.MonsterDragon
 */
public class MonsterDragon extends Monster{

	
	/**
	 * Default Constructor
	 */
	public MonsterDragon() {
		super(20, 7, 2, "Dragon");
	}

	/**
	 * Override the monster class method attack().
	 * Dragon may gain 1 attack.
	 */
	@Override
	public String attack(Actor target) {
		Random rand = new Random();
		int randomNum = rand.nextInt(4);
		if (randomNum == 1) {
			int attack = this.getAttack();
			this.setAttack(attack + 1);
			String s = super.attack(target);
			return s + this.getName() + "'s attack + 1!\n";
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