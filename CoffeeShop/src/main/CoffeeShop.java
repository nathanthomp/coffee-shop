import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CoffeeShop extends JFrame {

    private static final String FRAME_NAME = "Nic & Nate's Coffee Shop";
    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 500;

    private List<Order> orders;

    public CoffeeShop() {
        this.orders = new LinkedList<>();

        //
        this.setTitle(FRAME_NAME);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //


        this.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);

        this.add(new CoffeeShopNavigation(), BorderLayout.WEST);
        this.add(panel, BorderLayout.CENTER);

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
