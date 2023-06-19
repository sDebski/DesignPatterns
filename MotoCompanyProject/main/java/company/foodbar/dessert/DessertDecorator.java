package company.foodbar.dessert;

import company.foodbar.maincourse.MainCourseMeat;

public abstract class DessertDecorator extends Dessert {
    protected Dessert dessert;

    protected DessertDecorator (Dessert dessert) {
        this.dessert = dessert;
    }

}

