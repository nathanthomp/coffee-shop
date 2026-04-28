package coffeeshop.app.controllers;

import coffeeshop.app.models.Message;

public class MainWindowController {

    public String windowTitle() {
        return "Coffee Shop POS";
    }

    public Message startupMessage() {
        return new Message("Coffee Shop POS", "Initial project setup is running.");
    }
}
