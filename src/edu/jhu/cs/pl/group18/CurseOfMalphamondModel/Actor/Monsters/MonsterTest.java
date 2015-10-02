package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Monsters;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Monster;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.MonsterCards.Marathon;

/**
 * This is a monster for testing
 * @author Vincent Yan
 *
 */
public class MonsterTest extends Monster {

	/**
	 * Default Constructor
	 */
	public MonsterTest() {
	}
	
	
	/**
	 * Constructor
	 */
	public MonsterTest(int maxHealth, int attack,
			int defense, String name) {
		super(maxHealth, attack, defense, name);
	}

	
	@Override
	public void killReward(CurseOfMalphamondModelImpl model)
			throws CardNotFoundException {
		model.getCurrentActivePlayer().drawCard(new Marathon(), null);
	}

}
