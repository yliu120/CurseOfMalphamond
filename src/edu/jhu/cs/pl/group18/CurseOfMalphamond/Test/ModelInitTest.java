package edu.jhu.cs.pl.group18.CurseOfMalphamond.Test;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.UseTimeType;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterBerserker;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterMage;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterPhilosopher;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterScout;

/**
 * Test for the model initialization.
 * @author Vincent Yan
 *
 */
public class ModelInitTest extends TestCase {

	private CurseOfMalphamondModelImpl model;
	private Player player1;
	private Player player2;
	private Player player3;
	private Player player4;
	
	private static final int DECK_MAX_SIZE = 13;
	private static final int RESOURCE_DECK_MAX_SIZE = 12;
	private static final int DEFAULT_STARTING_HAND_SIZE = 3;
	
	@Before
	public void setUp() {
		model = new CurseOfMalphamondModelImpl();
		player1 = new Player();
		player1.initialize("qbaked", new CharacterBerserker());
		player2 = new Player();
		player2.initialize("kaikulimu", new CharacterMage());
		player3 = new Player();
		player3.initialize("titidragon", new CharacterPhilosopher());
		player4 = new Player();
		player4.initialize("shabibani", new CharacterScout());
	}

	@Test
	public void testAddPlayer() {
		model.addPlayer(player1);
		model.addPlayer(player2);
		assertEquals(model.getPlayers(), Arrays.asList(player1, player2));
		
		model.addPlayer(player3);
		model.addPlayer(player4);
		assertEquals(model.getPlayers(), Arrays.asList(player1, player2, player3, player4));
	}

	@Test
	public void testRemovePlayer() {
		model.addPlayer(player1);
		model.addPlayer(player2);
		model.addPlayer(player3);
		model.addPlayer(player4);
		model.removePlayer(player3);
		assertEquals(model.getPlayers(), Arrays.asList(player1, player2, player4));
		
		model.removePlayer(player1);
		assertEquals(model.getPlayers(), Arrays.asList(player2, player4));
	}
	
	@Test
	public void testInitializeGame() {
		model.addPlayer(player1);
		model.addPlayer(player2);
		model.addPlayer(player3);
		model.addPlayer(player4);
		
		assertTrue(model.getUsedResourceCards().isEmpty());
		assertEquals(model.getResourceDeck().getNumCards(), ModelInitTest.RESOURCE_DECK_MAX_SIZE);
		List<Player> players = model.getPlayers();
		for (Player p : players) {
			assertEquals(p.getDeck().getNumCards(), ModelInitTest.DECK_MAX_SIZE
					- ModelInitTest.DEFAULT_STARTING_HAND_SIZE);
			assertEquals(p.getHand().getNumCards(), ModelInitTest.DEFAULT_STARTING_HAND_SIZE);
			assertTrue(p.getUsedCards().isEmpty());
		}
		
		assertEquals(model.getCurrentActivePlayer(), player1);
		assertEquals(model.getUseTime(), UseTimeType.BeforeRollDice);
		//TODO model.getAllTiles() is subject to change
		assertEquals(model.getAllTiles().size(), 28);
		/*for (int i = 0; i < model.getAllTiles().size(); i++) {
			assertEquals(model.getAllTiles().get(i).getTileType(), TileType.EmptyTile);
		}*/	
	}
}
