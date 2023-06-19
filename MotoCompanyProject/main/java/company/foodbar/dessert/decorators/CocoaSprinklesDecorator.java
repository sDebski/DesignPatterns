package company.foodbar.dessert.decorators;

import company.foodbar.dessert.Dessert;
import company.foodbar.dessert.DessertDecorator;

public class CocoaSprinklesDecorator extends DessertDecorator {
    public CocoaSprinklesDecorator(Dessert dessert) {
        super(dessert);
    }

    @Override
    public String getDescription() {
        return dessert.getDescription() + "\n- Cocoa sprinkles";
    }

    @Override
    public double Cost() {
        return dessert.Cost() + 1.99;
    }
}
