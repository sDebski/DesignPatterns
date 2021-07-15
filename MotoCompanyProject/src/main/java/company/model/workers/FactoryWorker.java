package company.model.workers;

import company.model.workers.composite.CompositeElement;


public class FactoryWorker extends CompositeElement {

    public FactoryWorker(String name) {
        super(name);
    }

    @Override
    public void Display(int indent) {
        super.Display(indent);
        System.out.println("Factory Worker");
    }
}

