/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel;

import java.util.Random;
/**
 * This is a dice
 * @author Aaron
 * @version 1.2
 * @since 1.0
 */
public class Dice {
	
	private int diceNumber;
	private boolean testMode = false;
	private static Random random = new Random();
	private static Random testModeRandom = new Random( 0 );
	
	/**
	 * Empty Constructor
	 */
	public Dice(){
	}
	
	/**
	 * Call this function will generated a random number from 1 to 6.
	 */
	public void rollDice() {
		if ( this.testMode ) {
			this.diceNumber  = testModeRandom.nextInt(6) + 1;
		} else {
			this.diceNumber = random.nextInt(6) + 1;
		}
	}
	
	/**
	 * Get the dice number
	 * @return The dice number
	 */
	public int getDiceNumber() {
		return diceNumber;
	}
	
	/**
	 * Set whether the dice is in test mode
	 * @param testMode True if in test mode, false otherwise
	 */
	public void setTestMode ( boolean testMode ) {
		this.testMode = testMode;
	}
	
	
}
