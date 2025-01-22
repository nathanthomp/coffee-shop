public class NateBeverage implements Beverage {
    private MilkType milk;
    private SizeType size;
    private double price;

    public NateBeverage(MilkType milk, SizeType size) {
        this.milk = milk;
        this.size = size;
        this.price = BeveragePriceCalculator.calculate(this, milk, size);
    }

    @Override
    public MilkType getMilk() {
        return this.milk;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public SizeType getSize() {
        return this.size;
    }
}
