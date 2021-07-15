package company.factory.decorator;

import company.factory.AbstractFactory;
import company.model.vehicles.Car;
import company.model.vehicles.IVehicle;
import company.model.vehicles.Motorbike;
import company.model.vehicles.Truck;

import java.util.ArrayList;

public class RepaintVehicleDecorator extends FactoryDecorator {

    public RepaintVehicleDecorator(AbstractFactory factory) {
        super(factory);
    }

    @Override
    public void Display() {
        factory.Display();
        System.out.println("-Repaint vehicle");
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

    public IVehicle changeEngineCapacity(IVehicle vehicle, String typeOfVehicle, String color) {
        IVehicle vehicleToReturn;
        ArrayList<String> listOfColors = new ArrayList<>();
        listOfColors.add("red");
        listOfColors.add("orange");
        listOfColors.add("black");
        listOfColors.add("gold");
        listOfColors.add("yellow");
        listOfColors.add("brown");
        if( !listOfColors.contains(color)) throw new RuntimeException("This color is not available");

        switch (typeOfVehicle.toLowerCase()) {
            case "car": {
                Car vehicleChanged = (Car) vehicle;
                vehicleChanged.setColor(color);
                vehicleToReturn = vehicleChanged;
            } break;
            case "truck": {
                Truck vehicleChanged = (Truck) vehicle;
                vehicleChanged.setColor(color);
                vehicleToReturn = vehicleChanged;

            } break;
            case "motorbike": {
                Motorbike vehicleChanged = (Motorbike) vehicle;
                vehicleChanged.setColor(color);
                vehicleToReturn = vehicleChanged;
            } break;
            default: throw new RuntimeException("There is no such type of vehicle.");
        }

        return vehicleToReturn;
    }
}
