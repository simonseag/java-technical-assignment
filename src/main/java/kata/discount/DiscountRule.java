package kata.discount;

import java.util.List;

import kata.supermarket.Item;

/**
 * Basic interface necessary for the {@code Basket} to be able to work on a
 * given discount rule.
 * 
 * @author simon.seagroatt
 *
 */
public interface DiscountRule {

	/**
	 * 
	 * @param items
	 * @return a count of the number of {@code Item} objects on which this rule can
	 *         be applied
	 */
	public long calculateFreeItems(List<Item> items);

}
