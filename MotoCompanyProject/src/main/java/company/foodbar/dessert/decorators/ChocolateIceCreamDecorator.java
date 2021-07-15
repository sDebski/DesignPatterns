package company.foodbar.dessert.decorators;

import company.foodbar.dessert.Dessert;
import company.foodbar.dessert.DessertDecorator;

public class ChocolateIceCreamDecorator extends DessertDecorator {
    public ChocolateIceCreamDecorator(Dessert dessert) {
        super(dessert);
    }

    @Override
    public String getDescription() {
        return dessert.getDescription() + "\n- Vanilla Ice cream";
    }

    @Override
    public double Cost() {
        return dessert.Cost() + 3.19;
    }
}
