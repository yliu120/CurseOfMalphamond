/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondUI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;

/**
 * This class draw the discard card button
 * @author Yijie
 *
 */
public class DiscardCardButton extends JButton {
	
	private ImageLoader loader;
	private CurseOfMalphamondModelProxy model;
	
	private BufferedImage discardCard;
	
	/**
	 * Constructor with UI routine input parameter
	 * @param loader the imageloader
	 * @param model the model proxy on the client side
	 */
	public DiscardCardButton(ImageLoader loader, CurseOfMalphamondModelProxy model) {
		super();
		this.loader = loader;
		this.model = model;
		
		this.discardCard = this.loader.fetchImage("discardCard");
		this.setIcon(new ImageIcon(this.discardCard));
		
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setContentAreaFilled(false);
	}
	
	/**
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		// TODO modelListener need to be added.
	}

}
