package company.foodbar.maincourse.decorators;

import company.foodbar.maincourse.MainCourseDecorator;
import company.foodbar.maincourse.MainCourseMeat;

public class VegetableSaladDecorator extends MainCourseDecorator {
    public VegetableSaladDecorator(MainCourseMeat mainCourseMeat) {
        super(mainCourseMeat);
    }

    @Override
    public String getDescription() {
        return mainCourseMeat.getDescription() + "\n- Vegetable Salad";
    }

    @Override
    public double Cost() {
        return mainCourseMeat.Cost() + 2.59;
    }
}
