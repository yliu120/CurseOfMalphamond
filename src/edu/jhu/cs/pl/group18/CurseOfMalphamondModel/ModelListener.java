/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.Hand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;

/**
 * Here provides an public interface for the model listeners.
 * @author Yunlong
 * @version 1.0
 */
public interface ModelListener {
	
	/**
	 * Call this function when player info changed.
	 */
	public void playerInfoChanged();
	
	/**
	 * Call this function when a player is added.
	 */
	public void playerAdded( Player player );
	
	/**
	 * Call this function when a player is removed.
	 */
	public void playerRemoved( Player player );
	
	/**
	 * Call this function when dice is rolled.
	 */
	public void diceRolled();
	
	/**
	 * Call this function when board is changed.
	 */
	public void boardInfoChanged();
	
	/**
	 * Call this function when current active player changed.
	 */
	public void currentActivePlayerChanged();
	
	/**
	 * Call this function when the server want to throw exception.
	 */
	public void gameExceptionThrowed();
	
	/**
	 * Call this function when the model's current tile changed.
	 */
	public void currentTileChanged();
	
	/**
	 * Call this function when the current player's character is attacking the monster.
	 * @param result the fight result
	 */
	public void monsterAttacked(String result);
	
	/**
	 * Call this function when a player's hand is changed.
	 * @param hand the hand 
	 * @param username the username of the player
	 */
	public void handChanged(Hand hand, String username);
	
	/**
	 * Call this function when the currentPlayer can challenge the boss.
	 * @param result the fight result
	 */
	public void canChallengeBoss(String result);

	/**
	 * Call this function when a player's character is changed.
	 * @param username the player's username
	 * @param character the player's the character
	 * @param result the description of the action
	 */
	public void characterChanged(Character character, String username, String result);
}
