/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager;

import java.util.EventObject;

import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.Command;

/**
 * The event that a message is received.
 * @author Yunlong
 *
 */
public class MessageReceivedEvent extends EventObject {
	
	private Command message;

	/**
	 * Constructor
	 * @param source The source
	 */
	public MessageReceivedEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor for the case with message
	 * @param source The source
	 * @param message The message
	 */
	public MessageReceivedEvent(Object source, Command message) {
		super(source);
		this.message = message;
	}

	/**
	 * Get the message
	 * @return The message
	 */
	public Command getMessage() {
		return this.message;
	}

}
