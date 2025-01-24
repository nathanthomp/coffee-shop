public class BeveragePriceCalculator {
    public static double calculate(Beverage beverage, MilkType milk, SizeType size) {
        double totalPrice = 0.00;
       
        totalPrice += getMilkPrice(milk);

        if (beverage instanceof NateBeverage) {
            totalPrice += getNateBeveragePrice(size);
        } else if (beverage instanceof NicBeverage) {
            totalPrice += getNicBeveragePrice(size);
        }

        /*
         * TODO: this is no good. Move away from this approach - tight coupling 
         * to concrete beverage types
         */

        return totalPrice;
    }

    private static double getMilkPrice(MilkType milk) {
        switch (milk) {
            case REGULAR:
                return PriceGateway.getInstance().getPrice("milk-regular");
            case OAT:
                return PriceGateway.getInstance().getPrice("milk-oat");
            case ALMOND:
                return PriceGateway.getInstance().getPrice("milk-almond");
            case SOY:
                return PriceGateway.getInstance().getPrice("milk-soy");
            default:
                return 0.00;
        }
    }

    private static double getNateBeveragePrice(SizeType size) {
        switch (size) {
            case SMALL:
                return PriceGateway.getInstance().getPrice("beverage-nate-small");
            case MEDIUM:
                return PriceGateway.getInstance().getPrice("beverage-nate-medium");
            case LARGE:
                return PriceGateway.getInstance().getPrice("beverage-nate-large");
            case BOX:
                return PriceGateway.getInstance().getPrice("beverage-nate-box");
            default:
                return 0.00;
        }
    }

    private static double getNicBeveragePrice(SizeType size) {
        switch (size) {
            case SMALL:
                return PriceGateway.getInstance().getPrice("beverage-nic-small");
            case MEDIUM:
                return PriceGateway.getInstance().getPrice("beverage-nic-medium");
            case LARGE:
                return PriceGateway.getInstance().getPrice("beverage-nic-large");
            case BOX:
                return PriceGateway.getInstance().getPrice("beverage-nic-box");
            default:
                return 0.00;
        }
    }
}
