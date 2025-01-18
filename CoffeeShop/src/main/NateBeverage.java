public class NateBeverage implements Beverage {
    private MilkType milk;
    private double price = 4;

    public NateBeverage(MilkType milk) {
        this.milk = milk;
    }

    @Override
    public MilkType getMilk() {
        return milk;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
