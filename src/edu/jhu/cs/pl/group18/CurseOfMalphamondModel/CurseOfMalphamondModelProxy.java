/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.InvalidTimeException;
import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.PlayerCantAccessServerException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.MessageReceivedEvent;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Messenger;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.MessengerListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.ActionTileActCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.AddPlayerCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.Command;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.EndTurnCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.FightCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.MoveNumTilesCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.PlayCardCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.RegisterConnectionCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.ResourceTileActCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.RollDiceCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Boss;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.Hand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.Tile;

/**
 * This class is something like a proxy that communicates between model and ui
 * @author Yunlong
 */
public class CurseOfMalphamondModelProxy implements
		CurseOfMalphamondModel {

	
	private List<Player> players;
	private List<Tile>   tiles;
	private Dice         dice;
	private Boss         boss;
	private UseTimeType  currentTime;
	private List<ModelListener> listeners;
	private int 		 diceNum;
	
	
	private Player       localPlayer;
	private Player       currentPlayer = null;
	private Messenger    messenger;
	private Tile         currentTile;

	private Command response;
	
	private String exception;
	
	public CurseOfMalphamondModelProxy() {
		
		listeners = new ArrayList<>();
		players = new ArrayList<Player>();
		dice = new Dice();
		messenger = new Messenger();
		
		this.messenger.addListener(new MessengerListener() {
			
			@Override
			public void messageReceived(MessageReceivedEvent messageReceivedEvent) {
				
				response = messageReceivedEvent.getMessage();
				executeMessage();
				response = null;
			}
		});
		
	}
	
	/**
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel#addListener(ModelListener)
	 */
	@Override
	public void addListener( ModelListener listener ) {
		this.listeners.add(listener);
	}

	/**
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel#initializeGame()
	 */
	@Override
	public void initializeGame() {
		//TODO

	}

	/**
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel#endGame()
	 */
	@Override
	public void endGame() {
		// TODO Auto-generated method stub

	}

	/**
	 * @return 
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel#isGameOver()
	 */
	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return false;

	}


	/**
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel#getAllTiles()
	 */
	@Override
	public List<Tile> getAllTiles() {
		return this.tiles;
	}
	
	@Override
	public void playCard(int cardPos, int choice) {
		try {
			this.messenger.sendCommand( new PlayCardCommand( cardPos, choice ) );
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	
	/**
	 * Call this method to roll Dice
	 */
	@Override
	public void rollDice() {
		try {
			this.messenger.sendCommand(new RollDiceCommand());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel#fight()
	 */
	@Override
	public void fight() {
		try {
			this.messenger.sendCommand(new FightCommand());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel#endTurn()
	 */
	@Override
	public void endTurn() {
		
		try {
			this.messenger.sendCommand(new EndTurnCommand());
		} catch (IOException | InterruptedException e) {
			RuntimeException exception = new RuntimeException("Network is probably down");
		}

	}
	
	/*
	 * Getters and Setters for model.
	 */

	public Messenger getMessenger() {
		return messenger;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public List<Tile> getTiles() {
		return tiles;
	}

	@Override
	public Dice getDice() {
		return dice;
	}

	public Boss getBoss() {
		return boss;
	}

	public Player getLocalPlayer() {
		return localPlayer;
	}

	@Override
	public void addPlayer(Player player) {
		
		this.players.add(player);
		
		for ( ModelListener listener : listeners ) {
			listener.playerAdded( player );
		}
		
	}

	@Override
	public void removePlayer(Player player) {
		this.players.remove(player);
		for ( ModelListener listener : listeners ) {
			listener.playerRemoved( player );
		}
	}

	@Override
	public void removeListener( ModelListener listener ) {
		this.listeners.remove( listener );
	}
	
	/**
	 * Call this function by model proxy to register new player.
	 * @return whether player is successfully registered
	 */
	public boolean registerPlayer () {
		try {
			
			this.messenger.connectServer();
			this.messenger.sendCommand(new RegisterConnectionCommand( this.localPlayer ));
			
			long startTimeMillis = System.currentTimeMillis();
			long time = 0;
			
			while( ! this.messenger.isRegisterSuccess() ) {
				Thread.sleep(0, 100);
				time = System.currentTimeMillis() - startTimeMillis;
				if ( time > 1000 ) {
					return false;
				}
			}
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (PlayerCantAccessServerException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		return true;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(List<Player> players) {
		
		this.players = players;
		for ( ModelListener listener : listeners ) {
			listener.playerInfoChanged();
		}
	}

	/**
	 * @param tiles the tiles to set
	 */
	public void setTiles(List<Tile> tiles) {
		this.tiles = tiles;
	}

	/**
	 * @param boss the boss to set
	 */
	public void setBoss(Boss boss) {
		this.boss = boss;
	}

	/**
	 * @param localPlayer the localPlayer to set
	 */
	public void setLocalPlayer(Player localPlayer) {
		this.localPlayer = localPlayer;
	}
	/*
	public void newGame () {
		this.messenger.sendCommand(command);
	}
	 */

	@Override
	public Player getCurrentActivePlayer() {
		return this.currentPlayer;
	}
	
	/**
	 * This setter will set the current active player.
	 * @param player the current active player
	 */
	public void setCurrentActivePlayer( Player player ) {
		
		this.currentPlayer = player;
		
		if ( this.localPlayer.equals( player ) ) {
			this.localPlayer = player;
			this.setCurrentTime(UseTimeType.BeforeRollDice);
		}
		
		for ( ModelListener listener : this.listeners ) {
			listener.currentActivePlayerChanged();
		}
		
	}
	
	private void executeMessage() {
		
		try {
			if ( response instanceof AddPlayerCommand ) {
			}
			response.execute(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @return the exception
	 */
	public String getException() {
		return exception;
	}

	/**
	 * @param exception the exception to set
	 */
	public void setException(String exception) {
		this.exception = exception;
		for ( ModelListener listener : this.listeners ) {
			listener.gameExceptionThrowed();
		}
	}

	@Override
	public void moveCharacter(int step) {
		try {
			this.messenger.sendCommand(new MoveNumTilesCommand(step));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setDiceNumber(int diceNum) {
		this.diceNum = diceNum;
		for ( ModelListener listener : listeners ) {
			listener.diceRolled();
		}
	}
	
	@Override
	public int getDiceNumber() {
		return this.diceNum;
	}

	@Override
	public Tile getCurrentTile() {
		return this.currentTile;
	}
	
	/**
	 * set the current tile
	 * @param tile
	 */
	public void setCurrentTile(Tile tile) {
		this.currentTile = tile;
		for ( ModelListener listener : listeners ) {
			listener.currentTileChanged();
		}
	}
	
	/**
	 * set the fight result
	 * @param result the result
	 */
	public void setFightResult(String result) {
		for ( ModelListener listener : listeners ) {
			listener.monsterAttacked(result);
		}
	}
	
	/**
	 * Set the players hand
	 */
	public void setLocalPlayerHand(Hand hand, String username) {
		if (username.equals(this.localPlayer.getUsername())) {
			this.localPlayer.setHand(hand);
			for ( ModelListener listener : listeners ) {
				listener.handChanged(hand, username);
			}
		}
	}
	
	/**
	 * Set the players character
	 */
	public void setPlayerCharacter(Character character, String username, String result) {
		this.getCurrentActivePlayer().setCharacter(character);
		if (username.equals(this.localPlayer.getUsername())) {
			this.localPlayer.setCharacter(character);
		}
		
		for (Player p : this.players) {
			if (p.getUsername().equals(username)) {
				p.setCharacter(character);
				break;
			}
		}
		
		for ( ModelListener listener : listeners ) {
			listener.characterChanged(character, username, result);
		}
	}
	
	/**
	 * Tells the ui one can challenge boss
	 * @param result
	 */
	public void canChallengeBoss(String result) {
		for ( ModelListener listener : listeners ) {
			listener.canChallengeBoss(result);
		}
	}

	@Override
	public void actionTileAct() {
		try {
			this.messenger.sendCommand( new ActionTileActCommand() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void resourceTileAct() {
		try {
			this.messenger.sendCommand( new ResourceTileActCommand() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Use this function to get current time.
	 * @return the currentTime
	 */
	public UseTimeType getCurrentTime() {
		return currentTime;
	}

	/**
	 * Use this function to set current time.
	 * @param currentTime the currentTime to set
	 */
	public void setCurrentTime(UseTimeType currentTime) {
		this.currentTime = currentTime;
	}
	
	
}
