package kata.discount;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import kata.supermarket.ItemType;

/**
 * 
 * @author simon.seagroatt
 *
 */
class DiscountCalculatorTest extends ShoppingFactoryTest {

	@Test
	void testAddUniqueRules() {

		FreeItemDiscountRule ruleBuyThreeGetTwoFree = new FreeItemDiscountRule(ItemType.E, 3, 2);
		DiscountCalculator.getInstance()
				.addRule(ruleBuyThreeGetTwoFree);

		FreeItemDiscountRule ruleBuyTwoGetOneFree = new FreeItemDiscountRule(ItemType.E, 2, 1);
		DiscountCalculator.getInstance()
				.addRule(ruleBuyTwoGetOneFree);

		assertEquals("Only one rule should have been added to the DiscountCalculator", 1,
				DiscountCalculator.getInstance()
						.getRuleCount());
	}
}
