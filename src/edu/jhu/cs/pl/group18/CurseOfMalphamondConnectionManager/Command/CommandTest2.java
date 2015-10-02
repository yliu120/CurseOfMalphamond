/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;

/**
 * This class is only for testing purposes.
 * @author Yunlong
 *
 */
public class CommandTest2 implements Command {
	
	private String hello = "Hello!";
	private int portNumber = 9999;
	
	/**
	 * Default constructor
	 */
	public CommandTest2() {
		
	}
	
	/**
	 * The constructor using two params
	 * @param hello the hello
	 * @param portNumber the portNumber
	 */
	public CommandTest2(String hello, int portNumber) {
		super();
		this.hello = hello;
		this.portNumber = portNumber;
	}
	
	@Override
	public void execute(CurseOfMalphamondModel model) {
		System.out.println(this.hello + " " + this.portNumber);
	}

}
