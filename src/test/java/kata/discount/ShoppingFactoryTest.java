package kata.discount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import kata.supermarket.Item;
import kata.supermarket.ItemType;
import kata.supermarket.Product;

/**
 * Supplies shopping items to the tests.
 * 
 * @author simon.seagroatt
 *
 */
public class ShoppingFactoryTest {

	static Supplier<Item> aCokeItem = () -> {
		return new Product(new BigDecimal("0.90"), ItemType.B).oneOf();
	};

	static Supplier<Item> aBeanTinItem = () -> {
		return new Product(new BigDecimal("0.55"), ItemType.E).oneOf();
	};

	static Supplier<Item> aLoafItem = () -> {
		return new Product(new BigDecimal("0.90"), ItemType.A).oneOf();
	};

	static List<Item> getItems(int count, Supplier<Item> aProduct) {
		List<Item> items = new ArrayList<Item>();
		for (int i = 0; i < count; i++) {
			items.add(aProduct.get());
		}
		return items;
	}

}
