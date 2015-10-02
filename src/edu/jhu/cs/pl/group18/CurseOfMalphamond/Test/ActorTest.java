/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamond.Test;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Actor;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Boss;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Monsters.MonsterTest;

/**
 * Test for the actor.
 * @author Vincent Yan
 *
 */
public class ActorTest extends TestCase {

	private Actor actor;

	@Before
	protected void setUp() throws Exception {
		actor = new Boss();
	}
	
	@Test
	public void testAttack() {
		
		Actor target = new MonsterTest(10, 5, 5, "GreatMonster");
		Actor target2 = new MonsterTest(10, 0, 5, "GreatMonster");
		Actor target3 = new MonsterTest(10, 5, 0, "GreatMonster");
		Actor target4 = new MonsterTest(10, 2, 2, "GreatMonster");
		Actor target5 = new MonsterTest(10, 300, 300, "GreatMonster");
		actor.attack(target);
		actor.attack(target2);
		actor.attack(target3);
		actor.attack(target4);
		actor.attack(target5);
		
		assertTrue( target.getHealth() == 10);
		assertTrue( target2.getHealth() == 10);
		assertTrue( target3.getHealth() == 5);
		assertTrue( target4.getHealth() == 7);
		assertTrue( target5.getHealth() == 10);
		
		target.attack(actor);
		assertTrue( actor.getHealth() == 17);
		actor.setHealth(actor.getMaxHealth());
		
		target2.attack(actor);
		assertTrue( actor.getHealth() == 20);
		actor.setHealth(actor.getMaxHealth());
		
		target3.attack(actor);
		assertTrue( actor.getHealth() == 17);
		actor.setHealth(actor.getMaxHealth());
		
		target4.attack(actor);
		assertTrue( actor.getHealth() == 20);
		actor.setHealth(actor.getMaxHealth());
		
		target5.attack(actor);
		assertTrue( actor.getHealth() == 0);
		
	}
	
	@Test
	public void testIsDead() {
		
		Actor target = new MonsterTest(1, 1, 0, "GreatMonster");
		actor.attack(target);
		
		assertTrue( target.isDead() );
		assertFalse( actor.isDead() );
		
		Actor target2 = new MonsterTest(20, 1, 4, "GreatMonster");
		actor.attack(target2);
		
		assertFalse( target2.isDead() );
		assertFalse( actor.isDead() );
		
	}

}
