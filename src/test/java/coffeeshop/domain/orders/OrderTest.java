package coffeeshop.domain.orders;

import coffeeshop.domain.items.Beverage;
import coffeeshop.domain.items.Food;
import coffeeshop.domain.items.Item;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderTest {

    @Test
    void orderStoresItemsAsImmutableSnapshot() {
        Item beverage = new Beverage(
                "Latte",
                new BigDecimal("4.75"),
                "Espresso with steamed milk"
        );
        Item food = new Food(
                "Blueberry Muffin",
                new BigDecimal("3.25"),
                "Fresh baked muffin with blueberries"
        );

        Order order = new Order(List.of(beverage, food));

        assertEquals(List.of(beverage, food), order.items());
        assertThrows(UnsupportedOperationException.class, () -> order.items().add(beverage));
    }
}
