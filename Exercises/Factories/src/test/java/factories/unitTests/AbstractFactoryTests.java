package factories.unitTests;

import factories.factory.abstrct.ColourDrawFactory;
import factories.factory.abstrct.ShapeDrawFactory;
import factories.model.colour.Colour;
import factories.model.shape.Shape;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AbstractFactoryTests {
    @Test
    void getColoursAndShapesAndFactories() {
        ColourDrawFactory colourF = ColourDrawFactory.getInstance();
        Shape ShapeFromColourF = colourF.getShape();
        Colour ColourFromColourF = colourF.getColor();

        String resultShapeFromColourFactory = "Square";
        String resultColourFromColourFactory = "Green";

        assertEquals(resultColourFromColourFactory, ColourFromColourF.getColorName());
        assertEquals(resultShapeFromColourFactory,ShapeFromColourF.getShapeName());

        ShapeDrawFactory shapeF = ShapeDrawFactory.getInstance();
        Shape ShapeFromShapeF = shapeF.getShape();
        Colour ColourFromShapeF = shapeF.getColor();

        String resultShapeFromShapeFactory = "Triangle";
        String resultColourFromShapeFactory = "Red";

        assertEquals(resultColourFromShapeFactory, ColourFromShapeF.getColorName());
        assertEquals(resultShapeFromShapeFactory, ShapeFromShapeF.getShapeName());

    }
}
