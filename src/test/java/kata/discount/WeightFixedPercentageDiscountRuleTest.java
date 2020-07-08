package kata.discount;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class WeightFixedPercentageDiscountRuleTest {

	@Test
	void testCalculateFreeItemsFromNullList() {
		WeightFixedPercentageDiscountRule theRule = new WeightFixedPercentageDiscountRule();
		assertEquals("There should be zero free items", 0, theRule.calculateFreeItems(null));
	}

}
