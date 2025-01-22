import static org.junit.Assert.assertTrue;

import org.junit.Test;

// These price tests are for validating that the correct prices are transferred from the file to memory
public class PriceGatewayTest {
    @Test
    public void testGetInstance_NotNull() {
        assertTrue(PriceGateway.getInstance() != null);
    }

    @Test
    public void testGetInstance_ExistingNotNull() {
        PriceGateway.getInstance();
        assertTrue(PriceGateway.getInstance() != null);
    }

    @Test
    public void testGetPrice_NicMediumBeverage() {
        double price = PriceGateway.getInstance().getPrice("beverage-nic-medium");
        assertTrue(price == 4.99);
    }

    @Test
    public void testGetPrice_MochaDecorator() {
        double price = PriceGateway.getInstance().getPrice("decorator-mocha");
        assertTrue(price == 0.50);
    }

    @Test
    public void testGetPrice_SyrupDecorator() {
        double price = PriceGateway.getInstance().getPrice("decorator-syrup");
        assertTrue(price == 0.25);
    }

    @Test
    public void testGetPrice_BrownSugarDecorator() {
        double price = PriceGateway.getInstance().getPrice("decorator-brownsugar");
        assertTrue(price == 0.15);
    }
}
