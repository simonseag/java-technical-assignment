package kata.discount;

import java.util.List;
import java.util.stream.Collectors;

import kata.supermarket.Item;
import kata.supermarket.ItemType;

/**
 * Class which associates a given rule with specific Item Type which the rule
 * will act on.
 * 
 * @author simon.seagroatt
 *
 */
public abstract class QualifyingDiscountRule implements DiscountRule {

	private ItemType qualifyType;

	public QualifyingDiscountRule(ItemType qualifyType) {
		this.qualifyType = qualifyType;
	}

	List<Item> getQualifyingItems(List<Item> items) {

		return items.stream()
				.filter(p -> p.getType() == qualifyType)
				.collect(Collectors.toList());
	}
}
