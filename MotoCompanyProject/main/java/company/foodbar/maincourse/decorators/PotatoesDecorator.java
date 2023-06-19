package company.foodbar.maincourse.decorators;

import company.foodbar.maincourse.MainCourseDecorator;
import company.foodbar.maincourse.MainCourseMeat;

public class PotatoesDecorator extends MainCourseDecorator {

    public PotatoesDecorator(MainCourseMeat mainCourseMeat) {
        super(mainCourseMeat);
    }

    @Override
    public String getDescription() {
        return mainCourseMeat.getDescription() + "\n- Potatoes";
    }

    @Override
    public double Cost() {
        return mainCourseMeat.Cost() + 3.99;
    }
}
