package factories.factory.abstrct;

import factories.model.colour.Colour;
import factories.model.shape.Shape;

public abstract class AbstractDrawFactory {
    public abstract Shape getShape();
    public abstract Colour getColor();
}
