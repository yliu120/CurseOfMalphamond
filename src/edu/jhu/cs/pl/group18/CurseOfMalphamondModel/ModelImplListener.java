/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;

/**
 * Implementation of modelListener
 * @author Yunlong
 *
 */
public abstract class ModelImplListener implements ModelListener {

	/** (non-Javadoc)
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener#playerInfoChanged()
	 */
	@Override
	public void playerInfoChanged() {
	}
	
	@Override
	public void diceRolled() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void boardInfoChanged() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void currentActivePlayerChanged() {
		// TODO Auto-generated method stub
		
	}
	
	/** game exception throwed function.
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener#gameExceptionThrowed()
	 */
	@Override
	public void gameExceptionThrowed() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener#playerAdded()
	 */
	@Override
	public void playerAdded( Player player ) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener#playerRemoved()
	 */
	@Override
	public void playerRemoved( Player player ) {
		// TODO Auto-generated method stub
		
	}
	
	
	/* (non-Javadoc)
	 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener#characterChanged()
	 */
	@Override
	public void characterChanged( Character character, String username, String result) {
		// TODO Auto-generated method stub	
	}
}
