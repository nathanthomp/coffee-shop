package coffeeshop.app.controllers;

import coffeeshop.app.models.Message;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainWindowControllerTest {

    @Test
    void controllerProvidesExpectedWindowTitle() {
        MainWindowController controller = new MainWindowController();

        assertEquals("Coffee Shop POS", controller.windowTitle());
    }

    @Test
    void controllerProvidesStartupMessage() {
        MainWindowController controller = new MainWindowController();
        Message startupMessage = controller.startupMessage();

        assertEquals("Coffee Shop POS", startupMessage.title());
        assertEquals("Initial project setup is running.", startupMessage.body());
    }
}
