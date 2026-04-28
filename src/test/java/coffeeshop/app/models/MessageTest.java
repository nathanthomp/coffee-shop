package coffeeshop.app.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageTest {

    @Test
    void messageStoresTitleAndBody() {
        Message message = new Message("Coffee Shop POS", "Initial project setup is running.");

        assertEquals("Coffee Shop POS", message.title());
        assertEquals("Initial project setup is running.", message.body());
    }
}
