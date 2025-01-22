public class BrownSugarBeverageDecorator extends BeverageDecorator {
    private Beverage beverage;
    private double price;

    public BrownSugarBeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
        this.price = PriceGateway.getInstance().getPrice("decorator-brownsugar");
    }

    @Override
    public MilkType getMilk() {
        return this.beverage.getMilk();
    }

    @Override
    public double getPrice() {
        return this.beverage.getPrice() + this.price;
    }

    @Override
    public SizeType getSize() {
        return this.beverage.getSize();
    }
}
