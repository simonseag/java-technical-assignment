package kata.discount;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class WeightFixedPriceDiscountRuleTest {

	@Test
	void testCalculateFreeItemsFromNullList() {
		WeightFixedPriceDiscountRule theRule = new WeightFixedPriceDiscountRule();
		assertEquals("There should be zero free items", 0, theRule.calculateFreeItems(null));
	}

}
