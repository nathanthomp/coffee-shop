import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new CoffeeShop();
        frame.setVisible(true);

        // All to be done through the user interface
        // CoffeeShop coffeeShop = new CoffeeShop();
        // Order order = new Order();
        
        // Beverage beverage1 = new NateBeverage(MilkType.REGULAR, SizeType.SMALL);
        // Beverage beverage2 = new NicBeverage(MilkType.REGULAR, SizeType.LARGE);

        // order.addItem(beverage1);
        // order.addItem(beverage2);

        // OrderReciept reciept = coffeeShop.submitOrder(order);
        // System.out.println(reciept);
        // What happens now?
    }
}
