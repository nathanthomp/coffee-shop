public class SyrupBeverageDecorator extends BeverageDecorator {
    private Beverage beverage;
    private double price;
    private SyrupType type;

    public SyrupBeverageDecorator(SyrupType type, Beverage beverage) {
        this.type = type;
        this.beverage = beverage;
        this.price = PriceGateway.getInstance().getPrice("decorator-syrup");
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
