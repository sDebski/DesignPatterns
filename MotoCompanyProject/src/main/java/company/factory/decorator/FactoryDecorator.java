package company.factory.decorator;

import company.factory.AbstractFactory;
import company.factory.FactoryWithMethod;
import company.model.vehicles.Truck;

public abstract class FactoryDecorator extends AbstractFactory {
    protected AbstractFactory factory;

    protected FactoryDecorator(AbstractFactory factory) {
        this.factory = factory;
    }

}
