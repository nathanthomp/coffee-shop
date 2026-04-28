package coffeeshop.domain.items;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class BeverageTest {

    @Test
    void beverageImplementsItemContract() {
        Beverage beverage = new Beverage(
                "Latte",
                new BigDecimal("4.75"),
                "Espresso with steamed milk"
        );

        assertInstanceOf(Item.class, beverage);
        assertEquals("Latte", beverage.name());
        assertEquals(new BigDecimal("4.75"), beverage.price());
        assertEquals("Espresso with steamed milk", beverage.description());
    }
}
