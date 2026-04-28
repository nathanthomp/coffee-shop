package coffeeshop.domain.items;

import java.math.BigDecimal;

public final class Beverage implements Item {

    private final String name;
    private final BigDecimal price;
    private final String description;

    public Beverage(String name, BigDecimal price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public BigDecimal price() {
        return price;
    }

    @Override
    public String description() {
        return description;
    }
}
