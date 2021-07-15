package company.factory;

import company.model.vehicles.Car;
import company.model.vehicles.IVehicle;
import company.model.vehicles.Motorbike;
import company.model.vehicles.Truck;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ReflectionFactory {
    private static final Map<String, Class<? extends IVehicle>> types = new HashMap<>();
    static {
        types.put("motorbike", Motorbike.class);
        types.put("car", Car.class);
        types.put("truck", Truck.class);
    }
    private ReflectionFactory(){}

    public static void registerType(String name, Class<? extends IVehicle> _class){
        types.put(name.toLowerCase(),_class);
    }

    public static IVehicle getVehicle(String name) {
        if (!types.containsKey(name.toLowerCase())){
            throw new IllegalStateException(name + " <- this Shape was not found.");
        }
        Class<? extends IVehicle> _class = types.get(name);
        try {
            Constructor constructor = _class.getDeclaredConstructor();
            return (IVehicle) constructor.newInstance();
        }
        catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
