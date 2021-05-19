package factories.factory.abstrct;

import factories.model.colour.*;
import factories.model.shape.*;

import java.util.Random;


public class ShapeDrawFactory extends AbstractDrawFactory {
    private static ShapeDrawFactory instance;

    private ShapeDrawFactory(){}

    public static ShapeDrawFactory getInstance() {
        if (instance == null) {
            synchronized (ShapeDrawFactory.class){
                if (instance == null) {
                    instance = new ShapeDrawFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public Shape getShape() {
        return new Triangle();
    }

    @Override
    public Colour getColor() {
        return new Red();
    }
}
