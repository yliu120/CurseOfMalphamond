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
 * @author Yijie
 * This class draw a used card button
 */
public class UseCardButton extends JButton {
	
	private ImageLoader loader;
	private CurseOfMalphamondModelProxy model;
	
	private BufferedImage useCard;
	
	/**
	 * Constructor with UI routine input parameter
	 * @param loader the imageloader
	 * @param model the model proxy on the client side
	 */
	public UseCardButton(ImageLoader loader, CurseOfMalphamondModelProxy model) {
		super();
		this.loader = loader;
		this.model = model;
		
		this.useCard = this.loader.fetchImage("useCard");
		this.setIcon(new ImageIcon(this.useCard));
		
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
