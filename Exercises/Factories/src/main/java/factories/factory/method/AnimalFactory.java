package factories.factory.method;

import factories.model.animal.Animal;

public abstract class AnimalFactory {
    public abstract Animal getAnimal(String name);
}
