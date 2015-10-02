/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamond.Test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.ServerPortUnbindException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.ConnectionManager;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Position;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.UseTimeType;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterMage;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.GrandMarch;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.GrandRetreat;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.March;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.Reroll;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.Retreat;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.Hand;

/**
 * This is junit test for play card (function unit test);
 * @author Yunlong Liu
 * @version 1.6
 * @version 1.6
 */
public class PlayCardTest extends TestCase { 
	
	private ConnectionManager manager;
	private List<CurseOfMalphamondModelProxy> proxys;
	private List<Player> players;

	@Before
	public void setUp() {
		
		try {
			this.manager = new ConnectionManager();
		} catch (ServerPortUnbindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.proxys = new ArrayList<>();
		this.players = new ArrayList<>();
		
		String name = "a";
		for (int i = 0; i < 4; i++) {
			Player player = new Player();
			player.initialize(name, new CharacterMage());
			
			// Constructing our test hand;
			player.setHand( this.constructTestHand() );
			this.players.add(player);
			name = "" + (char) (((int) name.charAt(0)) + 1);
		}

		for (int i = 0; i < 4; i++) {
			CurseOfMalphamondModelProxy proxy = new CurseOfMalphamondModelProxy();
			proxy.setLocalPlayer(this.players.get(i));
			proxy.registerPlayer();
			this.proxys.add(proxy);
		}
		
	}

	@Test
	public void testEndTurn() {

		this.proxys.get(0).rollDice();
		this.proxys.get(0).setCurrentTime(UseTimeType.AfterRollDice);
		Position oldPos = new Position(0);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals( this.proxys.get(0).getCurrentActivePlayer(), this.proxys.get(0).getLocalPlayer());
		assertEquals( oldPos, this.proxys.get(0).getLocalPlayer().getCharacter().getCurrentPosition());
		this.proxys.get(0).playCard(0, 0);
		Position newPos = new Position(1);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals( newPos, this.proxys.get(0).getLocalPlayer().getCharacter().getCurrentPosition());
		
		this.proxys.get(0).playCard(0, 0);
		newPos = new Position(3);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		assertEquals( newPos, this.proxys.get(0).getLocalPlayer().getCharacter().getCurrentPosition());
		
		this.proxys.get(0).playCard(0, 0);
		newPos = new Position(2);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals( newPos, this.proxys.get(0).getLocalPlayer().getCharacter().getCurrentPosition());
		
		this.proxys.get(0).playCard(0, 0);
		newPos = new Position(0);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals( newPos, this.proxys.get(0).getLocalPlayer().getCharacter().getCurrentPosition());
		
		this.manager.getModelImpl().getDice().setTestMode(true);
		this.proxys.get(0).playCard(0, 0);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int diceNumber = this.proxys.get(0).getDiceNumber();
		assertEquals( 1, diceNumber );
		
	}
	
	private Hand constructTestHand() {
		
		Hand hand = new Hand();
		Card card1 = new March();
		Card card2 = new GrandMarch();
		Card card3 = new Retreat();
		Card card4 = new GrandRetreat();
		Card card5 = new Reroll();
		
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		hand.add(card4);
		hand.add(card5);
		
		return hand;
		
	}

}
