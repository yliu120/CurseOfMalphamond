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
 * This class draw the end turn button
 * 
 * @author Yijie LI
 *
 */
public class EndTurnButton extends JButton {
	
	private ImageLoader loader;
	private CurseOfMalphamondModelProxy model;
	
	private BufferedImage endTurn;
	
	/**
	 * Constructor with UI routine input parameter
	 * @param loader the imageloader
	 * @param model the model proxy on the client side
	 */
	public EndTurnButton(ImageLoader loader, CurseOfMalphamondModelProxy model) {
		super();
		this.loader = loader;
		this.model = model;
		
		this.endTurn = this.loader.fetchImage("endturn");
		this.setIcon(new ImageIcon(this.endTurn));
		
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
		//Image endTurnPic = this.endTurn.getScaledInstance(50, 50,
		//		Image.SCALE_SMOOTH);
		// g.drawImage(endTurnPic, 15, 15, null);
		
	}

}
