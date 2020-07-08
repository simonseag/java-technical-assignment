package kata.supermarket;

import java.math.BigDecimal;

public class WeighedProduct extends ProductType {

	private final BigDecimal pricePerKilo;

	public WeighedProduct(final BigDecimal pricePerKilo, final ItemType type) {
		super(type);
		this.pricePerKilo = pricePerKilo;
	}

	BigDecimal pricePerKilo() {
		return pricePerKilo;
	}

	public Item weighing(final BigDecimal kilos) {
		return new ItemByWeight(this, kilos);
	}
}
