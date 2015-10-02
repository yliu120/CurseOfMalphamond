package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;


import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;

/**
 * Command to select a target
 * @author Vincent Yan
 *
 */
public class SelectTargetCommand implements Command {

	private List<Player> target;
	
	/**
	 * The command to allow a player who is playing a card to select a target player from the list of valid
	 * targets. If there is only one valid target, then the player will skip the selection.
	 * @param card The card in play
	 * @param model The model where the list of valid targets come from
	 */
	public SelectTargetCommand(Card card, CurseOfMalphamondModel model) {
		super();
		this.target = card.getTargetScope(model);
	}


	@Override
	public void execute(CurseOfMalphamondModel model) {
		// TODO Auto-generated method stub

	}

}
