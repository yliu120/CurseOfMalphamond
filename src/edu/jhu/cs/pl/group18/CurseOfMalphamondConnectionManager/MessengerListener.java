/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager;

/**
 * This messenger Listener will report a message received to the
 * corresponding modelProxy.
 * @author Yunlong
 *
 */
public interface MessengerListener {
	
	/**
	 * Call this function when the messenger receive a new message.
	 * @param messageReceivedEvent The associated message received event
	 */
	public void messageReceived( MessageReceivedEvent messageReceivedEvent );

}
