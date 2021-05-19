package factories.factory.register;

import factories.model.shape.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SupplierShapeFactory {
    private static final Map<String, Supplier<? extends Shape>> types = new HashMap<>();
    static {
        types.put("triangle", Triangle::new);
        types.put("square", Square::new);
        types.put("circle", Circle::new);
    }
    private SupplierShapeFactory(){};

    public static void registerSupplier(String name, Supplier<? extends Shape> supplier){
        types.put(name.toLowerCase(), supplier);
    }

    public static Shape getShape(String name){
        if (!types.containsKey(name.toLowerCase())){
            throw new IllegalStateException(name + " <- this name does not exist.");
        }
        return types.get(name).get();
    }
}
