package kata.discount;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import kata.supermarket.ItemType;

class WeightFixedPercentageDiscountRuleTest {

	@Test
	void testCalculateFreeItemsFromNullList() {
		WeightFixedPercentageDiscountRule theRule = new WeightFixedPercentageDiscountRule(ItemType.A);
		assertEquals("There should be zero free items", 0, theRule.calculateFreeItems(null));
	}

	@Test
	void testCalculateFreeItemsFromEmptyList() {
		WeightFixedPercentageDiscountRule theRule = new WeightFixedPercentageDiscountRule(ItemType.A);
		assertEquals("There should be zero free items", 0, theRule.calculateFreeItems(Collections.emptyList()));
	}

}
