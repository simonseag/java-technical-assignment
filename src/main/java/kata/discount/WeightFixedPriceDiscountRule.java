package kata.discount;

import java.util.List;

import kata.supermarket.Item;

/**
 * This rule should be applied when a specific amount of weight should be sold
 * for a specific price.
 * <p>
 * For example:
 * <ul>
 * <li>Buy One Kilo for �2.00
 * <li>Buy 500 grams for �1.10
 * <li>etc
 * </ul>
 * <b>NOTE:</b> TODO!
 * 
 * @author simon.seagroatt
 *
 */
public class WeightFixedPriceDiscountRule implements DiscountRule {

	@Override
	public long calculateFreeItems(List<Item> items) {
		return 0;
	}

}
