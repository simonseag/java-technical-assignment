package kata.discount;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import kata.supermarket.Item;
import kata.supermarket.ItemType;

/**
 * Applies the discount rule to pricing
 * 
 * @author simon.seagroatt
 *
 */
public class DiscountCalculator {

	/**
	 * Thread Safe instance
	 * 
	 * @author simon.seagroatt
	 *
	 */
	private static class DiscountFactoryHolder {
		private final static DiscountCalculator INSTANCE = new DiscountCalculator();
	}

	// Thread Safe in case we want to update the rules while they are still in use
	private ConcurrentHashMap<ItemType, LoadableDiscountRule> allRules = new ConcurrentHashMap<ItemType, LoadableDiscountRule>();

	/**
	 * Singleton
	 */
	private DiscountCalculator() {

	}

	public static DiscountCalculator getInstance() {
		return DiscountFactoryHolder.INSTANCE;
	}

	public void addRule(LoadableDiscountRule rule) {
		allRules.put(rule.getKey(), rule);
	}

	public int getRuleCount() {
		return allRules.size();
	}

	public BigDecimal getDiscountTotal(List<Item> items) {
		return BigDecimal.ZERO;
	}
}
