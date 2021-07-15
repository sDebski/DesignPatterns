package company.foodbar.maincourse.decorators;

import company.foodbar.maincourse.MainCourseDecorator;
import company.foodbar.maincourse.MainCourseMeat;

public class CompoteDecorator extends MainCourseDecorator {
    public CompoteDecorator(MainCourseMeat mainCourseMeat) {
        super(mainCourseMeat);
    }

    @Override
    public String getDescription() {
        return mainCourseMeat.getDescription() + "\n- Fruit Salad";
    }

    @Override
    public double Cost() {
        return mainCourseMeat.Cost() + 2.99;
    }
}
