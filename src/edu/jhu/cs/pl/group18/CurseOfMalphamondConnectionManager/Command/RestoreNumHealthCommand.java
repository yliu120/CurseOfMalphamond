/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;

/**
 * Command to restore a number of health
 * @author Vincent Yan
 *
 */
public class RestoreNumHealthCommand implements Command {

	private int num;
	
	/**
	 * Default constructor
	 */
	public RestoreNumHealthCommand() {
		this.num = -1;
	}
	
	/**
	 * The command to restore a number of health to a character
	 * @param num The number of health
	 */
	public RestoreNumHealthCommand(int num) {
		this.num = num;
	}

	@Override
	public void execute(CurseOfMalphamondModel model) {
		
		if ( model instanceof CurseOfMalphamondModelImpl ) {
			if (this. num == -1) {
				this.num = 10 + ((CurseOfMalphamondModelImpl) model).getCurrentActivePlayer().getCharacter().getLevel() * 2;
			}
			int currentHealth = ((CurseOfMalphamondModelImpl) model).getCurrentActivePlayer().getCharacter().getHealth();
			((CurseOfMalphamondModelImpl) model).getCurrentActivePlayer().getCharacter().setHealth(currentHealth + this.num); 
			
		}
		
	}

}
