public class MochaBeverageDecorator extends BeverageDecorator {
    private Beverage beverage;
    private double price;

    public MochaBeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
        this.price = PriceGateway.getInstance().getPrice("decorator-mocha");
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
