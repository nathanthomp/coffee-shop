import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BeverageDecoratorTest {
    @Test
    public void testMochaBeverageDecorator_Price() {
        Beverage b = new MochaBeverageDecorator(new NateBeverage(MilkType.REGULAR));
        assertTrue(b.getPrice() == 5);
    }

    @Test
    public void testDoubleMochaBeverageDecorator_Price() {
        Beverage b = new MochaBeverageDecorator(new MochaBeverageDecorator(new NateBeverage(MilkType.REGULAR)));
        assertTrue(b.getPrice() == 6);
    }

    @Test
    public void testSyrupBeverageDecorator_Price() {
        Beverage b = new SyrupBeverageDecorator(SyrupType.VANILLA, new NateBeverage(MilkType.REGULAR));
        assertTrue(b.getPrice() == 5);
    }

    @Test
    public void testDoubleSyrupBeverageDecorator_Price() {
        Beverage b = new SyrupBeverageDecorator(SyrupType.VANILLA, new SyrupBeverageDecorator(SyrupType.VANILLA, new NateBeverage(MilkType.REGULAR)));
        assertTrue(b.getPrice() == 6);
    }

    @Test
    public void testRegularMilkNateBeverageDecorator_Price() {
        Beverage b = new NateBeverage(MilkType.REGULAR);
        assertTrue(b.getPrice() == 6);
    }
}
