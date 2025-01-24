public class NateBeverage implements Beverage {
    private MilkType milk;
    private SizeType size;

    public NateBeverage(MilkType milk, SizeType size) {
        this.milk = milk;
        this.size = size;
    }

    @Override
    public MilkType getMilk() {
        return this.milk;
    }

    @Override
    public SizeType getSize() {
        return this.size;
    }

    @Override
    public double getPrice() {
        return BeveragePriceCalculator.calculate(this, milk, size);
    }

    @Override
    public String getDescription() {
        return "Nate - " + this.size + ", " + this.milk;
    }

}
