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
 * of the Monster Devil in the game.
 * @author Yijie
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Monsters.MonsterDevil
 */
public class MonsterDevil extends Monster{

	
	/**
	 * Default Constructor
	 */
	public MonsterDevil() {
		super(20, 7, 2, "Devil");
	}

	/**
	 * Override the monster class method attack().
	 * instead of attacking target, devil may ignores player's defense.
	 */
	@Override
	public String attack(Actor target) {
		
		Random rand = new Random();
		int randomNum = rand.nextInt(7);
		if (randomNum == 1) {
			int tempDefense = target.getDefense();
			target.setDefense(0);
			String s = super.attack(target);
			target.setDefense(tempDefense);
			return s + this.getName() + "ignores defense!\n";
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