/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import java.io.IOException;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;

/**
 * Command to make resource tile act
 * @author Vincent Yan
 *
 */
public class ResourceTileActCommand implements Command {

	/**
	 * Constructor
	 */
	public ResourceTileActCommand() {
		
	}
	
	@Override
	public void execute(CurseOfMalphamondModel model) throws IOException,
			InterruptedException {
		model.resourceTileAct();
	}

}
