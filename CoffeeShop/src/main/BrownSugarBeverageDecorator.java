public class BrownSugarBeverageDecorator extends BeverageDecorator {
    private Beverage beverage;
    private double price = 1;

    public BrownSugarBeverageDecorator(Beverage beverage) {
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
