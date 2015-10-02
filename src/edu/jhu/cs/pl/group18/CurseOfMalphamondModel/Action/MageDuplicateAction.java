package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Action;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.CardNotFoundException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.ExtraCards.DuplicatedCard;

/**
 * Copy a card from the current player's hand into that hand, triggered by playing the Mage class
 * card "Duplicate".
 * @author Vincent Yan
 *
 */
public class MageDuplicateAction implements Action {
	private CurseOfMalphamondModelImpl model;
	private int choice;
	
	public MageDuplicateAction(CurseOfMalphamondModelImpl model, int choice) {
		this.model = model;
		this.choice = choice;
	}
	
	@Override
	public void act() {
		Player player = model.getCurrentActivePlayer();
		player.setMaxHandSize(player.getMaxHandSize() + 1);
		try {
			player.drawCard(new DuplicatedCard(player.getHand().getCards().get(choice)), model);
		} catch (CardNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		player.setMaxHandSize(player.getMaxHandSize() - 1);
	}

}
