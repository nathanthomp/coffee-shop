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

    @Test
    public void testBrownSugarBeverageDecorator_Description() {
        Beverage b = new BrownSugarBeverageDecorator(new NateBeverage(MilkType.REGULAR, SizeType.SMALL));
        assertTrue(b.getDescription().equals("Nate - SMALL, REGULAR, brown sugar"));
    }

    @Test
    public void testSyrupBeverageDecorator_Description() {
        Beverage b = new SyrupBeverageDecorator(SyrupType.VANILLA, new NateBeverage(MilkType.REGULAR, SizeType.SMALL));
        assertTrue(b.getDescription().equals("Nate - SMALL, REGULAR, syrup:VANILLA"));
    }

    @Test
    public void testMochaBeverageDecorator_Description() {
        Beverage b = new MochaBeverageDecorator(new NateBeverage(MilkType.REGULAR, SizeType.SMALL));
        assertTrue(b.getDescription().equals("Nate - SMALL, REGULAR, mocha"));
    }

    @Test
    public void testBeverageDecorator_Milk() {
        Beverage b = new MochaBeverageDecorator(new NateBeverage(MilkType.REGULAR, SizeType.SMALL));
        assertTrue(b.getMilk() == MilkType.REGULAR);
    }

    @Test
    public void testBeverageDecorator_Size() {
        Beverage b = new MochaBeverageDecorator(new NateBeverage(MilkType.REGULAR, SizeType.SMALL));
        assertTrue(b.getSize() == SizeType.SMALL);
    }
}
