/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondUI.Main;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.ServerPortUnbindException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.ConnectionManager;

/**
 * @author Yunlong
 *
 */
public class ServerSide {
	
	public static void main(String[] args) {
		try {
			ConnectionManager manager = new ConnectionManager();
		} catch (ServerPortUnbindException e) {
		}
	}

}
