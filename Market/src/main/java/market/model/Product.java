package market.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    public String name;
    public Product(String name) {
        this.name = name;
    }
}
