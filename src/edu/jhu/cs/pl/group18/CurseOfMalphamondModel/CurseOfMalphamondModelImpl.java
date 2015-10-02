/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.InvalidTileTypeException;
import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.InvalidTimeException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.MoveNumTilesAction;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.RestoreNumHealthAction;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action.RollDiceAction;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Boss;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Monster;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.ResourceCards.Hustle;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.ResourceCards.LightningBolt;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.ResourceCards.PhysicalTraining;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.ResourceDeck;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.UsedResourceCards;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.ActionTile;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.DrawingTile;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.MovementTile;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.EmptyTile;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.OptionTile;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.HealingFountainTile;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.ResourceTile;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.Tile;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.MonsterTile;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.TileType;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Monsters.MonsterBeast;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Monsters.MonsterDevil;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Monsters.MonsterDragon;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Monsters.MonsterOctopus;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Monsters.MonsterPhoenix;

/**
 * This class is the server part of the model. It is a complete implementation of the model.
 * @author Yunlong Liu
 * @version 1.0
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel
 */
public class CurseOfMalphamondModelImpl implements
		CurseOfMalphamondModel {

	
	private List<Player>         players;
	private Map<Position, Tile>  board;
	private Dice                 dice;
	private Boss                 boss;
	private int					 diceNum;
	
	private int                  currentActivePlayerID;
	private ResourceDeck         resourceDeck;
	private UsedResourceCards    usedResourceCards;
	
	private static int           order;
	private UseTimeType 		 useTime;
	private int					 choice;
	
	private static final int NUM_TILES = 28;
	private static final int DEFAULT_STARTING_HAND_SIZE = 3;	
	
	/*
	 * Note that these listeners are used by ConnectionManager
	 */
	private List<ModelListener> listeners;

	/**
	 * @return the currentActivePlayer
	 */
	public Player getCurrentActivePlayer() {
		return this.players.get(currentActivePlayerID);
	}

	/**
	 * Constructor of the model impl.
	 */
	public CurseOfMalphamondModelImpl() {
		initializeModelImpl();
	}

	/**
	 * 
	 */
	private void initializeModelImpl() {
		this.dice = new Dice();
		this.boss = new Boss();
		this.board = new HashMap<Position, Tile>();
		this.players = new ArrayList<>();
		this.listeners = new ArrayList<>();
		this.resourceDeck = new ResourceDeck();
		this.usedResourceCards = new UsedResourceCards();
		CurseOfMalphamondModelImpl.order = 0;
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
	public void initializeGame() {
		
		for (int i = 0; i < 4; i++) {
			this.resourceDeck.add(new Hustle());
			this.resourceDeck.add(new PhysicalTraining());
			//this.resourceDeck.add(new LightningBolt());
		}
		this.resourceDeck.shuffle();

		for (int i = 0; i < CurseOfMalphamondModelImpl.NUM_TILES; i++){
			board.put(new Position(i), new EmptyTile(new Position(i), "Empty Tile"));
		}
		board.put(new Position(0), new EmptyTile(new Position(0), "Go Tile"));
		
		board.put(new Position(7), new OptionTile(new Position(7), "Option Tile"));
		board.put(new Position(21), new OptionTile(new Position(21), "Option Tile"));

		board.put(new Position(14), new HealingFountainTile(new Position(14)));
		
		board.put(new Position(16), new MovementTile(new Position(16), "Movement Tile"));
		board.put(new Position(11), new MovementTile(new Position(11), "Movement Tile"));
		board.put(new Position(26), new MovementTile(new Position(26), "Movement Tile"));
		board.put(new Position(5), new MovementTile(new Position(5), "Movement Tile"));

		board.put(new Position(8), new ResourceTile(new Position(8), "Resource Tile"));
		board.put(new Position(17), new ResourceTile(new Position(17), "Resource Tile"));
		
		board.put(new Position(2), new DrawingTile(new Position(2), "DrawingTile"));
		board.put(new Position(15), new DrawingTile(new Position(15), "DrawingTile"));
		board.put(new Position(23), new DrawingTile(new Position(23), "DrawingTile"));
		
		board.put(new Position(1), new EmptyTile(new Position(1), "Empty Tile"));
		board.put(new Position(10), new EmptyTile(new Position(10), "Empty Tile"));
		board.put(new Position(19), new EmptyTile(new Position(19), "Empty Tile"));
		board.put(new Position(24), new EmptyTile(new Position(24), "Empty Tile"));
		
		board.put(new Position(4), new MonsterTile(new MonsterDragon(), new Position(4), "Monster Dragon"));
		board.put(new Position(18), new MonsterTile(new MonsterPhoenix(), new Position(18), "Monster Phoenix"));
		board.put(new Position(27), new MonsterTile(new MonsterOctopus(), new Position(18), "Monster Octopus"));
		board.put(new Position(22), new MonsterTile(new MonsterBeast(), new Position(22), "Monster Beast"));
		board.put(new Position(9), new MonsterTile(new MonsterDevil(), new Position(9), "Monster Devil"));

		

		this.currentActivePlayerID = 0;
		try {
			this.getCurrentActivePlayer().drawTopDeck();
		} catch (CardNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setUseTime(UseTimeType.BeforeRollDice);
		
		for ( ModelListener listener: this.listeners ) {
			listener.boardInfoChanged();
			listener.currentActivePlayerChanged();
		}
	}

	/**
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel#endGame()
	 */
	@Override
	public void endGame() {
		// TODO Do something real
	}

	/**
	 * Add a player to the model for the test cases
	 * @param player The player
	 */
	public void addPlayerTest(Player player) {
		
		player.setID( order );
		order ++;
		for (Player oldPlayer: this.players){
			if (oldPlayer.getUsername() == player.getUsername()){
				String username = player.getUsername() + "*";
				player.setUsername(username);
			}
		}
		
		this.players.add( player );
		
		for ( ModelListener listener: this.listeners ) {
			listener.playerAdded( player );
			listener.handChanged(player.getHand(), player.getUsername());
		}
		
		if ( this.players.size() == 4 ) {
			initializeGame();
		}	
		
	}
	
	/**
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel#addPlayer(Player)
	 */
	@Override
	public void addPlayer(Player player) {
		
		player.setID( order );
		order ++;
		for (Player oldPlayer: this.players){
			if (oldPlayer.getUsername() == player.getUsername()){
				String username = player.getUsername() + "*";
				player.setUsername(username);
			}
		}
		
		this.players.add( player );
		//TODO DELETE AFTER
		player.getDeck().shuffle();
		try {
			for (int j = 0; j < CurseOfMalphamondModelImpl.DEFAULT_STARTING_HAND_SIZE; j++) {
				player.drawTopDeck();
			}
		} catch (CardNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for ( ModelListener listener: this.listeners ) {
			listener.playerAdded( player );
			listener.handChanged(player.getHand(), player.getUsername());
		}
		
		if ( this.players.size() == 4 ) {
			initializeGame();
		}	
		
	}

	/**
	 * @return 
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel#isGameOver()
	 */
	@Override
	public boolean isGameOver() {
		return this.boss.isDead();
	} 

	/**
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel#removePlayer(Player)
	 */
	@Override
	public void removePlayer( Player player ) {
		
		if ( player.equals( this.getCurrentActivePlayer() ) ) {
			this.currentActivePlayerID  = 0; 
			for ( ModelListener listener: this.listeners ) {
				listener.currentActivePlayerChanged();
			}
		}
		this.players.remove( player );
		
		for ( ModelListener listener: this.listeners ) {
			listener.playerRemoved( player );
		}
	}

	/**
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel#getAllTiles()
	 */
	@Override
	public List<Tile> getAllTiles() {
		return new ArrayList<Tile>(board.values());
	}

	/**
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel#playCard(int, int)
	 */
	@Override
	public void playCard(int cardPos, int choice) throws CardNotFoundException, InvalidTimeException {
		
		this.choice = choice;
		Card card = this.getCurrentActivePlayer().getHand().getCards().get(cardPos);
		/*
		if (!card.canBeUsedNow(useTime)) {
			throw new InvalidTimeException();
		}	*/
		card.play(this, choice);
		this.getCurrentActivePlayer().discardCard(cardPos, this);
		
		for ( ModelListener listener : this.listeners ) {
			card.notifyListener(listener, this);
			listener.handChanged(this.getCurrentActivePlayer().getHand(), this.getCurrentActivePlayer().getUsername());
		}		
	}

	@Override
	public void rollDice() throws InvalidTimeException {
		// just to mute the exception
		this.setUseTime(UseTimeType.BeforeRollDice);

		if (!(this.useTime == UseTimeType.BeforeRollDice || this.useTime == UseTimeType.Special)) {
			throw new InvalidTimeException();
		}
		if (this.useTime == UseTimeType.BeforeRollDice) {
			this.setUseTime(UseTimeType.AfterRollDice);
		}
		(new RollDiceAction(this)).act();

		for ( ModelListener listener: this.listeners ) {
			listener.diceRolled();
		}
	}


	/**
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel#fight()
	 */
	@Override
	public void fight() throws InvalidTimeException {
		/*
		if (this.useTime != UseTimeType.AfterMove) {
			throw new InvalidTimeException();
		}*/
		String result = "";
		Character attacker = this.getCurrentActivePlayer().getCharacter();
		Monster defender = ((MonsterTile) (this.board.get(this.getCurrentActivePlayer().getCharacter().getCurrentPosition()))).getMonster();
		while(!(attacker.isDead() || defender.isDead())){
			result = result.concat(attacker.attack(defender));
			if (!(attacker.isDead() || defender.isDead())){
				result = result.concat(defender.attack(attacker));
			}
		}
		if (attacker.isDead()) {
			result = result.concat( defender.getName() + " wins!\n");
			this.getCurrentActivePlayer().moveCharacter(new Position(0));
			int health = this.getCurrentActivePlayer().getCharacter().getMaxHealth();
			this.getCurrentActivePlayer().getCharacter().setHealth(health);
			for ( ModelListener listener: this.listeners ) {
				listener.characterChanged(this.getCurrentActivePlayer().getCharacter(), this.getCurrentActivePlayer().getUsername(), null);
			}
		} else {
			result = result.concat( attacker.getName() + " wins!\n");
			try {
				this.getCurrentActivePlayer().drawResourceCard(this);
				defender.reset();
				for ( ModelListener listener: this.listeners ) {
					listener.handChanged(this.getCurrentActivePlayer().getHand(), this.getCurrentActivePlayer().getUsername());
				}
			} catch (CardNotFoundException e) {
				e.printStackTrace();
			}
		}

		this.setUseTime(UseTimeType.AfterBattle);
		for ( ModelListener listener: this.listeners ) {
			listener.monsterAttacked(result);
		}
	}

	/**
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel#endTurn()
	 */
	@Override
	public void endTurn() throws InvalidTimeException {
		
		/*
		if (! (this.useTime == UseTimeType.AfterMove || this.useTime == UseTimeType.AfterBattle)) {
			throw new InvalidTimeException();
		}
		if (! (this.useTime == UseTimeType.AfterMove || this.useTime == UseTimeType.AfterBattle)) {
			throw new InvalidTimeException();
		}*/
		this.currentActivePlayerID  = (this.currentActivePlayerID + 1) % this.players.size();
		try {
			this.getCurrentActivePlayer().drawTopDeck();
		} catch (CardNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for ( ModelListener listener: this.listeners ) {
			listener.currentActivePlayerChanged();
			listener.handChanged(this.getCurrentActivePlayer().getHand(),this.getCurrentActivePlayer().getUsername());
		}
		if (this.isGameOver()) {
			this.endGame();
		}
		this.setUseTime(UseTimeType.BeforeRollDice);
	}

	/**
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel#removeListener(ModelListener)
	 */
	@Override
	public void removeListener( ModelListener listener ) {
		
		this.listeners.remove(listener);
		
	}

	public List<Player> getPlayers() {
		return players;
	}

	public Map<Position, Tile> getBoard() {
		return board;
	}

	public void setBoard(Map<Position, Tile> board) {
		this.board = board;
	}

	public Boss getBoss() {
		return boss;
	}

	public void setBoss(Boss boss) {
		this.boss = boss;
	}

	@Override
	public Dice getDice() {
		return dice;
	}

	public ResourceDeck getResourceDeck() {
		return this.resourceDeck;
	}

	public UsedResourceCards getUsedResourceCards() {
		return this.usedResourceCards;
	}

	@Override
	public void moveCharacter(int step) throws InvalidTimeException {
		
		/*
		if (this.useTime != UseTimeType.AfterRollDice) {
			throw new InvalidTimeException();
		}
		*/
		int oldLevel = this.getCurrentActivePlayer().getCharacter().getLevel();
		(new MoveNumTilesAction(step, this.getCurrentActivePlayer())).act();
		int newLevel = this.getCurrentActivePlayer().getCharacter().getLevel();
		//this.currentTile = this.board.get(this.getCurrentActivePlayer().getCharacter().getCurrentPosition());
		
		if (oldLevel != newLevel) {
			
			// enhance monsters
			for (Tile tile : board.values()) {
				if (tile.getTileType().equals(TileType.MonsterTile)) {
					int attack = ((MonsterTile)tile).getMonster().getAttack();
					((MonsterTile)tile).getMonster().setAttack(attack);
					int defense = ((MonsterTile)tile).getMonster().getDefense();
					((MonsterTile)tile).getMonster().setDefense(defense);
				}
			}
			
			// if Level 6, can challenge the boss
			if (newLevel == 6) {
				
				String result = "";
				Character attacker = this.getCurrentActivePlayer().getCharacter();
				
				// remove this after the game is properly initialized!!!
				Boss boss = new Boss();
				
				
				while(!(attacker.isDead() || boss.isDead())){
					result = result.concat(attacker.attack(boss));
					if (!(attacker.isDead() || boss.isDead())){
						result = result.concat(boss.attack(attacker));
					}
				}
				if (attacker.isDead()) {
					result = result.concat( boss.getName() + " wins!\n");
					this.getCurrentActivePlayer().getCharacter().setLevel(5);
				} else {
					result = result.concat( attacker.getName() + " wins!\nGame Over!!\n");
					// Game Over!!
				}
				
				for ( ModelListener listener: this.listeners ) {
					listener.canChallengeBoss(result);
				}
			}
		}
				
		this.setUseTime(UseTimeType.AfterMove);
		for ( ModelListener listener: this.listeners ) {
			listener.characterChanged(this.getCurrentActivePlayer().getCharacter(), this.getCurrentActivePlayer().getUsername(), null);
			listener.currentTileChanged();
		}
	}

	@Override
	public void setDiceNumber(int diceNum) {
		this.diceNum = diceNum;
	}
	
	@Override
	public int getDiceNumber() {
		return this.diceNum;
	}
	
	/**
	 * Get the use time
	 * @return The useTime
	 */
	public UseTimeType getUseTime() {
		return this.useTime;
	}

	/** 
	 * Set the use time
	 * @param useTime The useTime to set
	 */
	public void setUseTime(UseTimeType useTime) {
		this.useTime = useTime;
	}
	
	/**
	 * Happens when the player's hand is too full for drawing a card. Thus, the card will be discarded.
	 */
	public void myHandIsTooFull() {
		//TODO tell the listener!!
	}

	/**
	 * Call this function to make action tile act.
	 */
	@Override
	public void actionTileAct() {
		if (this.board.get(this.getCurrentActivePlayer().getCharacter().getCurrentPosition()).getTileType().equals(TileType.ActionTile)) {
			((ActionTile) this.board.get(this.getCurrentActivePlayer().getCharacter().getCurrentPosition())).act(this);
			for ( ModelListener listener: this.listeners ) {
				listener.handChanged(this.getCurrentActivePlayer().getHand(),this.getCurrentActivePlayer().getUsername());
			}
		} else {
			try {
				throw new InvalidTileTypeException();
			} catch (InvalidTileTypeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Call this function to make resource tile act.
	 */
	@Override
	public void resourceTileAct() {
		if (this.board.get(this.getCurrentActivePlayer().getCharacter().getCurrentPosition()).getTileType().equals(TileType.ResourceTile)) {
			try {
				this.getCurrentActivePlayer().drawResourceCard(this);
				for ( ModelListener listener: this.listeners ) {
					listener.handChanged(this.getCurrentActivePlayer().getHand(),this.getCurrentActivePlayer().getUsername());
				}
			} catch (CardNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				throw new InvalidTileTypeException();
			} catch (InvalidTileTypeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * the option tiles random
	 */
	public void healingFountainAct() {
		(new RestoreNumHealthAction(this.getCurrentActivePlayer().getCharacter().getMaxHealth(), this.getCurrentActivePlayer())).act();
		for ( ModelListener listener: this.listeners ) {
			listener.characterChanged(this.getCurrentActivePlayer().getCharacter(), this.getCurrentActivePlayer().getUsername(), this.getCurrentActivePlayer().getUsername() + " restores to maximum health!\n");
		}
	}

	public void randomOptionTileAct() {
		Random rand = new Random();
		int randomNum = rand.nextInt(5);
		String result = "";
		if (randomNum == 1 ) {
			int attack = this.getCurrentActivePlayer().getCharacter().getAttack();
			this.getCurrentActivePlayer().getCharacter().setAttack(attack + 1);
			result = this.getCurrentActivePlayer().getUsername() + " gains 1 attack!\n";
		}else if (randomNum == 2){
			int defense = this.getCurrentActivePlayer().getCharacter().getDefense();
			this.getCurrentActivePlayer().getCharacter().setDefense(defense + 1);
			result = this.getCurrentActivePlayer().getUsername() + " gains 1 defense!\n";
		}else if (randomNum == 3){
			int health = this.getCurrentActivePlayer().getCharacter().getHealth();
			this.getCurrentActivePlayer().getCharacter().setHealth(health +5);
			result = this.getCurrentActivePlayer().getUsername() + " gains 5 health!\n";
		}else if (randomNum == 4){
			int health = this.getCurrentActivePlayer().getCharacter().getHealth();
			this.getCurrentActivePlayer().getCharacter().setHealth(health -3);
			result = this.getCurrentActivePlayer().getUsername() + " loses 3 health!\n";
		}else if (randomNum == 0){
			int attack = this.getCurrentActivePlayer().getCharacter().getAttack();
			this.getCurrentActivePlayer().getCharacter().setAttack(attack + 2);
			result = this.getCurrentActivePlayer().getUsername() + " gains 2 attack!\n";
		}
		
		for ( ModelListener listener: this.listeners ) {
			listener.characterChanged(this.getCurrentActivePlayer().getCharacter(), this.getCurrentActivePlayer().getUsername(), result);
		}
	}
	
	/**
	 * resets the game
	 */
	public void reset() {
		initializeModelImpl();
		initializeGame();

	}
	
	/**
	 * Get the choice on how to play the card
	 * @return The choice
	 */
	public int getChoice() {
		return this.choice;
	}
	
	/**
	 * Set the choice on how to play the card
	 * @param choice The choice
	 */
	public void setChoice(int choice) {
		 this.choice = choice;
	}
	
	/**
	 * Get the tile at the position
	 * @param p the position you want to get tile from.
	 */
	public Tile getTileAtPosition(Position p) {
		return this.board.get(p);
	}
	
	/**
	 * Get current Tile
	 */
	public Tile getCurrentTile() {
		return this.board.get(this.getCurrentActivePlayer().getCharacter().getCurrentPosition());
	}
}
