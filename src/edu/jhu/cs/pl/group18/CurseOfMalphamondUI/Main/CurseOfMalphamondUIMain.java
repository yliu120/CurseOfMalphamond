/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondUI.Main;

import java.io.IOException;

import javax.swing.SwingUtilities;

import edu.jhu.cs.pl.group18.CurseOfMalphamondUI.StartWindow;

/**
 * This is the main program for the UI.
 * @author Yijie Li
 *
 */
public class CurseOfMalphamondUIMain {
	
	public static void main(String[] args) throws IOException {
		
		SwingUtilities.invokeLater(new Runnable() {
		      public void run() {
		    	  StartWindow gui = null;
				try {
					gui = new StartWindow();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		          gui.setLocationRelativeTo(null);
		      }
		    });
    }
	
}
