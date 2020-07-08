package kata.discount;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kata.supermarket.Item;
import kata.supermarket.ItemType;

/**
 * 
 * @author simon.seagroatt
 *
 */
class DiscountCalculatorTest extends ShoppingFactoryTest {

	@BeforeAll
	public static void init() {

		DiscountCalculator.getInstance()
				.deleteRules();

		FreeItemDiscountRule ruleBuyThreeGetTwoFree = new FreeItemDiscountRule(ItemType.E, 3, 2);
		ruleBuyThreeGetTwoFree.load();

		FreeItemDiscountRule ruleBuyTwoGetOneFree = new FreeItemDiscountRule(ItemType.B, 2, 1);
		ruleBuyTwoGetOneFree.load();
	}

	@AfterAll
	public static void cleanup() {
		DiscountCalculator.getInstance()
				.deleteRules();
	}

	@Test
	void testAddUniqueRules() {

		FreeItemDiscountRule ruleBuyThreeGetTwoFree = new FreeItemDiscountRule(ItemType.E, 3, 2);
		ruleBuyThreeGetTwoFree.load();

		FreeItemDiscountRule ruleBuyTwoGetOneFree = new FreeItemDiscountRule(ItemType.B, 2, 1);
		ruleBuyTwoGetOneFree.load();

		assertEquals("Only two rule should have been added to the DiscountCalculator", 2,
				DiscountCalculator.getInstance()
						.getRuleCount());
	}

	@Test
	void testTwoItemsDiscountedSingleItemType() {

		assertEquals("Incorrect discount calculated", new BigDecimal("1.80"), DiscountCalculator.getInstance()
				.getDiscountTotal(getItems(6, aCokeItem)));
	}

	@Test
	void testFourItemDiscountedSingleItemType() {

		assertEquals("Incorrect discount calculated", new BigDecimal("2.20"), DiscountCalculator.getInstance()
				.getDiscountTotal(getItems(11, aBeanTinItem)));
	}

	@Test
	void testSixItemDiscountedTwoDiscountedItemTypes() {

		List<Item> items = getItems(11, aBeanTinItem);
		items.addAll(getItems(6, aCokeItem));

		assertEquals("Incorrect discount calculated", new BigDecimal("4.00"), DiscountCalculator.getInstance()
				.getDiscountTotal(items));
	}

	@Test
	void testFourItemDiscountedMixedItemTypes() {

		List<Item> items = getItems(11, aBeanTinItem);
		items.addAll(getItems(6, aLoafItem));

		assertEquals("Incorrect discount calculated", new BigDecimal("2.20"), DiscountCalculator.getInstance()
				.getDiscountTotal(items));
	}
}
