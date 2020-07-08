package kata.discount;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class FreeItemDiscountRuleTest {

	@Test
	void testCalculateFreeItemsFromNullList() {
		FreeItemDiscountRule theRule = new FreeItemDiscountRule();
		assertEquals("There should be zero free items", 0, theRule.calculateFreeItems(null));
	}

}
