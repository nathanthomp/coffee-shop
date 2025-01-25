public class OrderReciept {
    private Order order;

    private OrderReciept(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Order \t\t#" + order.getNumber());
        stringBuilder.append("\n\n");
        for (Beverage beverage : order) {
            stringBuilder.append(beverage.getDescription() + " \t$" + beverage.getPrice());
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n");
        stringBuilder.append("Total Price: \t$" + order.getTotalPrice());

        return stringBuilder.toString();
    }

    public static OrderReciept create(Order order) {
        return new OrderReciept(order);
    }
}
