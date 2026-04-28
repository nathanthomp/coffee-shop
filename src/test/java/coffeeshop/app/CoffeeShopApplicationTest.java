package coffeeshop.app;

import javafx.application.Application;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class CoffeeShopApplicationTest {

    @Test
    void applicationUsesJavaFxApplicationBaseClass() {
        CoffeeShopApplication application = new CoffeeShopApplication();

        assertInstanceOf(Application.class, application);
    }
}
