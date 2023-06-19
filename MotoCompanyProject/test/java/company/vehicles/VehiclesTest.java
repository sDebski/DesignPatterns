package company.vehicles;

import company.model.vehicles.Car;
import company.model.vehicles.Motorbike;
import company.model.vehicles.Truck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
public class VehiclesTest {

    @Test
    void createNewTruck() {
        Truck truck = Truck.Builder.builder().withTypeOfTruck("Cement truck")
                .withColor("red")
                .withEngineCapacity(7.0)
                .withNumberOfAxles(6)
                .build();

        assertEquals(truck.getTypeOfTruck(), "Cement truck");
        assertEquals(truck.getColor(), "red");
        Assertions.assertEquals(truck.getEngineCapacity(), 7.0);
        Assertions.assertEquals(truck.getNumberOfAxles(), 6);
    }

    @Test
    void createNewCar() {
        Car car = Car.Builder.builder().withTypeOfCar("sedan")
                .withColor("blue")
                .withEngineCapacity(4.0)
                .withAirConditioning(true)
                .build();

        assertEquals(car.getTypeOfCar(), "sedan");
        assertEquals(car.getColor(), "blue");
        Assertions.assertEquals(car.getEngineCapacity(), 4.0);
        Assertions.assertEquals(car.getAirConditioning(), true);
    }

    @Test
    void createNewMotorbike() {
        Motorbike motorbike = Motorbike.Builder.builder().withTypeOfMotorbike("touring")
                .withColor("gold")
                .withEngineCapacity(2.5)
                .withMotorBasket(false)
                .withNumberOfAxles(2)
                .build();

        assertEquals(motorbike.getTypeOfMotorbike(), "touring");
        assertEquals(motorbike.getColor(), "gold");
        Assertions.assertEquals(motorbike.getEngineCapacity(), 2.5);
        Assertions.assertEquals(motorbike.isMotorBasket(), false);
        Assertions.assertEquals(motorbike.getNumberOfAxles(), 2);
    }

    @Test
    public void throwErrorWhenClientProvideWrongArguments() {
        org.assertj.core.api.Assertions.assertThatThrownBy( () -> Motorbike.Builder.builder().withTypeOfMotorbike("touring")
                .withColor("gold")
                .withEngineCapacity(15.0) // too big Capacity
                .withMotorBasket(false)
                .withNumberOfAxles(2)
                .build())
                .isInstanceOf(RuntimeException.class);
    }
}
