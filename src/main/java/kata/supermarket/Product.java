package kata.supermarket;

import java.math.BigDecimal;

public class Product extends ProductType {

	private final BigDecimal pricePerUnit;

	public Product(final BigDecimal pricePerUnit, final ItemType type) {
		super(type);
		this.pricePerUnit = pricePerUnit;

	}

	BigDecimal pricePerUnit() {
		return pricePerUnit;
	}

	public Item oneOf() {
		return new ItemByUnit(this);
	}
}
