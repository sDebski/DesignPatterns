package factories.factory.register;

import factories.model.shape.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ReflectionShapeFactory {
    private static final Map<String, Class<? extends Shape>> types = new HashMap<>();
    static {
        types.put("triangle", Triangle.class);
        types.put("square", Square.class);
        types.put("circle", Circle.class);
    }
    private ReflectionShapeFactory(){}

    public static void registerType(String name, Class<? extends Shape> _class){
        types.put(name.toLowerCase(),_class);
    }
    public static Shape getShape(String name) {
        if (!types.containsKey(name.toLowerCase())){
            throw new IllegalStateException(name + " <- this Shape was not found.");
        }
        Class<? extends Shape> _class = types.get(name);
        try {
            Constructor constructor = _class.getDeclaredConstructor();
            return (Shape) constructor.newInstance();
        }
        catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
