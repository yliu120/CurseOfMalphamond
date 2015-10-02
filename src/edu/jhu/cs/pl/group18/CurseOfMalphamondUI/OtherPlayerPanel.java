/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondUI;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelImplListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.Hand;

/**
 * This panel is for painting the information of other players
 * 
 * @author Yunlong
 * @version 1.4
 * @since 1.4
 */
public class OtherPlayerPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private CurseOfMalphamondModelProxy model;
	private ImageLoader loader;

	private Map<Player, Integer> otherPlayers;

	private int order = 0;

	/**
	 * Constructor with a image loader and model proxy
	 * 
	 * @param loader
	 *            the only loader instantiate in the game to load image
	 * @param model
	 *            the model proxy that UI calls.
	 */
	public OtherPlayerPanel(ImageLoader loader,
			CurseOfMalphamondModelProxy model) {

		this.model = model;
		this.loader = loader;
		this.otherPlayers = new HashMap<>();

		for (Player player : this.model.getPlayers()) {
			if (!player.equals(this.model.getLocalPlayer())) {
				otherPlayers.put(player, order);
				order++;
			}
		}

		this.model.addListener(new ModelImplListener() {

			@Override
			public void playerAdded(Player player) {
				otherPlayers.put(player, order);
				order++;
				//System.out.println("UI: " + player.getUsername());
				repaint();
			}

			@Override
			public void playerRemoved(Player player) {

				otherPlayers.remove(player);
				repaint();

			}

			@Override
			public void currentTileChanged() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void monsterAttacked(String s) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void handChanged(Hand hand, String username) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void canChallengeBoss(String result) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void characterChanged(Character character, String username, String result) {
				repaint();
			}
		});

	}

	/**
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		
		for (Player player : this.model.getPlayers()) {
			if (!player.equals(this.model.getLocalPlayer())) {
				PlayerSummary.paintSummary(g, player,
						this.otherPlayers.get(player));
			}
		}

		/*
		 * Test Code Player testPlayer = new Player(new CharacterMage());
		 * testPlayer.setUsername("test"); testPlayer.setCharacter(new
		 * CharacterMage()); testPlayer.setID( 0 ); End Test
		 * 
		 * for ( Player player : this.otherPlayers ) {
		 * PlayerSummary.paintSummary(g, player, false); }
		 */

	}

}
