package company.foodbar.dessert.models;

import company.foodbar.dessert.Dessert;

public class BanoffeePie extends Dessert{

    @Override
    public String getDescription() {
        return "Banoffee Pie with: ";
    }

    @Override
    public double Cost() {
        return 9.99;
    }


}
