package company.foodbar.dessert.decorators;

import company.foodbar.dessert.Dessert;
import company.foodbar.dessert.DessertDecorator;

public class WhippedCreamDecorator extends DessertDecorator {
    public WhippedCreamDecorator(Dessert dessert) {
        super(dessert);
    }

    @Override
    public String getDescription() {
        return dessert.getDescription() + "\n- Whipped cream";
    }

    @Override
    public double Cost() {
        return dessert.Cost() + .99;
    }
}
