package kata.discount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import kata.supermarket.Item;
import kata.supermarket.ItemType;

/**
 * 
 * @author simon.seagroatt
 *
 */
class FreeItemDiscountRuleTest extends ShoppingFactoryTest {

	@Test
	void testCalculateFreeItemsFromNullList() {
		FreeItemDiscountRule theRule = new FreeItemDiscountRule(ItemType.A, 3, 1);
		assertEquals("There should be zero free items", 0, theRule.calculateFreeItems(null));
	}

	@Test
	void testCalculateFreeItemsFromEmptyList() {
		FreeItemDiscountRule theRule = new FreeItemDiscountRule(ItemType.A, 3, 1);
		assertEquals("There should be zero free items", 0, theRule.calculateFreeItems(Collections.emptyList()));
	}

	@Test
	void testInvalidNullTypeRuleDefinition() {
		try {
			new FreeItemDiscountRule(null, 2, 1);
			fail("We should not have been able to create a rule with invalid parameters");
		} catch (IllegalStateException ex) {
			// this should have thrown an exception!
		}
	}

	@Test
	void testInvalidAllRuleDefinition() {
		try {
			new FreeItemDiscountRule(null, -1, -1);
			fail("We should not have been able to create a rule with invalid parameters");
		} catch (IllegalStateException ex) {
			// this should have thrown an exception!
		}
	}

	@Test
	void testInvalidQuantityRuleDefinition() {
		try {
			new FreeItemDiscountRule(ItemType.A, 0, 0);
			fail("We should not have been able to create a rule with invalid parameters");
		} catch (IllegalStateException ex) {
			// this should have thrown an exception!
		}
	}

	@Test
	void testCorrectItemsCounted() {
		FreeItemDiscountRule theRule = new FreeItemDiscountRule(ItemType.E, 1, 1);

		List<Item> shoppingList = getItems(14, aBeanTinItem);
		shoppingList.addAll(getItems(9, aLoafItem));
		shoppingList.addAll(getItems(11, aCokeItem));

		long items = theRule.calculateFreeItems(shoppingList);
		assertEquals("Incorrect Number of free items returned", 7, items);
	}

	@Test
	void testFreeIdenticalItemCount() {
		testFreeItemCountOnForteenIdenticalItems(1, 1, 7);
		testFreeItemCountOnForteenIdenticalItems(2, 1, 4);
		testFreeItemCountOnForteenIdenticalItems(3, 1, 3);
		testFreeItemCountOnForteenIdenticalItems(4, 1, 2);
		testFreeItemCountOnForteenIdenticalItems(5, 1, 2);
		testFreeItemCountOnForteenIdenticalItems(1, 2, 9);
		testFreeItemCountOnForteenIdenticalItems(2, 2, 6);
		testFreeItemCountOnForteenIdenticalItems(3, 2, 5);
		testFreeItemCountOnForteenIdenticalItems(4, 2, 4);
		testFreeItemCountOnForteenIdenticalItems(5, 2, 4);
		testFreeItemCountOnForteenIdenticalItems(6, 2, 2);
		testFreeItemCountOnForteenIdenticalItems(7, 2, 2);
		testFreeItemCountOnForteenIdenticalItems(8, 2, 2);
	}

	private void testFreeItemCountOnForteenIdenticalItems(int qualifyCount, int freeItemCount, int result) {
		FreeItemDiscountRule theRule = new FreeItemDiscountRule(ItemType.E, qualifyCount, freeItemCount);

		long items = theRule.calculateFreeItems(getItems(14, aBeanTinItem));
		assertEquals("Incorrect Number of free items returned", result, items);
	}

}
