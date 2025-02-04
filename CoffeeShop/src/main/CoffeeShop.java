import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

public class CoffeeShop extends JFrame {

    private List<Order> orders;

    public CoffeeShop() {
        this.orders = new LinkedList<>();

        this.setTitle("Nic & Nate's Coffee Shop");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500, 250);
    }

    public void viewMenu() {
        // Could add a required field on beverages to display for menu
        // Then the only modification would be to call the static member
    }

    public OrderReciept submitOrder(Order order) {
        this.orders.add(order);
        return OrderReciept.create(order);
    }
}
