package company.foodbar.maincourse.meatsmodels;

import company.foodbar.maincourse.MainCourseMeat;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class PorkNeck extends MainCourseMeat {

    @Override
    public String getDescription() {
        return "Pork Neck with: ";
    }

    @Override
    public double Cost() {
        return 10.99;
    }
}
