package kata.discount;

import java.util.List;

import kata.supermarket.Item;

public class FreeItemDiscountRule implements DiscountRule {

	@Override
	public long calculateFreeItems(List<Item> items) {
		return 0;
	}

}
