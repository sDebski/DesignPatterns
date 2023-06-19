package factories.factory.method;

import factories.model.animal.*;

public class MammalFactory extends AnimalFactory {
    private static MammalFactory instance;

    private MammalFactory() {}

    public static MammalFactory getInstance() {
        if (instance == null) {
            synchronized (MammalFactory.class){
                if (instance == null) {
                    instance = new MammalFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public Mammal getAnimal(String name) {
        switch (name.toLowerCase()) {
            case "cat":
                return new Cat();
            case "dog":
                return new Dog();
            case "Cow":
                return new Cow();
            default:
                throw new IllegalStateException(name + " <- there is no such Bird.");
        }
    }
}
