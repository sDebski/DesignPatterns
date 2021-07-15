package company.factory;

import company.model.vehicles.*;

import java.util.Random;

public class FactoryWithMethod {

    private static FactoryWithMethod instance;

    private FactoryWithMethod() {}

    public static FactoryWithMethod getInstance() {
        if (instance == null) {
            synchronized (FactoryWithMethod.class){
                if (instance == null) {
                    instance = new FactoryWithMethod();
                }
            }
        }
        return instance;
    }

    public IVehicle getVehicle(String name) {
        IVehicle vehicle;
        switch (name.toLowerCase()) {
            case "truck": {
                String[] arrOfTypes = {"Pickup Truck", "Australian Road Train", "Boat Haulage", "Car Transporter"};
                String[] arrOfColors = {"red", "black", "white", "green"};
                Random r = new Random();

                Truck truck = Truck.Builder.builder().withNumberOfAxles((int)(Math.floor(Math.random() * (16-6)) + 6))
                        .withTypeOfTruck(arrOfTypes[r.nextInt(arrOfTypes.length)])
                        .withColor(arrOfColors[r.nextInt(arrOfColors.length)])
                        .withEngineCapacity((Math.random() * (15-5) + 5))
                        .build();

                vehicle = truck;

            }
            break;
            case "motorbike": {
                String[] arrOfTypes = {"Standard", "Cruiser", "Touring", "Sport Bike"};
                String[] arrOfColors = {"red", "black", "orange", "gold"};
                Random r = new Random();

                Motorbike motorbike = Motorbike.Builder.builder().withNumberOfAxles((int) (Math.floor(Math.random() * (3 - 2)) + 2))
                        .withTypeOfMotorbike(arrOfTypes[r.nextInt(arrOfTypes.length)])
                        .withColor(arrOfColors[r.nextInt(arrOfColors.length)])
                        .withEngineCapacity((Math.random() * (3 - .125) + .125))
                        .withMotorBasket(r.nextBoolean())
                        .build();

                vehicle = motorbike;

            }
            break;
            case "car": {
                String[] arrOfTypes = {"sedan", "hatchback", "coupe", "minivan"};
                String[] arrOfColors = {"red", "black", "orange", "blue"};
                Random r = new Random();

                Car car = Car.Builder.builder()
                        .withTypeOfCar(arrOfTypes[r.nextInt(arrOfTypes.length)])
                        .withColor(arrOfColors[r.nextInt(arrOfColors.length)])
                        .withEngineCapacity((Math.random() * (6 - 1) + 1))
                        .withAirConditioning(r.nextBoolean())
                        .build();

                vehicle = car;

            }
            break;
            default:
                throw new RuntimeException("There is no such vehicle");
        }

        return vehicle;
    }

}
