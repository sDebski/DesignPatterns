package company.foodbar.maincourse.meatsmodels;

import company.foodbar.maincourse.MainCourseMeat;

public class Schnitzel extends MainCourseMeat {
    @Override
    public String getDescription() {
        return "Schnitzel with: ";
    }

    @Override
    public double Cost() {
        return 12.99;
    }
}
