package factories.unitTests;
import factories.factory.register.ReflectionShapeFactory;
import factories.factory.register.SupplierShapeFactory;
import factories.model.shape.Rectangle;
import factories.model.shape.Shape;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class SupplierTests {
    @Test
    void getNotExistingShape(){
        assertThrows(IllegalStateException.class,
                () -> SupplierShapeFactory.getShape("WRONG"));
    }

    @Test
    void addNewShapeToFactory(){
        assertThrows(IllegalStateException.class,
                () -> SupplierShapeFactory.getShape("WRONG"));

        SupplierShapeFactory.registerSupplier("rectangle", Rectangle::new);

        Shape rectangle = SupplierShapeFactory.getShape("rectangle");
        assertThat(rectangle, instanceOf(Rectangle.class));
        assertEquals("Rectangle",rectangle.getShapeName());
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
