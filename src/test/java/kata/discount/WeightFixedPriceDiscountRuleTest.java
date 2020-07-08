package kata.discount;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import kata.supermarket.ItemType;

class WeightFixedPriceDiscountRuleTest {

	@Test
	void testCalculateFreeItemsFromNullList() {
		WeightFixedPriceDiscountRule theRule = new WeightFixedPriceDiscountRule(ItemType.A);
		assertEquals("There should be zero free items", 0, theRule.calculateFreeItems(null));
	}

	@Test
	void testCalculateFreeItemsFromEmptyList() {
		WeightFixedPriceDiscountRule theRule = new WeightFixedPriceDiscountRule(ItemType.A);
		assertEquals("There should be zero free items", 0, theRule.calculateFreeItems(Collections.emptyList()));
	}

}
