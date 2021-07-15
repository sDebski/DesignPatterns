package company.factory.decorator;

import company.factory.AbstractFactory;
import company.factory.MotoFactory;
import company.foodbar.dessert.Dessert;
import company.model.vehicles.Car;
import company.model.vehicles.IVehicle;
import company.model.vehicles.Motorbike;
import company.model.vehicles.Truck;

public class ChangeEngineCapacityDecorator extends FactoryDecorator {

    public ChangeEngineCapacityDecorator(AbstractFactory factory) {
        super(factory);
    }

    @Override
    public void Display() {
        factory.Display();
        System.out.println("-Change Engine Capacity");
    }

    @Override
    public Truck getTruck() {
        return factory.getTruck();
    }

    @Override
    public Car getCar() {
        return factory.getCar();
    }

    @Override
    public Motorbike getMotorbike() {
        return factory.getMotorbike();
    }

    public IVehicle changeEngineCapacity(IVehicle vehicle, String typeOfVehicle, double newEngineCapacity) {
        switch (typeOfVehicle.toLowerCase()) {
            case "car": {
                if(newEngineCapacity >= 1.0 && newEngineCapacity <= 6.0) {
                    Car vehicleChanged = (Car) vehicle;
                    vehicleChanged.setEngineCapacity(newEngineCapacity);
                    return vehicleChanged;
                }
            } break;
            case "truck": {
                if(newEngineCapacity >= 5.0 && newEngineCapacity <= 15.0) {
                    Truck vehicleChanged = (Truck) vehicle;
                    vehicleChanged.setEngineCapacity(newEngineCapacity);
                    return vehicleChanged;
                }
            } break;
            case "motorbike": {
                if(newEngineCapacity >= .125 && newEngineCapacity <= 3.0) {
                    Motorbike vehicleChanged = (Motorbike) vehicle;
                    vehicleChanged.setEngineCapacity(newEngineCapacity);
                    return vehicleChanged;
                }
            } break;
            default: throw new RuntimeException("There is no such type of vehicle.");
        }
        return null;
    }
}
