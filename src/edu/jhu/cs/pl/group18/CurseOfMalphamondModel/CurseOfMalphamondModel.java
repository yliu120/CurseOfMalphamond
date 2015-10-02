/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel;

import java.io.IOException;
import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.InvalidTileTypeException;
import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.InvalidTimeException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.Tile;

/**
 * Here provides an interface of the model.
 * This interface can be implemented on both client and server side.
 * @author Yunlong Liu
 * @version 1.6
 * @since 1.0
 */
public interface CurseOfMalphamondModel {
	
	/**
	 * Add a model listener to this model.
	 * @param listener The listener
	 */
	public void addListener( ModelListener listener );
	
	/**
	 * Call this function will initialize the game.
	 */
	public void initializeGame();
	
	/**
	 * Call this function will end the game.
	 */
	public void endGame();
	
	/**
	 * Add a player to the game.
	 * @param player The player
	 */
	public void addPlayer(Player player);
	
	/**
	 * @return returns whether the game is over.
	 */
	public boolean isGameOver();
	
	/**
	 * Remove a player from the game.
	 * @param player The player
	 */
	public void removePlayer( Player player );
	
	/**
	 * Get the dice of the model
	 */
	public Dice getDice();
	
	/**
	 * Get a list of all the players in the game
	 * @return The list of players
	 */
	public List<Player> getPlayers();
	
	/**
	 * Get the currently active player
	 * @return The player
	 */
	public Player getCurrentActivePlayer();

	
	/**
	 * Get all the tiles on the board of the game
	 * @return a list of tiles
	 */
	public List<Tile> getAllTiles();
	
	/**
	 * Call this function to play a card.
	 * @param cardPos The position of the card relative to the player's hand
	 * @param choice The choice of the player
	 * @throws CardNotFoundException 
	 * @throws InterruptedException 
	 * @throws IOException
	 * @throws InvalidTimeException 
	 */
	public void playCard( int cardPos, int choice ) throws CardNotFoundException, IOException, InterruptedException, InvalidTimeException;

	/**
	 * Fight is a special kind of play that causes the current active character to fight against the monster
	 * on current tile until one dies.
	 * @throws InvalidTimeException 
	 */
	public void fight() throws InvalidTimeException;
	
	/**
	 * Call this function to end a round.
	 * @throws InvalidTimeException 
	 */		
	public void endTurn() throws InvalidTimeException;
	
	/**
	 * Remove a model listener from the model.
	 * @param listener The listener
	 */
	public void removeListener( ModelListener listener );
	
	/**
	 * Roll the dice.
	 * @throws InvalidTimeException 
	 */
	public void rollDice() throws InvalidTimeException;
	
	
	/**
	 * Move character a number of steps
	 * @param step The number of steps
	 * @throws InvalidTimeException 
	 */
	public void moveCharacter(int step) throws InvalidTimeException;

	/**
	 * Set dice number
	 * @param diceNum The dice number
	 */
	public void setDiceNumber(int diceNum);

	/**
	 * Get dice number
	 * @return The dice number
	 */
	public int getDiceNumber();
	
	/**
	 * get the currently active player's character's tile
	 */
	public Tile getCurrentTile();
	
	/**
	 * Does the act required by the action tile that the current character in on.
	 */
	public void actionTileAct();

	/**
	 * Draw 2 cards for the current player as the character steps on a resource tile.
	 */
	public void resourceTileAct();

}