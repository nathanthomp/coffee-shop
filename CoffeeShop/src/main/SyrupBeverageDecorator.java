public class SyrupBeverageDecorator extends BeverageDecorator {
    private SyrupType flavor;

    public SyrupBeverageDecorator(SyrupType flavor, Beverage beverage) {
        super(beverage);
        this.flavor = flavor;
    }

    @Override
    public double getPrice() {
        return super.beverage.getPrice() + PriceGateway.getInstance().getPrice("decorator-syrup");
    }

    @Override
    public String getDescription() {
        return super.beverage.getDescription() + ", syrup:" + this.flavor;
    }
}
