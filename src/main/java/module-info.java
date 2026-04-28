module coffeeshop.app {
    requires javafx.controls;
    requires java.xml;

    exports coffeeshop.app;
    exports coffeeshop.app.controllers;
    exports coffeeshop.app.models;
    exports coffeeshop.app.views;
    exports coffeeshop.domain.items;
    exports coffeeshop.domain.orders;
    exports coffeeshop.service;
}
