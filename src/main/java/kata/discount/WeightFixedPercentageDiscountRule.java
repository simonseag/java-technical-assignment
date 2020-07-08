package kata.discount;

import java.util.List;

import kata.supermarket.Item;

/**
 * This rule should be applied when a specific amount of weight should be sold
 * at a specific percentage discount.
 * 
 * <p>
 * For example:
 * <ul>
 * <li>Buy One Kilo for Half Price
 * <li>Buy 500 grams for 10% off
 * <li>etc
 * </ul>
 * <b>NOTE:</b> TODO!
 * 
 * @author simon.seagroatt
 *
 */
public class WeightFixedPercentageDiscountRule implements DiscountRule {

	@Override
	public long calculateFreeItems(List<Item> items) {
		return 0;
	}

}
