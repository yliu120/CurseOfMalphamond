/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;

/**
 * This class draws a dice button
 * @author Yijie Li
 * @version 1.4
 * @since 1.4
 */
public class DiceButton extends JButton {
	
	private ImageLoader loader;
	private CurseOfMalphamondModelProxy model;
	private BufferedImage diceButton;
	
	/**
	 * Constructor with UI routine input parameter
	 * @param loader the imageloader
	 * @param model the model proxy on the client side
	 */
	public DiceButton ( ImageLoader loader,final CurseOfMalphamondModelProxy model) {
		
		super();
		this.loader = loader;
		this.model = model;
		
		this.diceButton = this.loader.fetchImage("dice");
		
		this.setIcon(new ImageIcon(this.diceButton));
		
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setFocusPainted(true);
		this.setFocusable(true);
		this.setContentAreaFilled(false);
		
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.rollDice();
				setEnabled( false );
			}
		});
		
	}

	/**
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
	}
	
	

}
