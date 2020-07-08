package kata.discount;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class FixedPriceDiscountRuleTest {

	@Test
	void FixedPriceDiscountRuleTest() {
		FixedPriceDiscountRule theRule = new FixedPriceDiscountRule();
		assertEquals("There should be zero free items", 0, theRule.calculateFreeItems(null));
	}

}
