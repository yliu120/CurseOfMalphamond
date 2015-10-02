/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondUI;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelImplListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.UseTimeType;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.Hand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.TileType;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;

/**
 * This class is used for painting the local player panel
 * 
 * @author Yijie Li
 * @version 1.4
 * @since 1.4
 */
public class LocalPlayerPanel extends JPanel {

	private ImageLoader loader;
	private CurseOfMalphamondModelProxy model;

	private DiceButton diceButton;
	private EndTurnButton endTurn;
	private PlayerSummary localPlayerSum;
	private JButton fightButton;
	private JButton nofightButton;
	private UseCardButton useCard;
	private DiscardCardButton discardCard;

	private Hand hand;
	private int handSize;
	private int rectSelect = -1;
	private final int CARD_WIDTH = 100;
	private final int CARD_HEIGHT = 130;

	/**
	 * Constructor with a image loader and model proxy
	 * 
	 * @param loader
	 *            the only loader instantiate in the game to load image
	 * @param model
	 *            the model proxy that UI calls.
	 */
	public LocalPlayerPanel(ImageLoader loader,
			final CurseOfMalphamondModelProxy model) {

		setLayout(new BorderLayout());

		this.loader = loader;
		this.model = model;

		// Add buttons
		this.diceButton = new DiceButton(this.loader, this.model);
		this.endTurn = new EndTurnButton(this.loader, this.model);
		this.useCard = new UseCardButton(this.loader, this.model);
		this.discardCard = new DiscardCardButton(this.loader, this.model);

		this.localPlayerSum = new PlayerSummary(this.loader);
		this.hand = this.model.getLocalPlayer().getHand();
		this.handSize = this.hand.getCards().size();

		this.fightButton = new JButton();
		this.nofightButton = new JButton();
		this.fightButton.setText("Fight");
		this.nofightButton.setText("Peace");

		fightButton.setEnabled(false);
		nofightButton.setEnabled(false);
		fightButton.setVisible(false);
		nofightButton.setVisible(false);

		useCard.setEnabled(false);
		discardCard.setEnabled(false);
		useCard.setVisible(false);
		discardCard.setVisible(false);

		// Set size for each sub component.
		this.diceButton.setPreferredSize(new Dimension(50, 50));
		this.endTurn.setPreferredSize(new Dimension(50, 50));
		this.fightButton.setPreferredSize(new Dimension(60, 50));
		this.nofightButton.setPreferredSize(new Dimension(60, 50));
		this.useCard.setPreferredSize(new Dimension(120, 50));
		this.discardCard.setPreferredSize(new Dimension(180, 50));

		// Set transparency
		this.diceButton.setOpaque(false);
		this.endTurn.setOpaque(false);
		this.fightButton.setOpaque(false);
		this.nofightButton.setOpaque(false);

		this.fightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fightButton.setEnabled(false);
				nofightButton.setEnabled(false);
				fightButton.setVisible(false);
				nofightButton.setVisible(false);
				model.fight();
				//System.out.println("Fight against Monster");
			}
		});

		this.nofightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fightButton.setEnabled(false);
				nofightButton.setEnabled(false);
				fightButton.setVisible(false);
				nofightButton.setVisible(false);
				//System.out.println("Choose not to fight.");
			}
		});

		this.endTurn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (model.getCurrentActivePlayer() != null) {

					model.endTurn();

					while (model.getLocalPlayer().equals(
							model.getCurrentActivePlayer())) {
						try {
							Thread.sleep(5);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

					fightButton.setVisible(false);
					nofightButton.setVisible(false);
					diceButton.setVisible(false);
					endTurn.setVisible(false);
					fightButton.setEnabled(false);
					nofightButton.setEnabled(false);
					diceButton.setEnabled(false);
					endTurn.setEnabled(false);

				}
			}

		});

		this.useCard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (rectSelect >= 0) {
					//System.out.println("UI: playing card!");
					model.playCard(rectSelect, 0);
					repaint();
				}
			}

		});

		JPanel buttonPanel1 = new JPanel();
		buttonPanel1.setPreferredSize(new Dimension(120, 240));
		buttonPanel1.setOpaque(false);
		buttonPanel1.setLayout(new BoxLayout(buttonPanel1, BoxLayout.Y_AXIS));

		buttonPanel1.add(diceButton);
		buttonPanel1.add(endTurn);
		useCard.setVisible(true);
		discardCard.setVisible(true);
		useCard.setFocusable(true);
		discardCard.setFocusable(true);

		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.setPreferredSize(new Dimension(150, 240));
		buttonPanel2.setOpaque(false);
		buttonPanel2.setLayout(new FlowLayout());
		buttonPanel2.add(fightButton);
		buttonPanel2.add(nofightButton);
		buttonPanel2.add(discardCard);
		buttonPanel2.add(useCard);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.add(buttonPanel1, BorderLayout.EAST);
		buttonPanel.add(buttonPanel2, BorderLayout.WEST);
		this.add(buttonPanel, BorderLayout.EAST);

		this.model.addListener(new ModelImplListener() {

			@Override
			public void diceRolled() {

			}

			@Override
			public void currentActivePlayerChanged() {

				if (model.getCurrentActivePlayer().equals(
						model.getLocalPlayer())) {
					diceButton.setVisible(true);
					endTurn.setVisible(true);
					diceButton.setEnabled(true);
					endTurn.setEnabled(true);
					useCard.setEnabled(true);
					discardCard.setEnabled(true);
				}

				repaint();

			}

			@Override
			public void gameExceptionThrowed() {
				// TODO Auto-generated method stub
			}

			@Override
			public void currentTileChanged() {
				if ((model.getCurrentActivePlayer().equals(
						model.getLocalPlayer())) && (model.getCurrentTile().getTileType()
						.equals(TileType.MonsterTile))) {
					fightButton.setEnabled(true);
					nofightButton.setEnabled(true);
					fightButton.setVisible(true);
					nofightButton.setVisible(true);
				}
				// TODO Refactor this shit
				if (model.getCurrentTile().getTileType()
						.equals(TileType.ActionTile)) {
					model.actionTileAct();
				}
				if (model.getCurrentTile().getTileType()
						.equals(TileType.ResourceTile)) {
					model.resourceTileAct();
				}
			}

			@Override
			public void monsterAttacked(String result) {
				repaint();
			}

			@Override
			public void handChanged(Hand hand, String username) {
				hand = model.getLocalPlayer().getHand();
				handSize = hand.getNumCards();
				// System.out.println("hand has :" + hand.getNumCards());
				repaint();
			}

			@Override
			public void canChallengeBoss(String result) {
				repaint();
			}

			@Override
			public void characterChanged(Character character, String username, String result) {
				repaint();
			}
		});

		this.addMouseListener(new MouseAdapter() {

			/**
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
			 */
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getY() > 30 && e.getY() < 160) {

					int x = e.getX();
					int pos = (x - 200) / 100;
					if (pos <= handSize && ((x - 200) % 100 < 90)) {
						rectSelect = pos;
						repaint();
					}

				}
			}

		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, getWidth(), 1);
		g.setColor(getForeground());
		super.paintComponent(g);
		// if (this.model.getPlayers().size() == 4) {
		// System.out.println("attack is:::::: " +
		// this.model.getCurrentActivePlayer().getCharacter().getAttack());
		// System.out.println("Hand(active player): " +
		// this.model.getCurrentActivePlayer().getHand().getNumCards());
		// }

		PlayerSummary.paintSummary(g, this.model.getLocalPlayer(), -1);
		// System.out.println("Hand(local player): " +
		// this.model.getLocalPlayer().getHand().getNumCards());

		if (this.model.getLocalPlayer().getHand().getNumCards() > 0) {
			this.paintHand(g, this.model.getLocalPlayer().getHand());
		}
	}

	private void paintHand(Graphics g, Hand hand) {

		int cardsPainted = 0;

		for (Card card : hand.getCards()) {
			//System.out.println(card.getName());
			ImageIcon cardPic = new ImageIcon(this.loader.fetchImage(
					card.getName().replace(" ", "")).getScaledInstance(
					CARD_WIDTH, CARD_HEIGHT, Image.SCALE_SMOOTH));
			g.drawImage(cardPic.getImage(), 200 + CARD_WIDTH * cardsPainted,
					30, null);

			if (cardsPainted == rectSelect) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(4));
				g2.setColor(Color.pink);
				g2.drawRect(202 + CARD_WIDTH * cardsPainted, 32, 96, 124);
			}

			cardsPainted++;
		}

	}

}
