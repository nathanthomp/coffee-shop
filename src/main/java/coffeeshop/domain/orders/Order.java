package coffeeshop.domain.orders;

import coffeeshop.domain.items.Item;

import java.util.List;

public final class Order {

    private final List<Item> items;

    public Order(List<Item> items) {
        this.items = List.copyOf(items);
    }

    public List<Item> items() {
        return items;
    }
}
