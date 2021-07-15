package company.model.vehicles;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;


@Getter
@Setter
public class Truck implements IVehicle {

    private double engineCapacity;
    private int numberOfAxles;
    private String color;
    private String typeOfTruck;
    //Types of Trucks
    //Pickup Truck
    //Australian Road Train
    //Boat Haulage
    //Car Transporter
    //Cement Truck
    //Chiller Trucks/Reefers

    public Truck() {
        String[] arrOfTypes = {"Pickup Truck", "Australian Road Train", "Boat Haulage", "Car Transporter"};
        String[] arrOfColors = {"red", "black", "white", "green"};
        Random r = new Random();

        Truck truck = Truck.Builder.builder().withNumberOfAxles((int)(Math.floor(Math.random() * (16-6)) + 6))
                .withTypeOfTruck(arrOfTypes[r.nextInt(arrOfTypes.length)])
                .withColor(arrOfColors[r.nextInt(arrOfColors.length)])
                .withEngineCapacity((Math.random() * (15-5) + 5))
                .build();

        this.typeOfTruck = truck.getTypeOfTruck();
        this.numberOfAxles = truck.getNumberOfAxles();
        this.color = truck.getColor();
        this.engineCapacity = truck.getEngineCapacity();
    };


    public Truck (Builder builder) {
        this.engineCapacity = builder.engineCapacity;
        this.numberOfAxles = builder.numberOfAxles;
        this.color = builder.color;
        this.typeOfTruck = builder.typeOfTruck;
    }

    public static class Builder {
        double engineCapacity;
        int numberOfAxles;
        String color;
        String typeOfTruck;

        private Builder(){};

        public static Builder builder() {
            return new Builder();
        }

        public Builder withEngineCapacity(double engineCapacity) {
            if (engineCapacity < 5.0 || engineCapacity > 15.0) {
                throw new IllegalArgumentException("Engine Capacity must be in range (5.0, 15.0).");
            }
            this.engineCapacity = engineCapacity;
            return this;
        }

        public Builder withNumberOfAxles(int numberOfAxles) {
            if (numberOfAxles < 4 || numberOfAxles > 16 ) {
                throw new IllegalArgumentException("Number of axles must be in range (4,16).");
            }
            this.numberOfAxles = numberOfAxles;
            return this;
        }

        public Builder withColor(String color) {
            ArrayList<String> listOfColors = new ArrayList<>();
            listOfColors.add("red");
            listOfColors.add("green");
            listOfColors.add("black");
            listOfColors.add("white");

            if( !listOfColors.contains(color) ) {
                throw new IllegalArgumentException("Choose color from list: (white, black, green, red)");
            }

            this.color = color;
            return this;
        }

        public Builder withTypeOfTruck(String typeOfTruck) {
            this.typeOfTruck = typeOfTruck;
            return this;
        }

        public Truck build() {
            if ( engineCapacity != 0 && color != null && typeOfTruck != null && numberOfAxles != 0 ) {
                return new Truck(this);
            }
            else throw new RuntimeException("Not all variables are set.");
        }

    }
}
