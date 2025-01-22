import static org.junit.Assert.assertTrue;

import org.junit.Test;

// These price unit tests are for the correct addition of differnt milks, sizes, and decorators
public class BeverageDecoratorTest {
    @Test
    public void testMochaBeverageDecorator_Price() {
        Beverage b = new MochaBeverageDecorator(new NateBeverage(MilkType.REGULAR, SizeType.SMALL));
        assertTrue(b.getPrice() == 2.49 + 0.50);
    }

    @Test
    public void testDoubleMochaBeverageDecorator_Price() {
        Beverage b = new MochaBeverageDecorator(new MochaBeverageDecorator(new NateBeverage(MilkType.REGULAR, SizeType.SMALL)));
        assertTrue(b.getPrice() == 2.49 + 0.50 + 0.50);
    }

    @Test
    public void testSyrupBeverageDecorator_Price() {
        Beverage b = new SyrupBeverageDecorator(SyrupType.VANILLA, new NateBeverage(MilkType.REGULAR, SizeType.SMALL));
        assertTrue(b.getPrice() == 2.49 + 0.25);
    }

    @Test
    public void testDoubleSyrupBeverageDecorator_Price() {
        Beverage b = new SyrupBeverageDecorator(SyrupType.VANILLA, new SyrupBeverageDecorator(SyrupType.VANILLA, new NateBeverage(MilkType.REGULAR, SizeType.SMALL)));
        assertTrue(b.getPrice() == 2.49 + 0.25 + 0.25);
    }

    @Test
    public void testBrownSugarBeverageDecorator_Price() {
        Beverage b = new BrownSugarBeverageDecorator(new NateBeverage(MilkType.REGULAR, SizeType.SMALL));
        assertTrue(b.getPrice() == 2.49 + 0.15);
    }
}
