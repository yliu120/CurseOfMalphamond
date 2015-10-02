package edu.jhu.cs.pl.group18.CurseOfMalphamondUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Position;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.Hand;

/**
 * This class paint the board of the game.
 * 
 * @author Yijie Li
 * @version 1.4
 * @since 1.4
 */
public class BoardPanel extends JPanel {

	public static final int BOARD_SIZE = 28;
	private ImageIcon boardIcon;
	private ImageLoader loader;
	private CurseOfMalphamondModelProxy model;
	private int currentPlayerID;
	private Position oldPosition;
	private Position currentCharacterPosition;
	private Position[] characterPositions;
	private boolean firstTimePaint;
	private CharacterSummary localSummary;
	private int value;
	private JProgressBar pbar;
	
	// TODO should be refactored
	private int diceNum;
	private boolean showGIF = false;
	private Thread timerThread;
	private SoundManager manager;
	private boolean timerOn = false;
	
	// TODO should be refactored - moveCharacter
	private int xProgress;
	private int yProgress;
	private ImageIcon characterPic;
	private ImageIcon diceIcon;
	private ImageIcon characterIcon;

	/**
	 * Constructor with a image loader and model proxy
	 * 
	 * @param loader
	 *            the only loader instantiate in the game to load image
	 * @param model
	 *            the model proxy that UI calls.
	 */
	public BoardPanel(final ImageLoader loader,
			final CurseOfMalphamondModelProxy model) {

		this.loader = loader;
		this.model = model;
		boardIcon = this.loader.fetchImageScaled("board");
		
		diceIcon = this.loader.fetchImageScaled("dice1");
	
		this.localSummary = new CharacterSummary(loader);
		this.firstTimePaint = true;
		currentPlayerID = 0;
		currentCharacterPosition = new Position(0);
		characterPositions = new Position[4];
		for (int i = 0; i < characterPositions.length; i++) {
			characterPositions[i] = new Position(0);
		}
		this.manager = new SoundManager();
		try {
			this.manager.initialize(10);
			this.manager.addSound("sound/dice.wav");  //0
			this.manager.addSound("sound/gainAttack.wav"); //1
			this.manager.addSound("music/game2.wav");  //2
			this.manager.addSound("music/drawCard.wav");  //3
			this.manager.addSound("music/attack4.wav");  //4
			this.manager.addSound("music/walk.wav");  //5
			this.manager.addSound("music/levelUP.wav");  //6
			this.manager.addSound("music/restoreHealth.wav");  //7
			this.manager.addSound("music/gainMaxHealth.wav");  //8
			this.manager.addSound("music/gainDefense.wav");  //9
			this.manager.addSound("music/winBattle.wav");  //10
			this.manager.addSound("music/battleFailed.wav");  //11
			this.manager.addSound("music/wrongAction.wav");  //12
			this.manager.addSound("music/winTheGame.wav");  //13
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		Thread t1 = new Thread() {
			public void run() {
				manager.playSound(2);
			}
		};
		t1.start();
		*/

		this.model.addListener(new ModelListener() {

			@Override
			public void diceRolled() {
				diceNum = model.getDiceNumber();
				
				String dicePicFile = "dice" + diceNum;
				diceIcon = loader.fetchImageScaled(dicePicFile);

				Thread t0 = new Thread() {
					public void run() {
						manager.playSound(5);
					}
				};
				t0.start();
				// This method should merely get the dice number. However,
				// at this moment, characterMove is automatically triggered, and
				// the character will move forward by the diceNum amount.
				// Later, we could add a field in the UI, and let the player
				// choose
				// how much to move. (i.e. diceNum + 1 or diceNum - 1)
				moveCharacter(diceNum);
				repaint( new Rectangle( 425, 400, 50 ,50 ));
			}

			@Override
			public void playerInfoChanged() {
				// TODO Auto-generated method stub

			}

			@Override
			public void playerAdded(Player player) {
				// TODO Auto-generated method stub

			}

			@Override
			public void playerRemoved(Player player) {
				// TODO Auto-generated method stub

			}

			@Override
			public void boardInfoChanged() {
				// TODO Auto-generated method stub

			}

			@Override
			public void currentActivePlayerChanged() {
				repaint();
				/*
				timerThread = new Thread() {
					public void run() {
						stopTimer();
						runTimer();
					}
				};
				timerThread.start();
				 */
			}

			@Override
			public void gameExceptionThrowed() {
				
			}

			@Override
			public void currentTileChanged() {
				// currentTile changed
			}

			@Override
			public void monsterAttacked(String s) {
				showGIF = true;
				/*
				 * new Timer().schedule(new TimerTask() { int counter = 0;
				 * 
				 * @Override public void run() { repaint(); repaint();
				 * counter++; if (counter == 480) { showGIF = false;
				 * this.cancel(); } } }, 0, 20);
				 */
				Thread t4 = new Thread() {
					public void run() {
						manager.playSound(4);
					}
				};
				t4.start();
			}

			@Override
			public void handChanged(Hand hand, String username) {
				Thread t3 = new Thread() {
					public void run() {
						manager.playSound(3);
					}
				};
				t3.start();

			}

			@Override
			public void canChallengeBoss(String result) {
				showGIF = true;
				/*
				 * new Timer().schedule(new TimerTask() { int counter = 0;
				 * 
				 * @Override public void run() { repaint(); repaint();
				 * counter++; if (counter == 480) { showGIF = false;
				 * this.cancel(); } } }, 0, 20);
				 */
			}

			@Override
			public void characterChanged(Character character, String username, String result) {
				currentCharacterPosition = model.getCurrentActivePlayer().getCharacter().getCurrentPosition();
				if (result == null) {
					Thread t5 = new Thread() {
						public void run() {
							manager.playSound(5);
						}
					};
					t5.start();
				} else {
					Thread t6 = new Thread() {
						public void run() {
							manager.playSound(6);
						}
					};
					t6.start();
				}
				
				for (int i = 0; i < characterPositions.length; i++) {
					if (model.getCurrentActivePlayer().equals(model.getPlayers().get(i))) {
						characterPositions[i] = currentCharacterPosition;
					}
				}
				repaint();
				//TODO check this out
				if (firstTimePaint) firstTimePaint = false;
				oldPosition = currentCharacterPosition;
				currentCharacterPosition = model.getCurrentActivePlayer()
						.getCharacter().getCurrentPosition();
				characterPic = loader.fetchImageScaled(model
						.getCurrentActivePlayer().getCharacter().getName());
				animate(model.getLocalPlayer(), oldPosition,
						currentCharacterPosition);
			}
		});
		
		
		/* Progress bar added.
		pbar = new JProgressBar();
	    pbar.setMinimum(0);
	    pbar.setMaximum(300);
	    pbar.setValue(300);
	    pbar.setOpaque(false);
	    pbar.setVisible(false);
	    add(pbar);
	    */
	}

	private void moveCharacter(int step) {
		model.moveCharacter(step);
	}

	/**
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		
		g.drawImage(boardIcon.getImage(), 50, 25, null);

		super.paintComponent(g);

		if (this.firstTimePaint) {
			//TODO this.firstTimePaint = false;
			for (int i = 0; i < this.model.getPlayers().size(); i++) {
				paintCharacter(g, i, new Position(0));
			}

			// Paint dice label on board corner
			paintDiceLabel(g, 1);
		} else {
			paintDiceLabel(g, this.diceNum);
			paintCurrentActivePlayer(g);
			for (int i = 0; i < this.model.getPlayers().size(); i++) {
				paintCharacter(g, i, characterPositions[i]);
			}
			
			//g.drawImage(characterPic.getImage(), xProgress, yProgress, null);
		}
		/*
		if (showGIF) {
			paintGIF(g);
		}
		*/
	}

	private void paintCharacter(Graphics g, int order, Position position) {
		CharacterSummary.paintSummary(g, this.model.getPlayers().get(order),
				position);
	}
	
	private void paintCurrentActivePlayer (Graphics g){
		String currentCharacterName = model
				.getCurrentActivePlayer().getCharacter().getName();
		
		String currentUsername = model.getCurrentActivePlayer().getUsername();
		
		BufferedImage currentPlayerImage = loader.fetchImage(currentCharacterName);
		characterIcon = new ImageIcon(currentPlayerImage.getScaledInstance(66,
				110, Image.SCALE_SMOOTH));
		g.drawImage(characterIcon.getImage(), 250, 230, null);
		g.setColor(Color.WHITE);
		g.drawString(currentUsername, 270, 350);
	}
	
	private void paintDiceLabel(Graphics g, Integer diceNumber) {

		g.drawImage(diceIcon.getImage(), 425, 400, null);

	}

	private void paintGIF(Graphics g) {
		FightSummary.paintSummary(g);
	}
	
	/**
     * Sets the value to the progress bar
     * @param value Value to set
     */
    public void setValue(java.lang.Integer value) {
        this.value = value;
    }

    /**
     * Action of the thread will be executed here. The value of the progress bar will be set here.
     */
    public void runTimer() {
    	pbar.setVisible(true);
    	for(int i = 300; i>= 0; i--){
            final int progress = i;
            SwingUtilities.invokeLater(new Runnable() {
               public void run() {
                  pbar.setValue(progress);
               }
            });
            try {
               Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
    	pbar.setVisible(false);
     }
    
    /**
     * Stop the timer
     */
    public void stopTimer(){
    	pbar.setVisible(false);
    	pbar.setValue(0);
    }
    
    /**
     * Animate a character from one position to another.
     * @param player The player who has the character
     * @param oldPos The old position
     * @param newPos The new position
     */
	public void animate(Player player, Position oldPos, Position newPos) {

		final int xStart = CharacterSummary.getBoardPositions().get(oldPos).xpos;
		final int xEnd = CharacterSummary.getBoardPositions().get(newPos).xpos;

		final int yStart = CharacterSummary.getBoardPositions().get(oldPos).ypos;
		final int yEnd = CharacterSummary.getBoardPositions().get(newPos).ypos;

		final int animationTime = 2000;
		final int framesPerSecond = 30;
		int framesCount = animationTime * framesPerSecond / 1000;

		while (framesCount > 0) {

			framesCount--;
			float progress = (float) framesCount / 60;
			xProgress = (int) ((xEnd - xStart) * (1 - progress) + xStart);
			yProgress = (int) ((yEnd - yStart) * (1 - progress) + yStart);

			try {
				Thread.sleep(10);
				//update( this.getGraphics() );
				update( this.getGraphics() );
				this.repaint();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#update(java.awt.Graphics)
	 */
	@Override
	public void update(Graphics g) {
		g.drawImage(characterPic.getImage(), xProgress, yProgress, this);
		g.dispose();
	}

	/**
	 * Get sound manager
	 * @return the manager
	 */
	public SoundManager getManager() {
		return manager;
	}

}