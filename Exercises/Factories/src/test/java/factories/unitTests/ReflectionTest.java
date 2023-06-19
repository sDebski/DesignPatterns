package factories.unitTests;

import factories.model.shape.*;
import factories.factory.register.ReflectionShapeFactory;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertThat;

public class ReflectionTest {
    @Test
    void getNotExistingShape(){
        assertThrows(IllegalStateException.class,
                () -> ReflectionShapeFactory.getShape("WRONG"));
    }

    @Test
    void addNewClassToFactory(){
        assertThrows(IllegalStateException.class,
                () -> ReflectionShapeFactory.getShape("rectangle"));

        ReflectionShapeFactory.registerType("rectangle", Rectangle.class);

        Shape rectangle = ReflectionShapeFactory.getShape("rectangle");
        assertThat(rectangle, instanceOf(Rectangle.class));
        assertEquals("Rectangle", rectangle.getShapeName());
    }

    @Test
    void getShapes(){
        Shape square = ReflectionShapeFactory.getShape("square");
        Shape rectangle = ReflectionShapeFactory.getShape("triangle");
        Shape circle = ReflectionShapeFactory.getShape("circle");

        assertEquals("Square",square.getShapeName());
        assertEquals("Triangle",rectangle.getShapeName());
        assertEquals("Circle",circle.getShapeName());
    }
}
