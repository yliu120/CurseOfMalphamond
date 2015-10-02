package edu.jhu.cs.pl.group18.CurseOfMalphamond.Test;

import java.util.Random;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Dice;

/**
 * Test for the dice.
 * @author Vincent Yan
 *
 */
public class DiceTest extends TestCase {
	
	private Dice dice;
	
	@Before
	public void setUp() throws Exception {
		dice = new Dice();
	}

	@Test
	public void testDiceInTestMode() {
		dice.setTestMode(true);
		Random sampler = new Random( 0 );
		int sample;
		for (int i = 0; i < 100; i++) {
			sample = sampler.nextInt(6) + 1;
			dice.rollDice();
			assertTrue(dice.getDiceNumber() == sample);
		}
	}
	
	@Test
	public void testDice() {
		for (int i = 0; i < 100; i++) {
			dice.rollDice();
			assertTrue(dice.getDiceNumber() >= 1 && dice.getDiceNumber() <= 6);
		}
	}

}
