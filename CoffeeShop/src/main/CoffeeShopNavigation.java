import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CoffeeShopNavigation extends JPanel {
    public CoffeeShopNavigation() {
        this.setBackground(Color.BLACK);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setSize(50, 250);

        this.add(new JButton("Button 1"));
        this.add(new JButton("Button 2"));
        this.add(new JButton("Button 3"));
    }
}
