package company.foodbar.maincourse;

import company.foodbar.IDish;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class MainCourseMeat implements IDish {
    public String description = "Unknown kind of meat";
    public abstract double Cost();
}
