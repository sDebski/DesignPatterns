package company.factory;

import company.model.MotoCompany;
import company.model.vehicles.Car;
import company.model.vehicles.IVehicle;
import company.model.vehicles.Motorbike;
import company.model.vehicles.Truck;
import company.model.workers.FactoryWorker;

import java.util.Random;


public class MotoFactory extends AbstractFactory {
    private final String name;

    public MotoFactory(String name){
        this.name = name + "Factory";

    }

    @Override
    public void Display() {
        System.out.println("Factory: " + name + "\n Services: \n-Create car\n-Create motorbike\n-Create truck" );
    }

    @Override
    public Car getCar() {
        String[] arrOfTypes = {"sedan", "hatchback", "coupe", "minivan"};
        String[] arrOfColors = {"red", "black", "orange", "blue"};
        Random r = new Random();

        Car car = Car.Builder.builder()
                .withTypeOfCar(arrOfTypes[r.nextInt(arrOfTypes.length)])
                .withColor(arrOfColors[r.nextInt(arrOfColors.length)])
                .withEngineCapacity((Math.random() * (6-1) + 1))
                .withAirConditioning(r.nextBoolean())
                .build();

        return car;
    }

    @Override
    public Motorbike getMotorbike() {
        String[] arrOfTypes = {"Standard", "Cruiser", "Touring", "Sport Bike"};
        String[] arrOfColors = {"red", "black", "orange", "gold"};
        Random r = new Random();

        Motorbike motorbike = Motorbike.Builder.builder().withNumberOfAxles((int)(Math.floor(Math.random() * (3-2)) + 2))
                .withTypeOfMotorbike(arrOfTypes[r.nextInt(arrOfTypes.length)])
                .withColor(arrOfColors[r.nextInt(arrOfColors.length)])
                .withEngineCapacity((Math.random() * (3-.125) + .125))
                .withMotorBasket(r.nextBoolean())
                .build();

        return motorbike;
    }

    @Override
    public Truck getTruck() {
        String[] arrOfTypes = {"Pickup Truck", "Australian Road Train", "Boat Haulage", "Car Transporter"};
        String[] arrOfColors = {"red", "black", "white", "green"};
        Random r = new Random();

        Truck truck = Truck.Builder.builder().withNumberOfAxles((int)(Math.floor(Math.random() * (16-6)) + 6))
                .withTypeOfTruck(arrOfTypes[r.nextInt(arrOfTypes.length)])
                .withColor(arrOfColors[r.nextInt(arrOfColors.length)])
                .withEngineCapacity((Math.random() * (15-5) + 5))
                .build();

        return truck;
    }
}
