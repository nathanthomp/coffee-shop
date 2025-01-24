public class MochaBeverageDecorator extends BeverageDecorator {

    public MochaBeverageDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getPrice() {
        return super.beverage.getPrice() + PriceGateway.getInstance().getPrice("decorator-mocha");
    }

    @Override
    public String getDescription() {
        return super.beverage.getDescription() + ", mocha";
    }
}
