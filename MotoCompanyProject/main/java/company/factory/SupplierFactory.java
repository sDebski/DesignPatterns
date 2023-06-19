package company.factory;

import company.model.vehicles.Car;
import company.model.vehicles.IVehicle;
import company.model.vehicles.Motorbike;
import company.model.vehicles.Truck;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SupplierFactory {
    private static final Map<String, Supplier<? extends IVehicle>> types = new HashMap<>();
    static {
        types.put("motorbike", Motorbike::new);
        types.put("car", Car::new);
        types.put("truck", Truck::new);
    }
    private SupplierFactory(){};

    public static void registerSupplier(String name, Supplier<? extends IVehicle> supplier){
        types.put(name.toLowerCase(), supplier);
    }

    public static IVehicle getVehicle(String name){
        if (!types.containsKey(name.toLowerCase())){
            throw new IllegalStateException(name + " <- this name does not exist.");
        }
        return types.get(name).get();
    }
}
