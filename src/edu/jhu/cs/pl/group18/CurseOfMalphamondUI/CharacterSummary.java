/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Position;

/**
 * This is the character summary which draws characters on board.
 * 
 * @author Xuchen Ma
 *
 */
public class CharacterSummary {

	public class Pair {
		public int xpos;
		public int ypos;

		public Pair(int xpos, int ypos) {
			this.xpos = xpos;
			this.ypos = ypos;
		}
	}

	private static final long serialVersionUID = 1L;
	private static CurseOfMalphamondModelProxy model;
	private static ImageLoader loader;
	private static int[] xpos = new int[28];
	private static int[] ypos = new int[28];
	private static Map<Position, Pair> boardPositions = new HashMap<>();

	/**
	 * Constructor with a image loader and model proxy
	 * 
	 * @param loader
	 *            the only loader instantiate in the game to load image
	 */
	public CharacterSummary(ImageLoader loader) {

		this.loader = loader;

		for (int i = 0; i < 7; i++) {
			xpos[i] = 490 - 62 * i;
			ypos[i] = 455;
		}
		for (int i = 7; i < 14; i++) {
			xpos[i] = 55;
			ypos[i] = 455 - 62 * (i - 7);
		}
		for (int i = 14; i < 21; i++) {
			xpos[i] = 55 + 62 * (i - 14);
			ypos[i] = 10;
		}
		for (int i = 21; i < 28; i++) {
			xpos[i] = 490;
			ypos[i] = 10 + 62 * (i - 21);
		}
		for (int i = 0; i < 28; i++) {
			boardPositions.put(new Position(i), new Pair(xpos[i], ypos[i]));
		}
	}

	/**
	 * This function is a static function that can draw the player summary.
	 * 
	 * @param g Graphics object provides by Java AWT
	 * @param player The player to draw
	 * @param position The position of the player
	 */
	public static void paintSummary(Graphics g, Player player, Position position) {

		// Draw Character
		BufferedImage playerImage = loader.fetchImage(player.getCharacter()
				.getName());
		ImageIcon characterPic = new ImageIcon(playerImage.getScaledInstance(
				33, 55, Image.SCALE_SMOOTH));
		g.drawImage(characterPic.getImage(), boardPositions.get(position).xpos,
				boardPositions.get(position).ypos, null);
	}

	/**
	 * Get a map of the board positions
	 * @return The map
	 */
	public static Map<Position, Pair> getBoardPositions() {
		return boardPositions;
	}

}