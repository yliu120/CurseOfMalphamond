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
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterMage;

/**
 * This is a junit test for the function Endturn.
 * 
 * @author Yunlong
 * @version 1.5
 */
public class EndTurnTest extends TestCase {

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
	}

	@Test
	public void testEndTurn() {

		String name = "a";
		for (int i = 0; i < 4; i++) {
			Player player = new Player();
			player.initialize(name, new CharacterMage());
			this.players.add(player);
			name = "" + (char) (((int) name.charAt(0)) + 1);
		}

		for (int i = 0; i < 4; i++) {
			CurseOfMalphamondModelProxy proxy = new CurseOfMalphamondModelProxy();
			proxy.setLocalPlayer(this.players.get(i));
			proxy.registerPlayer();
			this.proxys.add(proxy);
		}

		for (int i = 0; i < 4; i++) {
			this.proxys.get(i).rollDice();
			this.proxys.get(i).moveCharacter(1);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.proxys.get(i).endTurn();

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			assertEquals(proxys.get((i+1)%4).getCurrentActivePlayer(), proxys.get((i+1)%4)
					.getLocalPlayer());
			assertEquals(proxys.get(i).getPlayers().size(), 4);

		}

	}

}
