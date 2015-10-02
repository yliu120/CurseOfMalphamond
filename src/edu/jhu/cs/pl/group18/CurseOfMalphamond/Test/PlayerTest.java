package edu.jhu.cs.pl.group18.CurseOfMalphamond.Test;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.UsedCardsIsEmptyException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Position;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterMage;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.March;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.MonsterCards.Marathon;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.ResourceCards.Hustle;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.Hand;

/**
 * Test for the player.
 * @author Vincent Yan
 *
 */
public class PlayerTest extends TestCase {

	private Player player;
	private CurseOfMalphamondModelImpl model;
	private static final int DECK_MAX_SIZE = 8;
	private static final int RESOURCE_DECK_MAX_SIZE = 4;
	private static final int DEFAULT_STARTING_HAND_SIZE = 3;
	
	@Before
	public void setUp() throws Exception {
		player = new Player();
		player.initialize("kaikulimu", new CharacterMage());
	}

	@Test
	public void testConstructor() {
		assertTrue(player.getHand().isEmpty());
		assertEquals(player.getDeck().getNumCards(), PlayerTest.DECK_MAX_SIZE);
		assertTrue(player.getUsedCards().isEmpty());
		assertEquals(player.getUsername(), "kaikulimu");
		assertEquals(player.getCharacter().getName(), "Mage");
		assertFalse(player.isActive());
	}
	
	@Test
	public void testMoveCharacter() {
		Position newPos = new Position(27);
		player.moveCharacter(newPos);
		assertEquals(player.getCharacter().getCurrentPosition(), newPos);
	}
	
	@Test
	public void testEndTurn() {
		player.setActive(true);
		player.endTurn();
		assertFalse(player.isActive());
	}
	
	@Test
	public void testDrawTopDeck() throws CardNotFoundException, UsedCardsIsEmptyException {
		model = new CurseOfMalphamondModelImpl();
		model.addPlayerTest(player);
		assertTrue(player.getHand().isEmpty());
		Card topDeck;
		//Normal
		for (int i = 1; i <= player.getMaxHandSize(); i++) {
			topDeck = player.getDeck().getCards().get(0);
			player.drawTopDeck();
			assertEquals(player.getDeck().getNumCards(), PlayerTest.DECK_MAX_SIZE - i);
			assertEquals(player.getHand().getNumCards(), i);
			assertTrue(player.getUsedCards().isEmpty());
			assertEquals(topDeck, player.getHand().getCards().get(i - 1));
		}
		//When hand is full
		Hand currentHand = player.getHand();
		for (int i = 6; i < PlayerTest.DECK_MAX_SIZE; i++) {
			topDeck = player.getDeck().getCards().get(0);
			player.drawTopDeck();
			assertEquals(player.getDeck().getNumCards(), PlayerTest.DECK_MAX_SIZE - i);
			assertEquals(player.getHand().getNumCards(), player.getMaxHandSize());
			assertEquals(player.getUsedCards().getNumCards(), i - player.getMaxHandSize());
			assertEquals(player.getUsedCards().getRecentlyUsedCard(), topDeck);
			assertTrue(Arrays.deepEquals(currentHand.getCards().toArray(), player.getHand().getCards().toArray()));
		}
		//When deck is empty, the deck should get refreshed
		assertEquals(player.getUsedCards().getNumCards(), PlayerTest.DECK_MAX_SIZE - player.getMaxHandSize() - 1);
		assertEquals(player.getDeck().getNumCards(), 1);
		player.drawTopDeck();
		assertEquals(player.getDeck().getNumCards(), PlayerTest.DECK_MAX_SIZE - player.getMaxHandSize());
		assertEquals(player.getHand().getNumCards(), player.getMaxHandSize());
		assertTrue(player.getUsedCards().isEmpty());
	}
	
	@Test
	public void testDrawCard() throws CardNotFoundException {
		model = new CurseOfMalphamondModelImpl();
		model.addPlayerTest(player);
		assertTrue(player.getHand().isEmpty());
		Card newCard;
		for (int i = 1; i <= player.getMaxHandSize(); i++) {
			newCard = new March();
			player.drawCard(newCard, model);
			assertEquals(player.getHand().getNumCards(), i);
			assertEquals(player.getDeck().getNumCards(), PlayerTest.DECK_MAX_SIZE);
			assertTrue(player.getUsedCards().isEmpty());
			assertEquals(player.getHand().getCards().get(i - 1), newCard);
		}
		//When hand is full
		Hand currentHand = player.getHand();
		newCard = new Marathon();
		for (int i = 1; i <= 10; i++) {
			player.drawCard(newCard, model);
			assertEquals(player.getHand().getNumCards(), player.getMaxHandSize());
			assertEquals(player.getDeck().getNumCards(), PlayerTest.DECK_MAX_SIZE);
			assertTrue(player.getUsedCards().isEmpty());
			assertTrue(Arrays.deepEquals(currentHand.getCards().toArray(), player.getHand().getCards().toArray()));
		}
	}
	
	@Test
	public void testDiscardCard() throws CardNotFoundException {
		model = new CurseOfMalphamondModelImpl();
		assertTrue(model.getUsedResourceCards().isEmpty());
		model.addPlayerTest(player);
		assertTrue(player.getID() == 0);

		Card card1 = new March();
		Card card2 = new Marathon();
		Card card3 = new Hustle();
		player.drawCard(card1, model);
		player.drawCard(card2, model);
		player.drawCard(card3, model);
		
		player.discardCard(1, model);
		List<Card> list = Arrays.asList(card1, card3);
		Arrays.deepEquals(player.getHand().getCards().toArray(), list.toArray());
		assertTrue(model.getUsedResourceCards().isEmpty());
		assertTrue(player.getUsedCards().isEmpty());
		
		player.discardCard(0, model);
		list = Arrays.asList(card3);
		Arrays.deepEquals(player.getHand().getCards().toArray(), list.toArray());
		assertTrue(model.getUsedResourceCards().isEmpty());
		assertEquals(player.getUsedCards().getNumCards(), 1);
		assertEquals(player.getUsedCards().getCards().get(0).getName(), "March");
		
		player.discardCard(0, model);
		assertTrue(player.getHand().isEmpty());
		assertEquals(model.getUsedResourceCards().getNumCards(), 1);
		assertEquals(model.getUsedResourceCards().getCards().get(0).getName(), "Hustle");
		assertEquals(player.getUsedCards().getNumCards(), 1);
		assertEquals(player.getUsedCards().getCards().get(0).getName(), "March");
		
	}
	
	@Test
	public void testDiscardCardWhenEmpty() throws CardNotFoundException {
		model = new CurseOfMalphamondModelImpl();
		model.addPlayerTest(player);
		try {
			player.discardCard(0, model);
			fail("Expected CardNotFoundException!");
		} catch (CardNotFoundException e) {
		}
	}
	
	@Test
	public void testDrawResourceCard() throws CardNotFoundException {
		model = new CurseOfMalphamondModelImpl();
		model.addPlayer(player);
		model.initializeGame();
		int num = player.getHand().getNumCards();
		for (int i = 0; i < num; i++) {
			player.discardCard(0, model);
		}
		assertTrue(player.getHand().isEmpty());
		assertEquals(model.getResourceDeck().getNumCards(), PlayerTest.RESOURCE_DECK_MAX_SIZE);
		assertTrue(model.getUsedResourceCards().isEmpty());
		
		Card topResourceCard;
		for (int i = 1; i < PlayerTest.RESOURCE_DECK_MAX_SIZE; i ++) {
			topResourceCard = model.getResourceDeck().getCards().get(0);
			player.drawResourceCard(model);
			assertEquals(player.getHand().getNumCards(), i);
			assertEquals(player.getDeck().getNumCards(), PlayerTest.DECK_MAX_SIZE - PlayerTest.DEFAULT_STARTING_HAND_SIZE);
			assertEquals(player.getUsedCards().getNumCards(), PlayerTest.DEFAULT_STARTING_HAND_SIZE);
			assertEquals(model.getResourceDeck().getNumCards(), PlayerTest.RESOURCE_DECK_MAX_SIZE - i);
			assertTrue(model.getUsedResourceCards().isEmpty());
			assertEquals(player.getHand().getCards().get(i - 1), topResourceCard);
		}
		int numToDiscard = 2;
		for (int i = 0; i < numToDiscard; i ++) {
			player.discardCard(0, model);
		}
		
		//When resource deck is empty, the resource deck should get refreshed
		assertEquals(model.getUsedResourceCards().getNumCards(), numToDiscard);
		assertEquals(model.getResourceDeck().getNumCards(), 1);
		assertEquals(player.getHand().getNumCards(), PlayerTest.RESOURCE_DECK_MAX_SIZE - 1 - numToDiscard);
		player.drawResourceCard(model);
		assertTrue(model.getUsedResourceCards().isEmpty());
		assertEquals(model.getResourceDeck().getNumCards(), numToDiscard);
		assertEquals(player.getHand().getNumCards(), PlayerTest.RESOURCE_DECK_MAX_SIZE - numToDiscard);
	}
}
