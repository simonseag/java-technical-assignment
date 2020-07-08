package kata.discount;

import java.util.List;

import kata.supermarket.Item;
import kata.supermarket.ItemType;

/**
 * This rule should be used when you want to apply a fixed price for a number of
 * items.
 * <p>
 * For example:
 * <ul>
 * <li>Buy two items for £1
 * <li>Buy three items for £7.50
 * <li>etc
 * </ul>
 * <b>NOTE:</B> TODO!
 * 
 * @author simon.seagroatt
 *
 */
public class FixedPriceDiscountRule extends QualifyingDiscountRule {

	public FixedPriceDiscountRule(ItemType qualifyType) {
		super(qualifyType);
	}
	
	@Override
	public long calculateFreeItems(List<Item> items) {
		return 0;
	}

}
