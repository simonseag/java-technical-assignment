package kata.discount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import kata.supermarket.Item;
import kata.supermarket.Product;

class FreeItemDiscountRuleTest {

	@Test
	void testCalculateFreeItemsFromNullList() {
		FreeItemDiscountRule theRule = new FreeItemDiscountRule(3, 1);
		assertEquals("There should be zero free items", 0, theRule.calculateFreeItems(null));
	}

	@Test
	void testCalculateFreeItemsFromEmptyList() {
		FreeItemDiscountRule theRule = new FreeItemDiscountRule(3, 1);
		assertEquals("There should be zero free items", 0, theRule.calculateFreeItems(Collections.emptyList()));
	}

	@Test
	void testInvalidNegativeRuleDefinition() {
		try {
			new FreeItemDiscountRule(-1, -1);
			fail("We should not have been able to create a rule with invalid parameters");
		} catch (IllegalStateException ex) {
			// this should have thrown an exception!
		}
	}

	@Test
	void testInvalidPositiveRuleDefinition() {
		try {
			new FreeItemDiscountRule(0, 0);
			fail("We should not have been able to create a rule with invalid parameters");
		} catch (IllegalStateException ex) {
			// this should have thrown an exception!
		}
	}

	@Test
	void testFreeItemCount() {
		testFreeItemCountOnForteenItems(1, 1, 7);
		testFreeItemCountOnForteenItems(2, 1, 4);
		testFreeItemCountOnForteenItems(3, 1, 3);
		testFreeItemCountOnForteenItems(4, 1, 2);
		testFreeItemCountOnForteenItems(5, 1, 2);
		testFreeItemCountOnForteenItems(1, 2, 9);
		testFreeItemCountOnForteenItems(2, 2, 6);
		testFreeItemCountOnForteenItems(3, 2, 5);
		testFreeItemCountOnForteenItems(4, 2, 4);
		testFreeItemCountOnForteenItems(5, 2, 4);
		testFreeItemCountOnForteenItems(6, 2, 2);
		testFreeItemCountOnForteenItems(7, 2, 2);
		testFreeItemCountOnForteenItems(8, 2, 2);
	}

	private void testFreeItemCountOnForteenItems(int qualifyCount, int freeItemCount, int result) {
		FreeItemDiscountRule theRule = new FreeItemDiscountRule(qualifyCount, freeItemCount);

		long items = theRule.calculateFreeItems(ForteenTinsOfBeans());
		assertEquals("Incorrect Number of free items returned", result, items);
	}

	private static List<Item> ForteenTinsOfBeans() {
		return Stream
				.of(aTinOfBeans(), aTinOfBeans(), aTinOfBeans(), aTinOfBeans(), aTinOfBeans(), aTinOfBeans(),
						aTinOfBeans(), aTinOfBeans(), aTinOfBeans(), aTinOfBeans(), aTinOfBeans(), aTinOfBeans(),
						aTinOfBeans(), aTinOfBeans())
				.collect(Collectors.toList());
	}

	private static Item aTinOfBeans() {
		return new Product(new BigDecimal("0.55")).oneOf();
	}

}
