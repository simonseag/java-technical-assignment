package kata.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import kata.supermarket.Basket;
import kata.supermarket.Item;
import kata.supermarket.ItemType;
import kata.supermarket.Product;
import kata.supermarket.WeighedProduct;

/**
 * 
 * @author qmetric, simon.seagroatt
 *
 */
class BasketWithDiscountTest {

	@BeforeAll
	public static void init() {
		DiscountCalculator.getInstance()
				.deleteRules();

		FreeItemDiscountRule ruleBuyThreeGetOneFree = new FreeItemDiscountRule(ItemType.E, 3, 1);
		ruleBuyThreeGetOneFree.load();

		FreeItemDiscountRule ruleBuyOneGetOneFree = new FreeItemDiscountRule(ItemType.B, 1, 1);
		ruleBuyOneGetOneFree.load();

		FreeItemDiscountRule ruleBuyThreeItemsForThePriceOfTwo = new FreeItemDiscountRule(ItemType.A, 2, 1);
		ruleBuyThreeItemsForThePriceOfTwo.load();
	}

	@AfterAll
	public static void cleanup() {
		DiscountCalculator.getInstance()
				.deleteRules();
	}

	@DisplayName("basket provides its total value when containing...")
	@MethodSource
	@ParameterizedTest(name = "{0}")
	void basketProvidesTotalValue(String description, String expectedTotal, Iterable<Item> items) {
		final Basket basket = new Basket();
		items.forEach(basket::add);
		assertEquals(new BigDecimal(expectedTotal), basket.total());
	}

	static Stream<Arguments> basketProvidesTotalValue() {
		return Stream.of(noItems(), aSingleItemPricedPerUnit(), multipleItemsPricedPerUnit(),
				aSingleItemPricedByWeight(), multipleItemsPricedByWeight());
	}

	private static Arguments aSingleItemPricedByWeight() {
		return Arguments.of("a single weighed item", "1.25", Collections.singleton(twoFiftyGramsOfAmericanSweets()));
	}

	private static Arguments multipleItemsPricedByWeight() {
		return Arguments.of("multiple weighed items", "1.85",
				Arrays.asList(twoFiftyGramsOfAmericanSweets(), twoHundredGramsOfPickAndMix()));
	}

	private static Arguments multipleItemsPricedPerUnit() {
		return Arguments.of("multiple items priced per unit", "4.08", Arrays.asList(aPackOfDigestives(),
				aPackOfDigestives(), aPackOfDigestives(), aPintOfMilk(), aPintOfMilk(), aPintOfMilk()));
	}

	private static Arguments aSingleItemPricedPerUnit() {
		return Arguments.of("a single item priced per unit", "0.49", Collections.singleton(aPintOfMilk()));
	}

	private static Arguments noItems() {
		return Arguments.of("no items", "0.00", Collections.emptyList());
	}

	private static Item aPintOfMilk() {
		return new Product(new BigDecimal("0.49"), ItemType.A).oneOf();
	}

	private static Item aPackOfDigestives() {
		return new Product(new BigDecimal("1.55"), ItemType.B).oneOf();
	}

	private static WeighedProduct aKiloOfAmericanSweets() {
		return new WeighedProduct(new BigDecimal("4.99"), ItemType.C);
	}

	private static Item twoFiftyGramsOfAmericanSweets() {
		return aKiloOfAmericanSweets().weighing(new BigDecimal(".25"));
	}

	private static WeighedProduct aKiloOfPickAndMix() {
		return new WeighedProduct(new BigDecimal("2.99"), ItemType.D);
	}

	private static Item twoHundredGramsOfPickAndMix() {
		return aKiloOfPickAndMix().weighing(new BigDecimal(".2"));
	}
}