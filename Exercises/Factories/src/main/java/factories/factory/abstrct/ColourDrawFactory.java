package factories.factory.abstrct;

import factories.model.colour.*;
import factories.model.shape.*;

import java.util.Random;

public class ColourDrawFactory extends AbstractDrawFactory {
    private static ColourDrawFactory instance;

    private ColourDrawFactory(){}

    public static ColourDrawFactory getInstance() {
        if (instance == null) {
            synchronized (ColourDrawFactory.class){
                if (instance == null) {
                    instance = new ColourDrawFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public Shape getShape() {
        return new Square();
    }

    @Override
    public Colour getColor() {
        return new Green();
    }
}
