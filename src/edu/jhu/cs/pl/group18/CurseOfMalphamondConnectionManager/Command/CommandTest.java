/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import java.net.InetSocketAddress;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;

/**
 * This class is only for testing purposes.
 * @author Yunlong
 * @version 1.2
 * @since 1.2
 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.Command#execute(CurseOfMalphamondModel)
 */
public class CommandTest implements Command {
	
	private String test = "I am a test from: ";
	private String hostName = null;
	private int portNumber = 0;
	private InetSocketAddress address;

	/**
	 * Constructing the CommandTest class using two parameters.
	 * @param hostName the host name of the command order
	 * @param portNumber the port number of the command order
	 */
	public CommandTest(String hostName, int portNumber) {
		super();
		this.hostName = hostName;
		this.portNumber = portNumber;
	}
	
	/**
	 * Constructor for CommandTest using address as param
	 * @param address the address
	 */
	public CommandTest(InetSocketAddress address){
		
		this.address = address;
		
	}

	/**
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.Command#execute(CurseOfMalphamondModel)
	 */
	@Override
	public void execute(CurseOfMalphamondModel model) {
		
		if ( this.portNumber == 0 ){
			System.out.println(test + " " + this.address);
		} else {
			System.out.println(test + this.hostName + " " + this.portNumber);
		}

	}

}
