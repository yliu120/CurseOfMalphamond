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
 * of the Monster Beast in the game.
 * 
 * @author Yijie
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Monsters.MonsterBeast
 */
public class MonsterBeast extends Monster{

	
	/**
	 * Default Constructor
	 */
	public MonsterBeast() {
		super(20, 7, 1, "Beast");
	}

	/**
	 * Override the monster class method attack().
	 * instead of attacking target, beast may attack twice 20% of time.
	 */
	@Override
	public String attack(Actor target) {
		
		Random rand = new Random();
		int randomNum = rand.nextInt(4);
		if (randomNum == 1) {
			String s = super.attack(target);
			super.attack(target);
			return this.getName() + "attacks twice!\n"+ s + s;
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