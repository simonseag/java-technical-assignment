package kata.discount;

import java.math.BigDecimal;
import java.util.List;

import kata.supermarket.Item;
import kata.supermarket.ItemType;

/**
 * This rule should be applied when a specific amount of weight should be sold
 * for a specific price.
 * <p>
 * For example:
 * <ul>
 * <li>Buy One Kilo for £2.00
 * <li>Buy 500 grams for £1.10
 * <li>etc
 * </ul>
 * <b>NOTE:</b> TODO!
 * 
 * @author simon.seagroatt
 *
 */
public class WeightFixedPriceDiscountRule extends QualifyingDiscountRule {

	public WeightFixedPriceDiscountRule(ItemType qualifyType) {
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
