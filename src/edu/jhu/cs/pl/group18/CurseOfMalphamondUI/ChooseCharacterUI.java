package edu.jhu.cs.pl.group18.CurseOfMalphamondUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterBerserker;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterDemon;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterMage;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterPhilosopher;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterPriest;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterRoyalGuard;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterScout;

/**
 * This class draws the ChooseCharacter frame.
 * @author Yijie Li
 * @version 1.3
 * @since 1.3
 */
public class ChooseCharacterUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private Border border = BorderFactory.createLineBorder(Color.BLACK);
	private Map<String, Character> mapCharacter = new HashMap<>();
	private static final int MY_MINIMUM = 0;
	private static final int MY_MAXIMUM = 300;
	
	/**
	 * The constructor works for constructing the frame
	 * @param username The username of the player
	 * @throws IOException 
	 */
	public ChooseCharacterUI(final String username ) throws IOException {
		
		setTitle("Curse of Malphamond");
		
		JLabel background = new JLabel("");
		BufferedImage backImage = null;
		try {
			backImage = ImageIO.read(new File("image/background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Image backPic = backImage.getScaledInstance(1000, 750, Image.SCALE_SMOOTH);
		background.setIcon(new ImageIcon(backPic));
		background.setVisible(true);
		setLayout(null);
		background.setOpaque(false);
		this.setContentPane(background);
		
		//add berserker
		Character berserker = new CharacterBerserker();
		mapCharacter.put(berserker.getName(), berserker);
		getContentPane().setLayout(null);
		CharacterUI berserkerUI = new CharacterUI(berserker, "");
		berserkerUI.setBounds(10, 50, 175, 235);
		berserkerUI.setBorder(border);
		berserkerUI.setPreferredSize(getPreferredSize());
		this.getContentPane().add(berserkerUI);
		
		//add royalGuard
		Character royalGuard = new CharacterRoyalGuard();
		mapCharacter.put(royalGuard.getName(), royalGuard );
		CharacterUI royalGuardUI = new CharacterUI(royalGuard, "");
		royalGuardUI.setBounds(260, 50, 175, 235);
		royalGuardUI.setBorder(border);
		royalGuardUI.setPreferredSize(getPreferredSize());
		this.getContentPane().add(royalGuardUI);

		//add priest
		Character priest = new CharacterPriest();
		mapCharacter.put(priest.getName(), priest );
		CharacterUI priestUI = new CharacterUI(priest, "");
		priestUI.setBounds(510, 50, 175, 235);
		priestUI.setBorder(border);
		priestUI.setPreferredSize(getPreferredSize());
		this.getContentPane().add(priestUI);
		
		//add demon
		Character demon = new CharacterDemon();
		mapCharacter.put(demon.getName(), demon);
		CharacterUI demonUI = new CharacterUI(demon, "");
		demonUI.setBounds(760, 50, 175, 235);
		demonUI.setBorder(border);
		demonUI.setPreferredSize(getPreferredSize());
		this.getContentPane().add(demonUI);
		
		//add mage
		Character mage = new CharacterMage();
		mapCharacter.put(mage.getName(), mage);
		CharacterUI mageUI = new CharacterUI(mage, "");
		mageUI.setBounds(10, 380, 175, 235);
		mageUI.setBorder(border);
		mageUI.setPreferredSize(getPreferredSize());
		this.getContentPane().add(mageUI);
		
		
		//add philosopher
		Character philosopher = new CharacterPhilosopher();
		mapCharacter.put(philosopher.getName(), philosopher);
		CharacterUI philosopherUI = new CharacterUI(philosopher,"");
		philosopherUI.setBounds(260, 380, 175, 235);
		philosopherUI.setBorder(border);
		philosopherUI.setPreferredSize(getPreferredSize());
		this.getContentPane().add(philosopherUI);
		
		//add philosopher
		Character scout = new CharacterScout();
		mapCharacter.put(scout.getName(), scout);
		CharacterUI scoutUI = new CharacterUI(scout,"");
		scoutUI.setBounds(510, 380, 175, 235);
		scoutUI.setBorder(border);
		scoutUI.setPreferredSize(getPreferredSize());
		this.getContentPane().add(scoutUI);
		
		JRadioButton radioButton1 = new JRadioButton("");
		radioButton1.setBounds(80, 300, 97, 23);
		radioButton1.setActionCommand( berserker.getName() );
		radioButton1.setSelected(true);
		getContentPane().add(radioButton1);
		
		JRadioButton radioButton2 = new JRadioButton("");
		radioButton2.setBounds(330, 300, 97, 23);
		radioButton2.setActionCommand( royalGuard.getName() );
		getContentPane().add(radioButton2);
		
		JRadioButton radioButton3 = new JRadioButton("");
		radioButton3.setBounds(580, 300, 97, 23);
		radioButton3.setActionCommand( priest.getName() );
		getContentPane().add(radioButton3);
		
		JRadioButton radioButton4 = new JRadioButton("");
		radioButton4.setActionCommand( demon.getName() );
		radioButton4.setBounds(830, 300, 97, 23);
		getContentPane().add(radioButton4);
		
		JRadioButton radioButton5 = new JRadioButton("");
		radioButton5.setActionCommand( mage.getName() );
		radioButton5.setBounds(80, 630, 97, 23);
		getContentPane().add(radioButton5);
		
		JRadioButton radioButton6 = new JRadioButton("");
		radioButton6.setBounds(330, 630, 97, 23);
		radioButton6.setActionCommand( philosopher.getName() );
		getContentPane().add(radioButton6);
		
		JRadioButton radioButton7 = new JRadioButton("");
		radioButton7.setActionCommand( scout.getName() );
		radioButton7.setBounds(580, 630, 97, 23);
		getContentPane().add(radioButton7);
		
		final ButtonGroup characters = new ButtonGroup();
		characters.add(radioButton1);
		characters.add(radioButton2);
		characters.add(radioButton3);
		characters.add(radioButton4);
		characters.add(radioButton5);
		characters.add(radioButton6);
		characters.add(radioButton7);
		
	    JButton start = new JButton("Start");
	    start.setFont(new Font("Arial", 1, 24));
	    start.setBounds(750, 550, 200, 60);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedCharacter = characters.getSelection().getActionCommand();
				Player player = new Player();
				player.initialize(username, mapCharacter.get( selectedCharacter ) );
				
				CurseOfMalphamondModelProxy model = new CurseOfMalphamondModelProxy();
				
				model.setLocalPlayer( player );
				if ( !model.registerPlayer() ) {
					return;
				};
				dispose();
				
				ImageLoader loader = ImageLoader.SINGLETON;
				GameUINew board = new GameUINew( model, loader );
				board.setVisible(true);
			}
		});
		getContentPane().add(start);
		
		JTextPane chooseCharacter = new JTextPane();
		chooseCharacter.setForeground(Color.WHITE);
		chooseCharacter.setText("Choose Your Own Character");
		chooseCharacter.setBackground(UIManager.getColor("ToolTip.background"));
		chooseCharacter.setFont(new Font("Arial", 1, 24));
		chooseCharacter.setBounds(300, 6, 367, 32);
		chooseCharacter.setEditable(false);
		chooseCharacter.setOpaque(false);
		getContentPane().add(chooseCharacter);
	
	    this.setPreferredSize(new Dimension(1000,700));
	    //this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    this.pack();
	    this.setVisible(true);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
