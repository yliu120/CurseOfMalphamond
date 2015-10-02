package edu.jhu.cs.pl.group18.CurseOfMalphamondUI;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
/**
 * @author Yijie
 * This class draws a single card panel.
 */

public class CardUI extends JPanel {
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @param string The name of the card
	 */
	public CardUI(String string) {
		setBackground(UIManager.getColor("ToolTip.background"));

		BufferedImage cardPicBig = null;
		try {
			cardPicBig = ImageIO.read(new File("image/card/" + string + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Image cardPic = cardPicBig.getScaledInstance(75, 100, Image.SCALE_SMOOTH);
		JLabel card = new JLabel("");
		card.setBounds(0, 0, 100, 130);
		card.setIcon(new ImageIcon(cardPic));

		setLayout(null);
		add(card);
		card.setVisible(true);

	}

}
