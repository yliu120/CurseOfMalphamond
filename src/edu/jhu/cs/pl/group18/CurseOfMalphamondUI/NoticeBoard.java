/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.Hand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.Tile;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.TileType;

/**
 * This is the notice board that tells the users what events happened in the game.
 * @author Yijie Li
 *
 */
public class NoticeBoard extends JPanel {

	private ImageLoader loader;
	private CurseOfMalphamondModelProxy model;

	private Color boardColor = new Color(224, 255, 255);
	private BufferedImage history;
	private String currentPlayer;

	private String textString = "Welcome to the Curse of Malphamond!\n";


	/**
	 * Constructor for drawing the NoticeBoard
	 * 
	 * @param loader
	 *            The image loader
	 * @param model
	 *            The model proxy
	 */
	public NoticeBoard(ImageLoader loader, final CurseOfMalphamondModelProxy model) {

		super();
		this.loader = loader;
		this.model = model;
		
		
		this.history = this.loader.fetchImage("history");
		this.setLayout(new BorderLayout());
		Border border = BorderFactory.createEtchedBorder(Color.darkGray, Color.GRAY);
		
		JTextPane historyMess = new JTextPane();
	    StyledDocument doc = historyMess.getStyledDocument();
	    Style style = historyMess.addStyle("White", null);
	    StyleConstants.setForeground(style, Color.WHITE);

	    try {
			doc.insertString(0, textString, style);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//This label is just for occupying space
		JLabel emptyNorth = new JLabel();
		emptyNorth.setPreferredSize(new Dimension(200,100));
		emptyNorth.setOpaque(false);
		
		JLabel emptyWest = new JLabel();
		emptyWest.setPreferredSize(new Dimension(35, 300));
		emptyWest.setOpaque(false);
		
		JLabel emptyEast = new JLabel();
		emptyEast.setPreferredSize(new Dimension(35, 300));
		emptyEast.setOpaque(false);
		
		JLabel emptySouth = new JLabel();
		emptySouth.setPreferredSize(new Dimension(200, 50));
		emptySouth.setOpaque(false);
		
		historyMess.setPreferredSize(new Dimension(200, 350));
		historyMess.setOpaque(true);
		historyMess.setBackground(Color.BLACK);
		historyMess.setEditable(false);


		JScrollPane scroll = new JScrollPane(historyMess,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setOpaque(false);
		scroll.setPreferredSize(new Dimension(200,350));

		this.add(emptyNorth, BorderLayout.NORTH);
		this.add(emptyWest, BorderLayout.WEST);
		this.add(emptyEast, BorderLayout.EAST);
		this.add(emptySouth, BorderLayout.SOUTH);
		this.add(scroll, BorderLayout.CENTER);
		
		this.setVisible(true);
		
		
		//Update notice board.
		this.model.addListener(new ModelListener() {

			@Override
			public void playerInfoChanged() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void playerAdded(Player player) {
				updateNoticeBoard(player.getUsername() + " joined the game!\n");
				repaint();
			}

			@Override
			public void playerRemoved(Player player) {
				updateNoticeBoard(player.getUsername() + " left the game!\n");
				repaint();
			}

			@Override
			public void diceRolled() {
				updateNoticeBoard("Dice Rolled: number is " + model.getDiceNumber() + "!\n");
				repaint();
			}

			@Override
			public void boardInfoChanged() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void currentActivePlayerChanged() {
				currentPlayer = model.getCurrentActivePlayer().getUsername();
				updateNoticeBoard(currentPlayer + "'s turn starts!" + "\n" + "\n");
				repaint();
								
			}

			@Override
			public void gameExceptionThrowed() {
				
			}

			@Override
			public void currentTileChanged() {
				currentPlayer = model.getCurrentActivePlayer().getUsername();
				updateNoticeBoard(currentPlayer + " Moved to Tile: " + model.getCurrentTile().getDescription() + "!\n");
				repaint();
			}

			@Override
			public void monsterAttacked(String result) {
				updateNoticeBoard(result);
				repaint();
			}

			@Override
			public void handChanged(Hand hand, String username) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void canChallengeBoss(String result) {
				updateNoticeBoard(result);
				repaint();
			}

			@Override
			public void characterChanged(Character character, String username, String result) {
				if (result == null) {
					currentPlayer = model.getCurrentActivePlayer().getUsername();
					updateNoticeBoard(currentPlayer + " Moved: to position " + model.getCurrentActivePlayer().getCharacter().getCurrentPosition().getTilePosition() + "!\n");
				} else {
					updateNoticeBoard(result);
				}
				repaint();
			}
			
		});

	}

	/**
	 * paint Background
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		ImageIcon boardPic = new ImageIcon(this.history.getScaledInstance(250, 500,
				Image.SCALE_SMOOTH));
		g.drawImage(boardPic.getImage(), 25, 25, null);

	}

	/**
	 * Update the notice board
	 * @param s The message that is about to be updated.
	 */
	public void updateNoticeBoard(String s) {
		JScrollPane scroll = (JScrollPane) ((BorderLayout)this.getLayout()).getLayoutComponent(BorderLayout.CENTER);
		JTextPane historyMess = (JTextPane) scroll.getViewport().getView();
	    StyledDocument doc = historyMess.getStyledDocument();
	    try {
			doc.insertString(0, s, historyMess.getStyle("White"));
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
