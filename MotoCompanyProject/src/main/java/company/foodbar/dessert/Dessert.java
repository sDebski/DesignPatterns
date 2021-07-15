package company.foodbar.dessert;

import company.foodbar.IDish;

public abstract class Dessert implements IDish {
    public String description = "Unknown kind of dessert";
    public abstract double Cost();

}
