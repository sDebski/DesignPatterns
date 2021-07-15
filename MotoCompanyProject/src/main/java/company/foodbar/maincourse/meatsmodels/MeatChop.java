package company.foodbar.maincourse.meatsmodels;

import company.foodbar.maincourse.MainCourseMeat;

public class MeatChop extends MainCourseMeat {
    @Override
    public String getDescription() {
        return "Meat Chop with: ";
    }

    @Override
    public double Cost() {
        return 18.99;
    }
}
