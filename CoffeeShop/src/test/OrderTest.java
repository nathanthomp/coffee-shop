import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OrderTest {
    @Test
    public void testOrder_ContainsItem() {
        Order order = new Order();

        Beverage beverage = new NateBeverage(MilkType.REGULAR, SizeType.SMALL);
        order.addItem(beverage);

        assertTrue(order.containsItem(beverage));
    }

    @Test
    public void testOrder_TotalPrice() {
        Order order = new Order();
        Beverage beverage = new NateBeverage(MilkType.REGULAR, SizeType.SMALL);

        order.addItem(beverage);

        assertTrue(order.getTotalPrice() == 2.49);
    }
}
