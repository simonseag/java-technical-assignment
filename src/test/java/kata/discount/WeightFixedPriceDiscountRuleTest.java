package kata.discount;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Collections;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kata.supermarket.ItemType;

class WeightFixedPriceDiscountRuleTest {

	@BeforeAll
	public static void init() {
		DiscountCalculator.getInstance()
				.deleteRules();
	}

	@AfterAll
	public static void cleanup() {
		DiscountCalculator.getInstance()
				.deleteRules();
	}

	@Test
	void testCalculateFreeItemsFromNullList() {
		WeightFixedPriceDiscountRule theRule = new WeightFixedPriceDiscountRule(ItemType.A);
		assertEquals("There should be zero free items", 0, theRule.calculateFreeItems(null));
	}

	@Test
	void testCalculateDiscountFromNullList() {
		WeightFixedPriceDiscountRule theRule = new WeightFixedPriceDiscountRule(ItemType.A);
		assertEquals("There should be zero discount", BigDecimal.ZERO, theRule.calculateDiscount(null));
	}

	@Test
	void testCalculateFreeItemsFromEmptyList() {
		WeightFixedPriceDiscountRule theRule = new WeightFixedPriceDiscountRule(ItemType.A);
		assertEquals("There should be zero free items", 0, theRule.calculateFreeItems(Collections.emptyList()));
	}

	@Test
	void testCalculateDiscountFromEmptyList() {
		WeightFixedPriceDiscountRule theRule = new WeightFixedPriceDiscountRule(ItemType.A);
		assertEquals("There should be zero discount", BigDecimal.ZERO,
				theRule.calculateDiscount(Collections.emptyList()));
	}

}
