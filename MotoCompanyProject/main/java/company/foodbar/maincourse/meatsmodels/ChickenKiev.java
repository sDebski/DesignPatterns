package company.foodbar.maincourse.meatsmodels;

import company.foodbar.maincourse.MainCourseMeat;

public class ChickenKiev extends MainCourseMeat {
    @Override
    public String getDescription() {
        return "Chicken Kiev with: ";
    }

    @Override
    public double Cost() {
        return 13.99;
    }
}
