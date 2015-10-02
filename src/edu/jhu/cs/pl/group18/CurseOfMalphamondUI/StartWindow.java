package edu.jhu.cs.pl.group18.CurseOfMalphamondUI;

import static java.awt.event.KeyEvent.VK_ENTER;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;

/**
 * @author Yijie 
 * This is the panel showing up that when the game application is opened, 
 * where you can enter username.
 */
public class StartWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userNameInput;

	/**
	 * Create the frame.
	 * @throws IOException
	 */
	public StartWindow()
			throws IOException {

		//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Curse of Malphamond");
		JLabel startPagePanel = new JLabel(new ImageIcon(ImageIO.read(new File(
				"image/logo.png"))));
		startPagePanel.setBounds(100, 0, 500, 350);
		
		//add ready to join button
		JButton readyToJoin = new JButton("Ready to Join");
		readyToJoin.setFont(new Font("Arial", 1, 24));
		readyToJoin.setBounds(350, 400, 200, 60);
		readyToJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = userNameInput.getText();
				if (!username.isEmpty()) {


					dispose();
					ChooseCharacterUI chooseCharacter = null;
					try {
						chooseCharacter = new ChooseCharacterUI(username);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					chooseCharacter.setVisible(true);

				}
			}
		});
		
		// Text field where you can enter the user name.
		userNameInput = new JTextField();
		Font customFont = null;
		try {
			InputStream myStream = new BufferedInputStream(new FileInputStream(
					"image/FFFTusj.ttf"));
			customFont = Font.createFont(Font.TRUETYPE_FONT, myStream)
					.deriveFont(24f);
		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		ge.registerFont(customFont);
		userNameInput.setFont(customFont);
		userNameInput.setBounds(400, 330, 145, 50);
		userNameInput.setColumns(10);

		JTextArea userName = new JTextArea();
		userName.setForeground(Color.orange);
		userName.setFont(customFont);
		userName.setText("Username:");
		userName.setBounds(250, 340, 134, 31);
		userName.setEditable(false);
		userName.setOpaque(false);

		this.setPreferredSize(new Dimension(700, 550));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setExtendedState(JFrame.NORMAL);
		JLabel background = new JLabel("");
		BufferedImage backImage = null;
		try {
			backImage = ImageIO.read(new File("image/background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Image backPic = backImage.getScaledInstance(700, 550, Image.SCALE_SMOOTH);
		background.setIcon(new ImageIcon(backPic));
		background.setVisible(true);
		setLayout(null);
		background.setOpaque(false);
		this.setContentPane(background);
		this.getContentPane().add(readyToJoin);
		this.getContentPane().add(userNameInput);
		this.getContentPane().add(userName);
		this.getContentPane().add(startPagePanel);
		this.pack();
		this.setVisible(true);

		userNameInput.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == VK_ENTER) {

					String username = userNameInput.getText();
					if (!username.isEmpty()) {


						dispose();
						ChooseCharacterUI chooseCharacter = null;
						try {
							chooseCharacter = new ChooseCharacterUI(username);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						chooseCharacter.setVisible(true);

					}
				}
			}
		});

	}
}
