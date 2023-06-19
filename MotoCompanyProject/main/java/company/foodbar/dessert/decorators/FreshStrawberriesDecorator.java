package company.foodbar.dessert.decorators;

import company.foodbar.dessert.Dessert;
import company.foodbar.dessert.DessertDecorator;

public class FreshStrawberriesDecorator extends DessertDecorator {
    public FreshStrawberriesDecorator(Dessert dessert) {
        super(dessert);
    }

    @Override
    public String getDescription() {
        return dessert.getDescription() + "\n- Fresh Strawberries";
    }

    @Override
    public double Cost() {
        return dessert.Cost() + 5.99;
    }
}
