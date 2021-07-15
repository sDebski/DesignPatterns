package company.foodbar.maincourse;

public abstract class MainCourseDecorator extends MainCourseMeat {
    protected MainCourseMeat mainCourseMeat;

    protected MainCourseDecorator (MainCourseMeat mainCourseMeat) {
        this.mainCourseMeat = mainCourseMeat;
    }

    @Override
    public abstract String getDescription();
}
