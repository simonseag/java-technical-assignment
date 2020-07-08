package kata.supermarket;

public abstract class ProductType {

	private final ItemType type;

	public ProductType(ItemType type) {
		super();
		this.type = type;
	}

	public ItemType getType() {
		return type;
	}
}
