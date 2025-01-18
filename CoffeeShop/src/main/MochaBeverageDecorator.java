public class MochaBeverageDecorator extends BeverageDecorator {
    private Beverage beverage;
    private double price = 1;

    public MochaBeverageDecorator(Beverage beverage) {
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
