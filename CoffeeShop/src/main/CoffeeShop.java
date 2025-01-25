import java.util.LinkedList;
import java.util.List;

public class CoffeeShop {

    private List<Order> orders;

    public CoffeeShop() {
        this.orders = new LinkedList<>();
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
