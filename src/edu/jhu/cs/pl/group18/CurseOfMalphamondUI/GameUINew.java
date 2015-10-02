/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;

/**
 * This class organize the game window which contains local player panel,
 * other player panel, board panel and notice board panel.
 * @author Yijie Li
 */
public class GameUINew extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private LocalPlayerPanel localPlayer;
	private OtherPlayerPanel otherPlayers;
	private BoardPanel boardPanel;
	private NoticeBoard noticeBoard;
	
	private CurseOfMalphamondModelProxy model;
	
	private ImageLoader loader;
	/**
	 * Constructor
	 * @param model  Game model
	 * @param loader  Image loader
	 */
	public GameUINew ( final CurseOfMalphamondModelProxy model, ImageLoader loader ) {
		
		this.model = model;
		this.loader = loader;
		this.setTitle("Curse Of Malphamond");
		
		localPlayer = new LocalPlayerPanel( this.loader, this.model );
		otherPlayers = new OtherPlayerPanel( this.loader, this.model );
		boardPanel = new BoardPanel( this.loader, this.model );
		noticeBoard = new NoticeBoard( this.loader, this.model );
		this.setContentPane(new ContentPane(loader));
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		localPlayer.setPreferredSize(new Dimension(1100,190));
		otherPlayers.setPreferredSize(new Dimension(200, 530));
		boardPanel.setPreferredSize(new Dimension(600,530));
		noticeBoard.setPreferredSize(new Dimension(300, 530));
		
		// Set everything transparent
		boardPanel.setOpaque(false);
		otherPlayers.setOpaque(false);
		localPlayer.setOpaque(false);
		noticeBoard.setOpaque(false);
		
		this.getContentPane().setLayout( new BorderLayout() );
		this.getContentPane().add(boardPanel, BorderLayout.CENTER);
		this.getContentPane().add(otherPlayers, BorderLayout.WEST);
		this.getContentPane().add(localPlayer, BorderLayout.SOUTH);
		this.getContentPane().add(noticeBoard, BorderLayout.EAST);
		
		// This is a game with a fixed size board.
		this.setResizable(false);
		this.setSize(new Dimension(1100,740));
		this.pack();
		
		this.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				model.getMessenger().stopConnection();
				boardPanel.getManager().destroy();
			}
			
		});
		
	}
	
}
