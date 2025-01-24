import static org.junit.Assert.assertTrue;

import org.junit.Test;

// These unit tests are for ensuring the structure of the beverage is correct (milk, price, and size)
public class BeverageTest {
    @Test
    public void testSmallNateBeverage_Price() {
        Beverage b = new NateBeverage(MilkType.REGULAR, SizeType.SMALL);
        assertTrue(b.getPrice() == 2.49);
    }

    @Test
    public void testMediumNateBeverage_Price() {
        Beverage b = new NateBeverage(MilkType.REGULAR, SizeType.MEDIUM);
        assertTrue(b.getPrice() == 3.49);
    }

    @Test
    public void testLargeNateBeverage_Price() {
        Beverage b = new NateBeverage(MilkType.REGULAR, SizeType.LARGE);
        assertTrue(b.getPrice() == 4.49);
    }

    @Test
    public void testBoxNateBeverage_Price() {
        Beverage b = new NateBeverage(MilkType.REGULAR, SizeType.BOX);
        assertTrue(b.getPrice() == 16.49);
    }

    @Test
    public void testLargeNateBeverageOatMilk_Price() {
        Beverage b = new NateBeverage(MilkType.OAT, SizeType.LARGE);
        assertTrue(b.getPrice() == 4.49 + 0.40);
    }

    @Test
    public void testLargeNateBeverageAlmondMilk_Price() {
        Beverage b = new NateBeverage(MilkType.ALMOND, SizeType.LARGE);
        assertTrue(b.getPrice() == 4.49 + 0.40);
    }

    @Test
    public void testLargeNateBeverageSoyMilk_Price() {
        Beverage b = new NateBeverage(MilkType.SOY, SizeType.LARGE);
        assertTrue(b.getPrice() == 4.49 + 0.50);
    }

    @Test
    public void testSmallNicBeverage_Price() {
        Beverage b = new NicBeverage(MilkType.REGULAR, SizeType.SMALL);
        assertTrue(b.getPrice() == 3.99);
    }

    @Test
    public void testMediumNicBeverage_Price() {
        Beverage b = new NicBeverage(MilkType.REGULAR, SizeType.MEDIUM);
        assertTrue(b.getPrice() == 4.99);
    }

    @Test
    public void testLargeNicBeverage_Price() {
        Beverage b = new NicBeverage(MilkType.REGULAR, SizeType.LARGE);
        assertTrue(b.getPrice() == 5.99);
    }

    @Test
    public void testBoxNicBeverage_Price() {
        Beverage b = new NicBeverage(MilkType.REGULAR, SizeType.BOX);
        assertTrue(b.getPrice() == 19.99);
    }

    @Test
    public void testNateBeverage_Milk() {
        Beverage b = new NateBeverage(MilkType.REGULAR, SizeType.SMALL);
        assertTrue(b.getMilk() == MilkType.REGULAR);
    }

    @Test
    public void testNicBeverage_Milk() {
        Beverage b = new NicBeverage(MilkType.OAT, SizeType.SMALL);
        assertTrue(b.getMilk() == MilkType.OAT);
    }

    @Test
    public void testNateBeverage_Description() {
        Beverage b = new NateBeverage(MilkType.REGULAR, SizeType.SMALL);
        assertTrue(b.getDescription().equals("Nate - SMALL, REGULAR"));
    }

    @Test
    public void testNicBeverage_Description() {
        Beverage b = new NicBeverage(MilkType.OAT, SizeType.SMALL);
        assertTrue(b.getDescription().equals("Nic - SMALL, OAT"));
    }

    @Test
    public void testNateBeverage_Size() {
        Beverage b = new NateBeverage(MilkType.REGULAR, SizeType.SMALL);
        assertTrue(b.getSize() == SizeType.SMALL);
    }

    @Test
    public void testNicBeverage_Size() {
        Beverage b = new NicBeverage(MilkType.OAT, SizeType.SMALL);
        assertTrue(b.getSize() == SizeType.SMALL);
    }

}
