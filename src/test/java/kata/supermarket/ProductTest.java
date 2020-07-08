package kata.supermarket;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class ProductTest {

	@Test
	void singleItemHasExpectedUnitPriceFromProduct() {

		final BigDecimal price = new BigDecimal("2.49");
		assertEquals(price, new Product(price, ItemType.F).oneOf()
				.price());
	}
}