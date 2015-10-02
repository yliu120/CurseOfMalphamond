/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * This class draw the background of all the windows.
 * @author Yijie 
 *
 */
public class ContentPane extends JPanel {
	
	private BufferedImage background;
	private ImageLoader loader;
	
	/**
	 * Constructor with a image loader parameter.
	 * @param loader The image loader
	 */
	public ContentPane( ImageLoader loader ){ 
		
		setOpaque(false);
		this.loader = loader;
		this.background = loader.fetchImage("background");
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		ImageIcon backgroundIcon = new ImageIcon(this.background.getScaledInstance(1100, 740,
				Image.SCALE_SMOOTH));
		g.drawImage(backgroundIcon.getImage(), 0, 0, this);
		
	}
	
}
