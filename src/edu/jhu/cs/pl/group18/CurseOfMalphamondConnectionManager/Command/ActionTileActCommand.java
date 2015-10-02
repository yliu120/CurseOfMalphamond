/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import java.io.IOException;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;

/**
 * Command to make ActionTile Act
 * @author Vincent Yan
 *
 */
public class ActionTileActCommand implements Command {

	/**
	 * Constructor
	 */
	public ActionTileActCommand() {
		
	}
	
	@Override
	public void execute(CurseOfMalphamondModel model) throws IOException,
			InterruptedException {
		model.actionTileAct();
	}

}
