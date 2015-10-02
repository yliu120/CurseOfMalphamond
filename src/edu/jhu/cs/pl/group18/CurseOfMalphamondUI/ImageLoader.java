/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondUI;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * This class helps load images to buffer. String to image maps
 * 
 * @author Yunlong
 * @version 1.4
 * @since 1.4
 */
public class ImageLoader {

	public static final ImageLoader SINGLETON = new ImageLoader();

	/*
	 * Fields
	 */
	private Map<String, BufferedImage> images;
	private Map<String, ImageIcon> boardImages;

	/**
	 * Call this function outside of the class to fetch the require buffered
	 * image. Use this function like: image = ImageLoader.SINGLETON.fetchImage(
	 * character.getName() );
	 * 
	 * @param imageName
	 *            the image name in String
	 * @return the corresponding buffer image
	 */
	public BufferedImage fetchImage(String imageName) {

		return this.images.get(imageName);

	}
	
	/**
	 * Call this function outside of the class to fetch the require buffered
	 * image. Use this function like: image = ImageLoader.SINGLETON.fetchImage(
	 * character.getName() );
	 * 
	 * @param imageName
	 *            the image name in String
	 * @return the corresponding buffer image
	 */
	public ImageIcon fetchImageScaled(String imageName) {

		return this.boardImages.get(imageName);

	}

	/**
	 * Private Constructor following the SINGLETON pattern.
	 */
	private ImageLoader() {

		images = new HashMap<>();
		boardImages = new HashMap<>();
		this.load("board", "");
		this.load("background", "");
		this.load("Berserker", "character");
		this.load("Demon", "character");
		this.load("Philosopher", "character");
		this.load("Priest", "character");
		this.load("RoyalGuard", "character");
		this.load("Scout", "character");
		this.load("Mage", "character");
		this.load("attack", "character");
		this.load("defense", "character");
		this.load("maxHealth", "character");
		this.load("level", "character");
		this.load("cardnumber", "character");
		
		// Load dice picture
		this.load("dice1", "dice");
		this.load("dice2", "dice");
		this.load("dice3", "dice");
		this.load("dice4", "dice");
		this.load("dice5", "dice");
		this.load("dice6", "dice");
		
		// Load Button
		this.load("dice", "");
		this.load("endturn", "");
		this.load("useCard", "");
		this.load("discardCard", "");
		
		// Load Panel Background
		this.load("GameOngoing", "");
		this.load("history", "");
		
		// Load cards
		this.load("Deceive", "card/BasicCard");
		this.load("GrandMarch", "card/BasicCard");
		this.load("GrandRetreat", "card/BasicCard");
		this.load("HealthPotion", "card/BasicCard");
		this.load("Hustle", "card/BasicCard");
		this.load("Marathon", "card/BasicCard");
		this.load("March", "card/BasicCard");
		this.load("moveBack3", "card/BasicCard");
		this.load("moveBack4", "card/BasicCard");
		this.load("moveBack6", "card/BasicCard");
		this.load("moveFor5", "card/BasicCard");
		this.load("Reroll", "card/BasicCard");
		this.load("restoreHealth", "card/BasicCard");
		this.load("Retreat", "card/BasicCard");
		this.load("Slash", "card/BasicCard");
		
		this.load("Duplicate", "card/CharacterCard");
		this.load("Meditate", "card/CharacterCard");
		this.load("Nightmare", "card/CharacterCard");
		this.load("Prayer", "card/CharacterCard");
		this.load("SeismicSlam", "card/CharacterCard");
		this.load("ShieldToss", "card/CharacterCard");
		this.load("Sprint", "card/CharacterCard");

		this.load("Bommerang", "card/ResourceCard");
		this.load("Courage", "card/ResourceCard");
		this.load("Fortitude", "card/ResourceCard");
		this.load("GreatCourage", "card/ResourceCard");
		this.load("GreatFortitude", "card/ResourceCard");
		this.load("LighteningBolt", "card/ResourceCard");
		this.load("Longevity", "card/ResourceCard");
		this.load("moveForX", "card/ResourceCard");
		this.load("Panacea", "card/ResourceCard");
		this.load("PhysicalTraining", "card/ResourceCard");
		this.load("stealCard", "card/ResourceCard");
		this.load("stopAll", "card/ResourceCard");
		
		this.load("board", "", 500, 500);
		this.load("dice1", "dice", 50, 50);
		this.load("dice2", "dice", 50, 50);
		this.load("dice3", "dice", 50, 50);
		this.load("dice4", "dice", 50, 50);
		this.load("dice5", "dice", 50, 50);
		this.load("dice6", "dice", 50, 50);
		this.load("Berserker", "character", 33, 55);
		this.load("Demon", "character", 33, 55);
		this.load("Philosopher", "character", 33, 55);
		this.load("Priest", "character", 33, 55);
		this.load("RoyalGuard", "character", 33, 55);
		this.load("Scout", "character", 33, 55);
		this.load("Mage", "character", 33, 55);
		
	}

	/**
	 * load picture
	 * @param imgStr   name of the pictures
	 * @param type  location of the pictures
	 */
	private void load(String imgStr, String type) {
		BufferedImage img;
		if (type.equals("")) {
			img = this.loadImage("image" + File.separator + imgStr + ".png");
		}
		else {
			img = this.loadImage("image" + File.separator
				+ type + File.separator + imgStr + ".png");
		}
		images.put(imgStr, img);
	}
	
	/**
	 * load picture
	 * @param imgStr   name of the pictures
	 * @param type  location of the pictures
	 */
	private void load(String imgStr, String type, int scaledX, int scaledY ) {
		
		BufferedImage img;
		if (type.equals("")) {
			img = this.loadImage("image" + File.separator + imgStr + ".png");
		}
		else {
			img = this.loadImage("image" + File.separator
				+ type + File.separator + imgStr + ".png");
		}
		
		ImageIcon imgScaled = new ImageIcon(img.getScaledInstance( scaledX,
				scaledY, Image.SCALE_SMOOTH));
		
		boardImages.put(imgStr, imgScaled);
		
	}
	
	/**
	 * Load a buffered image
	 * @param filename   Name of the image to be drawn
	 * @return BufferedImage  
	 */
	private BufferedImage loadImage(String filename) {
		try {
			return ImageIO.read(new File(filename));
		} catch (IOException e) {
			//System.out.println("Image Loader - image: " + filename
			//		+ " not found.");
			return null;
		}
	}

}
