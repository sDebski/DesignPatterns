package company.factory;

import company.factory.decorator.ChangeEngineCapacityDecorator;
import company.factory.decorator.RepaintVehicleDecorator;
import company.model.vehicles.Car;

import static org.assertj.core.api.Assertions.assertThat;

import company.model.vehicles.Motorbike;
import company.model.vehicles.Truck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FactoryTest {
    MotoFactory motoFactory = new MotoFactory("MotoCompany");

    @Test
    void checkGetCar() {
        Car car = motoFactory.getCar();

        assertThat(car).isNotNull();
        System.out.println("Car: \nEngine Capacity: " + car.getEngineCapacity() +
                " \n Air Conditioning: " + car.getAirConditioning() +
                " \n Color: " + car.getColor() +
                " \n Type of car: " + car.getTypeOfCar());
    }

    @Test
    void checkGetMotorbike() {
        Motorbike motorbike = motoFactory.getMotorbike();

        assertThat(motorbike).isNotNull();
        System.out.println("Motorbike: \nEngine Capacity: " + motorbike.getEngineCapacity() +
                " \n Motor Basket: " + motorbike.isMotorBasket() +
                " \n Number of Axles: " + motorbike.getNumberOfAxles() +
                " \n Color: " + motorbike.getColor() +
                " \n Type of motorbike: " + motorbike.getTypeOfMotorbike());


    }

    @Test
    void checkGetTruck() {
        Truck truck = motoFactory.getTruck();

        assertThat(truck).isNotNull();
        System.out.println("Truck: \nEngine Capacity: " + truck.getEngineCapacity() +
                " \n Number of Axles: " + truck.getNumberOfAxles() +
                " \n Color: " + truck.getColor() +
                " \n Type of truck: " + truck.getTypeOfTruck());


    }


    @Test
    void checkCreationOfVehiclesForSupplierFactory(){
        Car car = (Car) SupplierFactory.getVehicle("car");
        Motorbike motorbike = (Motorbike) SupplierFactory.getVehicle("motorbike");
        Truck truck = (Truck) SupplierFactory.getVehicle("truck");

        assertThat(car).isNotNull();
        assertThat(motorbike).isNotNull();
        assertThat(truck).isNotNull();
    }

    @Test
    void checkCreationOfVehiclesForReflectionFactory(){
        Car car = (Car) ReflectionFactory.getVehicle("car");
        Motorbike motorbike = (Motorbike) ReflectionFactory.getVehicle("motorbike");
        Truck truck = (Truck) ReflectionFactory.getVehicle("truck");

        assertThat(car).isNotNull();
        assertThat(motorbike).isNotNull();
        assertThat(truck).isNotNull();
    }

    @Test
    void checkCreationOfVehiclesForFactoryWithMethod(){
        FactoryWithMethod factoryWithMethod = FactoryWithMethod.getInstance();
        Car car = (Car) factoryWithMethod.getVehicle("car");
        Motorbike motorbike = (Motorbike) factoryWithMethod.getVehicle("motorbike");
        Truck truck = (Truck) factoryWithMethod.getVehicle("truck");

        assertThat(car).isNotNull();
        assertThat(motorbike).isNotNull();
        assertThat(truck).isNotNull();
    }

    @Test
    public void checkFactoryDecoratorChangeEngineCapacity() {
        AbstractFactory localMotoFactory = new MotoFactory("MotoFactory");

        Truck truck = localMotoFactory.getTruck();

        ChangeEngineCapacityDecorator factoryWithChangingEnginesCapacity = new ChangeEngineCapacityDecorator(localMotoFactory);

        truck = (Truck) factoryWithChangingEnginesCapacity.changeEngineCapacity(truck, "truck", 12.0);

        factoryWithChangingEnginesCapacity.Display();

        Assertions.assertEquals(truck.getEngineCapacity(), 12.0);
    }

    @Test
    public void checkFactoryDecoratorRepaintVehicle() {
        AbstractFactory localMotoFactory = new MotoFactory("MotoFactory");

        Motorbike motorbike = localMotoFactory.getMotorbike();

        RepaintVehicleDecorator repaintVehicleDecorator = new RepaintVehicleDecorator(localMotoFactory);

        motorbike = (Motorbike) repaintVehicleDecorator.changeEngineCapacity(motorbike, "motorbike", "black");

        repaintVehicleDecorator.Display();

        Assertions.assertEquals(motorbike.getColor(), "black");
    }

    @Test
    public void checkFactoryTwoDecorators() {
        AbstractFactory localMotoFactory = new MotoFactory("MotoFactory");

        RepaintVehicleDecorator repaintVehicleDecorator = new RepaintVehicleDecorator(localMotoFactory);

        ChangeEngineCapacityDecorator factoryChanged = new ChangeEngineCapacityDecorator(repaintVehicleDecorator);

        factoryChanged.Display();

        assertThat(factoryChanged).isNotNull();
    }

}
