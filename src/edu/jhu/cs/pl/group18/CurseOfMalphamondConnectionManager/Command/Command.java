/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import java.io.IOException;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;

/**
 * Command that is sent through connection
 * @author Yunlong
 * @version 1.2
 * @since 1.2
 */
public interface Command {
	
	/**
	 * Execute the command.
	 * @param model The method where the execution happens
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public void execute(CurseOfMalphamondModel model) throws IOException, InterruptedException;

}
