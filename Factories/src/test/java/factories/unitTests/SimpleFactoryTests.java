package factories.unitTests;

import factories.factory.simple.SimpleColourFactory;
import factories.model.colour.Colour;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleFactoryTests {
    @Test
    void createColours(){
        SimpleColourFactory factory = SimpleColourFactory.getInstance();
        Colour red = factory.getColour("red");
        Colour blue = factory.getColour("blue");
        Colour green = factory.getColour("green");

        assertEquals("Red",red.getColorName());
        assertEquals("Blue",blue.getColorName());
        assertEquals("Green",green.getColorName());
    }

    @Test
    void createNotExistingColour(){
        SimpleColourFactory factory = SimpleColourFactory.getInstance();
        assertThrows(IllegalStateException.class, () -> factory.getColour("WRONG"));
    }
}
