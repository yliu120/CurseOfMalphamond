package edu.jhu.cs.pl.group18.CurseOfMalphamondUI;


import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

/**
 * This class draw the progress bar
 * 
 * @author Yijie Li
 *
 */

public class GameTimer extends JPanel {

	JProgressBar pbar;

	static final int MY_MINIMUM = 0;

	static final int MY_MAXIMUM = 300;

	/**
	 * Constructor
	 */
	public GameTimer() {
		pbar = new JProgressBar();
		pbar.setMinimum(MY_MINIMUM);
		pbar.setMaximum(MY_MAXIMUM);
		add(pbar);

	}

	/**
	 * Start the game timer
	 * @throws InterruptedException
	 */
	public void start() throws InterruptedException {
		for (int i = MY_MAXIMUM; i >= MY_MINIMUM; i--) {
		    final int percent=i;
			try {
		         SwingUtilities.invokeLater(new Runnable() {
		             public void run() {
		               updateBar(percent);
		             }
		         });
		         java.lang.Thread.sleep(100);
		       } catch (InterruptedException e) {
		    	   ;
		       }
		} 
	}

	public void updateBar(int newValue) {
		pbar.setValue(newValue);
	}
}