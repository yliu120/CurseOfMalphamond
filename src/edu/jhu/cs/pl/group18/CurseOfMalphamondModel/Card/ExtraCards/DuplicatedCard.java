package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.ExtraCards;

import java.util.List;

import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.UseTimeType;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.CardType;

/**
 * This is the extra card which represents the copied card when playing the Mage character card "Duplicate".
 * @author Vincent Yan
 *
 */
public class DuplicatedCard implements Card {

	Card card;
	/**
	 * Constructor
	 * @param originalCard The original card to be duplicated
	 */
	public DuplicatedCard(Card originalCard) {
		this.card = originalCard;
	}

	@Override
	public CardType getCardType() {
		return CardType.EXTRA_CARD;
	}

	@Override
	public boolean canBeUsedNow(UseTimeType useTimeType) {
		return card.canBeUsedNow(useTimeType);
	}

	@Override
	public int getLevel() {
		return card.getLevel();
	}

	@Override
	public String getName() {
		return card.getName();
	}

	@Override
	public String getDescription() {
		return card.getDescription();
	}

	@Override
	public void play(CurseOfMalphamondModelImpl model, int choice) {
		card.play(model, choice);
	}

	@Override
	public List<Player> getTargetScope(CurseOfMalphamondModel model) {
		return card.getTargetScope(model);
	}
	
	@Override
	public void notifyListener(ModelListener listener, CurseOfMalphamondModelImpl model) {
		card.notifyListener(listener, model);
	}

}
