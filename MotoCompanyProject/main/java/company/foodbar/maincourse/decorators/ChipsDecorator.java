package company.foodbar.maincourse.decorators;

import company.foodbar.maincourse.MainCourseDecorator;
import company.foodbar.maincourse.MainCourseMeat;

public class ChipsDecorator extends MainCourseDecorator {
    public ChipsDecorator(MainCourseMeat mainCourseMeat) {
        super(mainCourseMeat);
    }

    @Override
    public String getDescription() {
        return mainCourseMeat.getDescription() + "\n- Chips";
    }

    @Override
    public double Cost() {
        return mainCourseMeat.Cost() + 6.99;
    }
}
