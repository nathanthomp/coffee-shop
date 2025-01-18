import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BeverageTest {
    @Test
    public void testNateBeverage_Price() {
        Beverage b = new NateBeverage(MilkType.REGULAR);
        assertTrue(b.getPrice() == 4);
    }

    @Test
    public void testNateBeverage_Milk() {
        Beverage b = new NateBeverage(MilkType.REGULAR);
        assertTrue(b.getMilk() == MilkType.REGULAR);
    }

    @Test
    public void testNicBeverage_Price() {
        Beverage b = new NicBeverage(MilkType.OAT);
        assertTrue(b.getPrice() == 4);
    }

    @Test
    public void testNicBeverage_Milk() {
        Beverage b = new NicBeverage(MilkType.OAT);
        assertTrue(b.getMilk() == MilkType.OAT);
    }
}
