public class BrownSugarBeverageDecorator extends BeverageDecorator {

    public BrownSugarBeverageDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getPrice() {
        return super.beverage.getPrice() + PriceGateway.getInstance().getPrice("decorator-brownsugar");
    }

    @Override
    public String getDescription() {
       return super.beverage.getDescription() + ", brown sugar";
    }
}
