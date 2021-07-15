package company.model.vehicles;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Setter
@Getter
public class Motorbike implements IVehicle {
    private double engineCapacity;
    private int numberOfAxles;
    private boolean motorBasket;
    private String color;
    private String typeOfMotorbike;


    public Motorbike(Builder builder) {
        this.color = builder.color;
        this.engineCapacity = builder.engineCapacity;
        this.motorBasket = builder.motorBasket;
        this.typeOfMotorbike = builder.typeOfMotorbike;
        this.numberOfAxles = builder.numberOfAxles;
    }

    public Motorbike () {
        String[] arrOfTypes = {"Standard", "Cruiser", "Touring", "Sport Bike"};
        String[] arrOfColors = {"red", "black", "orange", "gold"};
        Random r = new Random();

        Motorbike motorbike = Motorbike.Builder.builder().withNumberOfAxles((int)(Math.floor(Math.random() * (3-2)) + 2))
                .withTypeOfMotorbike(arrOfTypes[r.nextInt(arrOfTypes.length)])
                .withColor(arrOfColors[r.nextInt(arrOfColors.length)])
                .withEngineCapacity((Math.random() * (3-.125) + .125))
                .withMotorBasket(r.nextBoolean())
                .build();

        this.engineCapacity = motorbike.getEngineCapacity();
        this.typeOfMotorbike = motorbike.getTypeOfMotorbike();
        this.motorBasket = motorbike.isMotorBasket();
        this.numberOfAxles = motorbike.getNumberOfAxles();
        this.color = motorbike.getColor();
    }

    public static class Builder {
        double engineCapacity;
        int numberOfAxles;
        boolean motorBasket;
        String color;
        String typeOfMotorbike;
//        Standard. ...
//        Cruiser. ...
//        Sport Bike. ...
//        Touring. ...

        private Builder() {}

        public static Builder builder() {
            return new Builder();
        }

        public Builder withEngineCapacity(double engineCapacity) {
            if (engineCapacity < .125 || engineCapacity > 3) {
                throw new IllegalArgumentException("Engine Capacity must be in range (.125, 3.0).");
            }
            this.engineCapacity = engineCapacity;
            return this;
        }

        public Builder withMotorBasket(boolean motorBasket) {
            this.motorBasket = motorBasket;
            return this;
        }

        public Builder withNumberOfAxles(int numberOfAxles) {
            if (numberOfAxles < 2 || numberOfAxles > 3) {
                throw new IllegalArgumentException("Number of axles must be in range (2,3).");
            }
            this.numberOfAxles = numberOfAxles;
            return this;
        }

        public Builder withColor(String color) {
            ArrayList<String> listOfColors = new ArrayList<>();
            listOfColors.add("red");
            listOfColors.add("orange");
            listOfColors.add("black");
            listOfColors.add("gold");

            if (!listOfColors.contains(color)) {
                throw new IllegalArgumentException("Choose color from list: (orange, black, gold, red)");
            }

            this.color = color;
            return this;
        }

        public Builder withTypeOfMotorbike(String typeOfMotorbike) {
            ArrayList<String> listOfTypesOfMotorbikes = new ArrayList<>();
            listOfTypesOfMotorbikes.add("standard");
            listOfTypesOfMotorbikes.add("cruiser");
            listOfTypesOfMotorbikes.add("sport bike");
            listOfTypesOfMotorbikes.add("touring");

            if (!listOfTypesOfMotorbikes.contains(typeOfMotorbike.toLowerCase())) {
                throw new IllegalArgumentException("Choose a type of car from list: (standard, cruiser, sport bike, touring)");
            }
            this.typeOfMotorbike = typeOfMotorbike;
            return this;
        }

        public Motorbike build() {
            if (engineCapacity != 0 && color != null && typeOfMotorbike != null && numberOfAxles != 0 ) {
                return new Motorbike(this);
            } else throw new RuntimeException("Not all variables are set.");
        }
    }
}
