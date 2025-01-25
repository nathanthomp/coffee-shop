import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Order implements Iterable<Beverage> {
    private int number;
    private List<Beverage> items;

    public Order() {
        this.number = 10001;
        this.items = new LinkedList<>();
    }

    public int getNumber() {
        return this.number;
    }

    public void addItem(Beverage beverage) {
        this.items.add(beverage);
    }

    public void removeItem(Beverage beverage) {
        this.items.remove(beverage);
    }

    public boolean containsItem(Beverage beverage) {
        return this.items.contains(beverage);
    }

    public double getTotalPrice() {
        double totalPrice = 0.00;
        if (this.items.isEmpty()) {
            return totalPrice;
        }

        for (Beverage beverage : items) {
            totalPrice += beverage.getPrice();
        }

        return totalPrice;
    }

    @Override
    public Iterator<Beverage> iterator() {
        return this.items.iterator();
    }
}
