package kata.discount;

import kata.supermarket.ItemType;

/**
 * Class which is capable of being loaded into the {@code DiscountCalculator}
 * 
 * @author simon.seagroatt
 *
 */
public abstract class LoadableDiscountRule implements DiscountRule {

	/**
	 * Adds this {@code DiscountRule} to the {@code DiscountFactory} for use by the
	 * {@code Basket}
	 */
	public void load() {
		DiscountCalculator.getInstance()
				.addRule(this);
	}

	/**
	 * @return the unique key to be used for a given rule which will be loaded into
	 *         a {@code HashMap} within the {@code DiscountCalculator}
	 */
	abstract ItemType getKey();

}
