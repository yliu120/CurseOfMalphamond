/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamond.Test;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.UsedCardsIsEmptyException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.Courage;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.March;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.CardContainer;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.UsedCards;

/**
 * Test for the used cards pile.
 * @author andyyang
 *
 */
public class UsedCardsTest extends TestCase {
	private CardContainer container;
	private Card card1, card2;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		container = new UsedCards();
		card1 = new March();
		card2 = new Courage();
	}

	@Test
	public void testEmptyGetNumCards() {
		assertEquals(0, container.getNumCards());
	}
	
	@Test
	public void testEmptyGetCards() {
		assertEquals(0, container.getCards().size());
	}
	
	
	@Test
	public void testEmptyIsEmpty() {
		assertTrue(container.isEmpty());
	}
	
	@Test
	public void testEmptyRemove() {
		try {
			container.remove(card1);
			fail("Expected CardNotFoundException!");
		} catch (CardNotFoundException e){
		}
	}
	
	@Test
	public void testAddGetCards() {
		container.add(card1);
		Card d = container.getCards().get(0);
		assertEquals(card1.getName(), d.getName());
	}
	
	@Test
	public void testAddRemoveIsEmpty() throws CardNotFoundException{
		container.add(card1);
		container.remove(card1);
		assertTrue(container.isEmpty());
	}
	
	@Test
	public void testGetNumCards() throws CardNotFoundException {
		for (int i = 1; i <= 100; i++){
			container.add(card1);
			assertEquals(i,container.getNumCards());
		}
		for (int i = 99; i >=0; i--){
			container.remove(card1);
			assertEquals(i,container.getNumCards());
		}
	}
	
	@Test
	public void testGetCards() {
		container.add(card1);
		container.add(card2);
		List<Card> cards = container.getCards();
		assertEquals(cards.get(0), card1);
		assertEquals(cards.get(1), card2);
	}

	@Test
	public void testGetRecentlyUsedCard () throws UsedCardsIsEmptyException, CardNotFoundException {
		for (int i = 1; i <= 4; i++){
			container.add(card1);
			assertEquals(i,container.getNumCards());
		}
		container.add(card2);
		assertEquals(card2, ((UsedCards) container).getRecentlyUsedCard() );
	}
	
	@Test
	public void testEmptyGetRecentlyUsedCard() throws UsedCardsIsEmptyException {
		
		assertTrue( container.isEmpty() );
		try {
			((UsedCards) container).getRecentlyUsedCard();
			fail("Expected UsedCardsIsEmptyException!");
		} catch (UsedCardsIsEmptyException e){
		}
	}
}

	

