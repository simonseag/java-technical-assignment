package kata.discount;

import java.util.Collections;
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
public abstract class QualifyingDiscountRule extends LoadableDiscountRule {

	private ItemType qualifyType;

	public QualifyingDiscountRule(ItemType qualifyType) {
		this.qualifyType = qualifyType;
	}

	List<Item> getQualifyingItems(List<Item> items) {

		if (items == null) {
			return Collections.emptyList();
		}

		return items.stream()
				.filter(p -> p.getType() == qualifyType)
				.collect(Collectors.toList());
	}

	protected ItemType getItemType() {
		return qualifyType;
	}

	@Override
	public ItemType getKey() {
		// current implementation is that only 1 rule can be added for a given ItemType
		return qualifyType;
	}

}
