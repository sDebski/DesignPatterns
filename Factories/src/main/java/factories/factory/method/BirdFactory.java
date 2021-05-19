package factories.factory.method;

import factories.model.animal.*;

public class BirdFactory extends AnimalFactory {
    private static BirdFactory instance;

    private BirdFactory() {}

    public static BirdFactory getInstance() {
        if (instance == null) {
            synchronized (BirdFactory.class){
                if (instance == null) {
                    instance = new BirdFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public Bird getAnimal(String name) {
        switch (name.toLowerCase()) {
            case "duck":
                return new Duck();
            case "chicken":
                return new Chicken();
            case "penguin":
                return new Penguin();
            default:
                throw new IllegalStateException(name + " <- there is no such Bird.");
        }
    }
}
