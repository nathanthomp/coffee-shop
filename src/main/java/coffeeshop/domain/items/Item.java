package coffeeshop.domain.items;

import java.math.BigDecimal;

public interface Item {

    String name();

    BigDecimal price();

    String description();
}
