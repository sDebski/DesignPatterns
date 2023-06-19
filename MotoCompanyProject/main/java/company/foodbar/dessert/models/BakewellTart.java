package company.foodbar.dessert.models;

import company.foodbar.dessert.Dessert;

public class BakewellTart extends Dessert {

    @Override
    public String getDescription() {
        return "Bakewell Tart with: ";
    }

    @Override
    public double Cost() {
        return 9.99;
    }

}
