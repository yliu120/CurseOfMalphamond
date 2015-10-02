/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;

/**
 * This is the player summary which shows the info of the player and his/her
 * character.
 * 
 * @author Vincent and Yijie
 *
 */
public class PlayerSummary {

	private static final long serialVersionUID = 1L;
	private CurseOfMalphamondModelProxy model;
	private static ImageLoader loader;
	private static Color cardColor = new Color(224, 255, 255);
	private static Color borderColor = new Color(230, 230, 250);

	private static Color stringColor = new Color(8, 67, 194);

	/**
	 * Constructor with a image loader and model proxy
	 * 
	 * @param loader
	 *            the only loader instantiate in the game to load image
	 */
	public PlayerSummary(ImageLoader loader) {

		this.loader = loader;

	}

	/**
	 * This function is a static function that can draw the player summary.
	 * 
	 * @param g
	 *            Graphics object provides by Java AWT
	 * @param player
	 * 			  The player
	 * @param order
	 *            The player order
	 */
	public static void paintSummary( Graphics g, Player player, int order ) {

		// The coordinate starting to draw the summary of the player.
		int x, y;

		if ( order != -1 ) {
			x = 0;
			y = order * 175;
		} else {
			x = 0;
			y = 0;
		}

		Graphics2D g2 = (Graphics2D) g;

		// Draw Frame
		g2.setStroke(new BasicStroke(6, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));
		g2.setColor(borderColor);
		g2.drawRect(x + 20, y + 20, 160, 160);
		g2.setColor(cardColor);
		g2.fillRect(x + 20, y + 20, 160, 160);

		// Draw Character
		BufferedImage playerImage = loader.fetchImage(player.getCharacter()
				.getName());
		ImageIcon characterPic = new ImageIcon(playerImage.getScaledInstance(60, 100,
				Image.SCALE_SMOOTH));
		g.drawImage(characterPic.getImage(), x + 30, y + 30, null);

		// Draw other boxes
		g2.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));

		// Draw Max Health
		g2.setColor(Color.WHITE);
		g2.drawRect(x + 105, y + 27, 65, 25);
		g2.setColor(borderColor);
		g2.fillRect(x + 105, y + 27, 65, 25);
		ImageIcon maxHealthPic = new ImageIcon(loader.fetchImage("maxHealth").getScaledInstance(
				20, 20, Image.SCALE_SMOOTH));
		g.drawImage(maxHealthPic.getImage(), x + 110, y + 30, null);
		g.setColor(stringColor);
		g2.drawString(Integer.toString(player.getCharacter().getHealth()),
				x + 140, y + 45);

		// Draw Attack
		g2.setColor(Color.WHITE);
		g2.drawRect(x + 105, y + 57, 65, 25);
		g2.setColor(borderColor);
		g2.fillRect(x + 105, y + 57, 65, 25);
		ImageIcon attackPic = new ImageIcon(loader.fetchImage("attack").getScaledInstance(20, 20,
				Image.SCALE_SMOOTH));
		g.drawImage(attackPic.getImage(), x + 110, y + 60, null);
		g.setColor(stringColor);
		g.drawString(Integer.toString(player.getCharacter().getAttack()),
				x + 140, y + 75);
		//System.out.println("attack is " + player.getCharacter().getAttack() + " order = " + order);

		// Draw Defense
		g2.setColor(Color.WHITE);
		g2.drawRect(x + 105, y + 87, 65, 25);
		g2.setColor(borderColor);
		g2.fillRect(x + 105, y + 87, 65, 25);
		ImageIcon defensePic = new ImageIcon(loader.fetchImage("defense").getScaledInstance(20,
				20, Image.SCALE_SMOOTH));
		g.drawImage(defensePic.getImage(), x + 110, y + 90, null);
		g.setColor(stringColor);
		g.drawString(Integer.toString(player.getCharacter().getDefense()),
				x + 140, y + 105);

		// Draw Level
		g2.setColor(Color.WHITE);
		g2.drawRect(x + 105, y + 117, 65, 25);
		g2.setColor(borderColor);
		g2.fillRect(x + 105, y + 117, 65, 25);
		ImageIcon levelPic = new ImageIcon(loader.fetchImage("level").getScaledInstance(20, 20,
				Image.SCALE_SMOOTH));
		g.drawImage(levelPic.getImage(), x + 110, y + 120, null);
		g.setColor(stringColor);
		g.drawString(Integer.toString(player.getCharacter().getLevel()),
				x + 140, y + 135);


		g2.setColor(Color.black);

		g2.setColor(stringColor);

		int len = player.getUsername().length();
		g2.setFont(new Font("Arial", Font.BOLD, 14));
		g2.drawString(player.getUsername(), x + (40 - len), y + 150);
		

	}

}
