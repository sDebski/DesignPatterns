package company.foodbar.maincourse.decorators;

import company.foodbar.maincourse.MainCourseDecorator;
import company.foodbar.maincourse.MainCourseMeat;

public class KetchupDecorator extends MainCourseDecorator {
    public KetchupDecorator(MainCourseMeat mainCourseMeat) {
        super(mainCourseMeat);
    }

    @Override
    public String getDescription() {
        return mainCourseMeat.getDescription() + "\n- Ketchup";
    }

    @Override
    public double Cost() {
        return mainCourseMeat.Cost() + 0.59;
    }
}
