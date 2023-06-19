package factories.factory.simple;

import factories.model.colour.*;

public class SimpleColourFactory {
    private static SimpleColourFactory instance;

    private SimpleColourFactory() {};

    public static SimpleColourFactory getInstance() {
        if (instance == null) {
            synchronized (SimpleColourFactory.class) {
                if (instance == null) {
                    instance = new SimpleColourFactory();
                }
            }
        }
        return instance;
    }

    public Colour getColour(String name) {
        switch (name.toLowerCase()) {
            case "red":
                return new Red();
            case "blue":
                return new Blue();
            case "green":
                return new Green();
            default:
                throw new IllegalStateException(name + " <- such Colour does not exist.");
        }
    }
}
