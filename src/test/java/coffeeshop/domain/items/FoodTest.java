package coffeeshop.domain.items;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class FoodTest {

    @Test
    void foodImplementsItemContract() {
        Food food = new Food(
                "Blueberry Muffin",
                new BigDecimal("3.25"),
                "Fresh baked muffin with blueberries"
        );

        assertInstanceOf(Item.class, food);
        assertEquals("Blueberry Muffin", food.name());
        assertEquals(new BigDecimal("3.25"), food.price());
        assertEquals("Fresh baked muffin with blueberries", food.description());
    }
}
