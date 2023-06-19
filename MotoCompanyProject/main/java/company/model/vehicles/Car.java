package company.model.vehicles;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
public class Car implements IVehicle{
    private double engineCapacity;
    private boolean airConditioning;
    private String color;
    private String typeOfCar;


    public boolean getAirConditioning() {
        return this.airConditioning;
    }

    public Car(Builder builder) {
        this.color = builder.color;
        this.engineCapacity = builder.engineCapacity;
        this.typeOfCar = builder.typeOfCar;
        this.airConditioning = builder.airConditioning;
    }

    public Car () {
        String[] arrOfTypes = {"sedan", "hatchback", "coupe", "minivan"};
        String[] arrOfColors = {"red", "black", "orange", "blue"};
        Random r = new Random();

        Car car = Car.Builder.builder()
                .withTypeOfCar(arrOfTypes[r.nextInt(arrOfTypes.length)])
                .withColor(arrOfColors[r.nextInt(arrOfColors.length)])
                .withEngineCapacity((Math.random() * (6 - 1) + 1))
                .withAirConditioning(r.nextBoolean())
                .build();

        this.engineCapacity = car.getEngineCapacity();
        this.airConditioning = car.getAirConditioning();
        this.color = car.getColor();
        this.typeOfCar = car.getTypeOfCar();
    };

    public static class Builder {
        double engineCapacity;
        boolean airConditioning;
        String color;
        String typeOfCar;


        private Builder() {}

        public static Builder builder() {
            return new Builder();
        }

        public Builder withEngineCapacity(double engineCapacity) {
            if (engineCapacity < 1.0 || engineCapacity > 6.0) {
                throw new IllegalArgumentException("Engine Capacity must be in range (1.0, 6.0).");
            }
            this.engineCapacity = engineCapacity;
            return this;
        }

        public Builder withAirConditioning(boolean airConditioning) {
            this.airConditioning = airConditioning;
            return this;
        }

        public Builder withColor(String color) {
            ArrayList<String> listOfColors = new ArrayList<>();
            listOfColors.add("red");
            listOfColors.add("orange");
            listOfColors.add("black");
            listOfColors.add("blue");

            if (!listOfColors.contains(color.toLowerCase())) {
                throw new IllegalArgumentException("Choose color from list: (orange, black, blue, red)");
            }

            this.color = color;
            return this;
        }

        public Builder withTypeOfCar(String typeOfCar) {
            ArrayList<String> listOfTypes = new ArrayList<>();
            listOfTypes.add("sedan");
            listOfTypes.add("coupe");
            listOfTypes.add("hatchback");
            listOfTypes.add("minivan");

            if (!listOfTypes.contains(typeOfCar.toLowerCase())) {
                throw new IllegalArgumentException("Choose type of car from list : (sedan, coupe, hatchback, minivan)");
            }
            this.typeOfCar= typeOfCar;
            return this;
        }

        public Car build() {
            if (engineCapacity != 0 && color != null && typeOfCar != null ) {
                return new Car(this);
            } else throw new RuntimeException("Not all variables are set.");
        }

        @Override
        public String toString() {
            return String.format("Car: \nEngine Capacity: %.2f \n Air Conditioning: %b \n Color: %s \n Type of car: %s ",
                    this.engineCapacity, this.airConditioning, this.color, this.typeOfCar);
        }
    }
}
