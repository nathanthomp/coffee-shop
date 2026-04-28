package coffeeshop.service;

import coffeeshop.domain.items.Item;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MenuServiceTest {

    @Test
    void loadMenuReturnsItemsFromXmlResource() {
        MenuService menuService = new MenuService();

        List<Item> menuItems = menuService.loadMenu();

        assertFalse(menuItems.isEmpty());
        assertEquals(4, menuItems.size());
        assertTrue(menuItems.stream().anyMatch(item -> item.name().equals("Espresso")));
        assertTrue(menuItems.stream().anyMatch(item -> item.name().equals("Latte")));
        assertTrue(menuItems.stream().anyMatch(item -> item.name().equals("Croissant")));
        assertTrue(menuItems.stream().anyMatch(item -> item.name().equals("Bagel")));
    }

    @Test
    void loadMenuPreservesXmlItemDetails() {
        MenuService menuService = new MenuService();

        List<Item> menuItems = menuService.loadMenu();

        Item espresso = menuItems.stream()
                .filter(item -> item.name().equals("Espresso"))
                .findFirst()
                .orElseThrow();

        assertEquals(new BigDecimal("2.50"), espresso.price());
        assertEquals(
                "A strong, concentrated coffee made by forcing hot water through finely-ground coffee beans.",
                espresso.description()
        );
    }

    @Test
    void loadMenuReturnsImmutableMenuSnapshot() {
        MenuService menuService = new MenuService();

        List<Item> menuItems = menuService.loadMenu();

        assertThrows(UnsupportedOperationException.class, () -> menuItems.add(menuItems.getFirst()));
    }
}
