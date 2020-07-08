package kata.discount;

import java.util.List;

import kata.supermarket.Item;
import kata.supermarket.ItemType;

/**
 * This discount should be used when you want to gift a free item(s) based on
 * the amount of items purchased. For example:
 * <ul>
 * <li>Buy one, get one free
 * <li>Buy three items for the price of two
 * <li>etc
 * </ul>
 * 
 * @author simon.seagroatt
 *
 */
public class FreeItemDiscountRule extends QualifyingDiscountRule {

	private int noOfItemsToQualify;
	private int noOfFreeItems;

	/**
	 * Constructor
	 * 
	 * @param type          the product identifier which will be associated with
	 *                      this rule
	 * @param qualifyCount  the number of items to purchase which gives you a
	 *                      discount
	 * @param freeItemCount the number of free items you receive
	 * @throws IllegalStateException if the supplied parameters do not meet the
	 *                               validation criteria
	 */
	public FreeItemDiscountRule(ItemType type, int qualifyCount, int freeItemCount) throws IllegalStateException {
		super(type);
		noOfItemsToQualify = qualifyCount;
		noOfFreeItems = freeItemCount;

		isValid();
	}

	@Override
	public long calculateFreeItems(List<Item> items) {

		if (items == null) {
			return 0;
		}

		List<Item> qualifyingItems = getQualifyingItems(items);

		long itemsInBasketCount = qualifyingItems.size();

		// total of all the purchased and free items
		int totalItemsInBundle = noOfItemsToQualify + noOfFreeItems;

		if (itemsInBasketCount >= totalItemsInBundle) {

			// How many times does this go into the items we have
			long discountMultiplier = Math.floorDiv(itemsInBasketCount, totalItemsInBundle);

			// how many items does that leave
			long remainder = itemsInBasketCount % totalItemsInBundle;

			// are there any additional free items from those remaining
			long additionalFreeItems = 0;
			if (remainder > 0 && remainder > noOfItemsToQualify) {
				additionalFreeItems = remainder - noOfItemsToQualify;
			}

			// calculate the number of items that should then be free of charge
			return (noOfFreeItems * discountMultiplier) + additionalFreeItems;
		}
		return 0;
	}

	private void isValid() {

		if (noOfItemsToQualify <= 0 || noOfFreeItems <= 0 || getItemType() == null) {
			throw new IllegalStateException("A discount cannot be calculated given the defined rules");
		}
	}
}
