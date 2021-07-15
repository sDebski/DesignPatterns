package company.foodbar.dessert.models;

import company.foodbar.dessert.Dessert;

public class CherriesJubilee extends Dessert {

    @Override
    public String getDescription() {
        return "Cherries Jubilee with: ";
    }

    @Override
    public double Cost() {
        return 10.99;
    }

}
