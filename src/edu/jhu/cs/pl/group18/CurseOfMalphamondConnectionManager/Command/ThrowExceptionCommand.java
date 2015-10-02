/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import java.io.IOException;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelProxy;

/**
 * Call this function to ModelProxy when server wants to throw exceptions
 * @author Yunlong
 */
public class ThrowExceptionCommand implements Command {
	
	private String exception;

	/**
	 * Default Constructor
	 */
	public ThrowExceptionCommand() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Call this constructor when you want to send a message.
	 * @param exception 
	 */
	public ThrowExceptionCommand( String exception ) {
		
		this.exception = exception;
		
	}

	/** (non-Javadoc)
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.Command#execute(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel)
	 */
	@Override
	public void execute(CurseOfMalphamondModel model) throws IOException,
			InterruptedException {
		if ( model instanceof CurseOfMalphamondModelProxy ) {
			((CurseOfMalphamondModelProxy) model).setException(exception);
		}
	}

}
