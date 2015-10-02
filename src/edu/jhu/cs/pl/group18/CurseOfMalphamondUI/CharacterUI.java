package edu.jhu.cs.pl.group18.CurseOfMalphamondUI;

import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.image.BufferedImage;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;

/**
 * This class for drawing the Character component in the choose your character window
 * @author Yijie Li
 * @version 1.3
 * @since 1.3
 */
public class CharacterUI extends JPanel {

	private String characterDescriptionText;
	private final String name;
	private String userNameText = "";
	private Integer health;
	private Integer attack;
	private Integer defense;
	private Integer level;
	private Integer cardNumber;
	private Font descriptionFont = new Font("Arial", Font.BOLD, 10);
	Border border = BorderFactory.createLineBorder(Color.BLACK);
	private static final long serialVersionUID = 1L;
	

	/**
	 * Create the panel.
	 * @param character The character chosen
	 * @param username The username of the player
	 * @throws IOException 
	 */
	public CharacterUI(Character character, String username) throws IOException {
		super();
		setBackground(new Color(224, 255, 255));
		this.characterDescriptionText = character.getDescription();
		this.attack = character.getAttack();
		this.health = character.getHealth();
		this.defense = character.getDefense();
		this.name = character.getName();
		//this.cardNumber = charcter.getCardNumber;
		this.level = 1;
		this.userNameText = username;
	
		JTextPane characterDescription = new JTextPane();
		characterDescription.setBounds(6, 180, 160, 40);
		//characterDescriptionText = "\n" + "  +1 maximum health per level";
		characterDescription.setText(characterDescriptionText);
		SetTextStyle(characterDescription);
		characterDescription.setBackground(new Color(230, 230, 250));
		characterDescription.setBorder(border);
		add(characterDescription);
		
		JTextPane characterName = new JTextPane();
		characterName.setBounds(35 - name.length()/2, 16, 65, 20);
		//name = "Priest ";
		characterName.setText(name);
		SetTextStyle(characterName);
		characterName.setBackground(new Color(224, 255, 255));
		add(characterName);


		//JTextPane userName = new JTextPane();
		//userName.setBounds(20, 160, 100, 18);
		//userName.setText("User:" + " " + userNameText);
		//SetTextStyle(userName);
		//userName.setBackground(new Color(224, 255, 255));
		//add(userName);	

		JTextPane healthPane = new JTextPane();
		healthPane.setBackground(new Color(230, 230, 250));
		healthPane.setBounds(100, 30, 65, 20);
		healthPane.setBorder(border);
		//this.health = 20;
		healthPane.setText("Health     " + health.toString());
		SetTextStyle(healthPane);
		add(healthPane);	
		
		
		
		JTextPane attackPane = new JTextPane();
		attackPane.setBackground(new Color(230, 230, 250));
		attackPane.setBounds(100, 55, 65, 20);
		attackPane.setBorder(border);
		attackPane.setText("Attack      " + attack.toString());
		SetTextStyle(attackPane);
		add(attackPane);	

		JTextPane defensePane = new JTextPane();
		defensePane.setBackground(new Color(230, 230, 250));
		defensePane.setBounds(100, 80, 65, 20);
		defensePane.setBorder(border);
		defensePane.setText("Defense   " + defense.toString());
		SetTextStyle(defensePane);
		add(defensePane);

		JTextPane levelPane = new JTextPane();
		levelPane.setBackground(new Color(230, 230, 250));
		levelPane.setBounds(100, 105, 65, 20);
		levelPane.setBorder(border);
		//this.level = 1;
		levelPane.setText("Level        " + level.toString());
		SetTextStyle(levelPane);
		add(levelPane);
		
		JTextPane cardPane = new JTextPane();
		cardPane.setBackground(new Color(230, 230, 250));
		cardPane.setBounds(100, 130, 65, 20);
		cardPane.setBorder(border);
		this.cardNumber = 3;
		cardPane.setText("Card #      " + cardNumber.toString());
		SetTextStyle(cardPane);
		add(cardPane);
		
		JLabel characterPic = new JLabel("");
		characterPic.setBounds(15, 35, 70, 120);
		BufferedImage characterImage = null;
		try {
			characterImage = ImageIO.read(new File("image/character/" + name + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Image characterPicture = characterImage.getScaledInstance(70, 120, Image.SCALE_SMOOTH);
		characterPic.setIcon(new ImageIcon(characterPicture));

		characterPic.setVisible(true);
		setLayout(null);
		add(characterPic);
		

	}
	
	private void SetTextStyle(JTextPane text){
		text.setFont(descriptionFont);
		text.setEditable(false);
	}

}
