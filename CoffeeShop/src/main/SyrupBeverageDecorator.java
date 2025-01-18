public class SyrupBeverageDecorator extends BeverageDecorator {
    private Beverage beverage;
    private double price = 1;
    private SyrupType type;

    public SyrupBeverageDecorator(SyrupType type, Beverage beverage) {
        this.type = type;
        this.beverage = beverage;
    }

    @Override
    public MilkType getMilk() {
        return beverage.getMilk();
    }

    @Override
    public double getPrice() {
        return this.beverage.getPrice() + this.price;
    }
}
