package company.foodbar.dessert.models;

import company.foodbar.dessert.Dessert;

public class ChristmasPudding extends Dessert {

    @Override
    public String getDescription() {
        return "Christmas Pudding with: ";
    }

    @Override
    public double Cost() {
        return 9.99;
    }

}
