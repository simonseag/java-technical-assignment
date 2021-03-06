package kata.discount;

import java.math.BigDecimal;
import java.util.List;

import kata.supermarket.Item;
import kata.supermarket.ItemType;

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
public class WeightFixedPercentageDiscountRule extends QualifyingDiscountRule {

	public WeightFixedPercentageDiscountRule(ItemType qualifyType) {
		super(qualifyType);
	}

	@Override
	public BigDecimal calculateDiscount(List<Item> items) {
		return BigDecimal.ZERO;
	}

	@Override
	public long calculateFreeItems(List<Item> items) {
		return 0;
	}

}
