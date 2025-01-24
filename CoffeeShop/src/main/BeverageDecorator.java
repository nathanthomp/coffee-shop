public abstract class BeverageDecorator implements Beverage {
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public MilkType getMilk() {
        return this.beverage.getMilk();
    }

    @Override
    public SizeType getSize() {
        return this.beverage.getSize();
    }
}
