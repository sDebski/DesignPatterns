package factories;
import factories.factory.simple.SimpleColourFactory;
import factories.factory.abstrct.*;
import factories.factory.register.*;

import org.openjdk.jmh.annotations.*;


@State(Scope.Benchmark)
public class PerformanceTests {

    @Param({"9999999"})
    int loops;

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    public void SimpleFactoryTests() {
        SimpleColourFactory factory = SimpleColourFactory.getInstance();
        for (int i = 0; i < loops; i++){
            factory.getColour("red");
            factory.getColour("green");
            factory.getColour("blue");
        }
    }


    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    public void AbstractFactoryTests() {
        ShapeDrawFactory shapeF = ShapeDrawFactory.getInstance();
        ColourDrawFactory colourF = ColourDrawFactory.getInstance();
        for (int i = 0; i < loops; i++){
            shapeF.getColor();
            shapeF.getShape();
            colourF.getColor();
            colourF.getShape();
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    public void ReflectionFactoryTests() {
        for (int i = 0; i < loops; i++){
            ReflectionShapeFactory.getShape("square");
            ReflectionShapeFactory.getShape("triangle");
            ReflectionShapeFactory.getShape("circle");
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    public void SupplierFactoryTests(){
        for (int i = 0; i < loops; i++){
            SupplierShapeFactory.getShape("triangle");
            SupplierShapeFactory.getShape("square");
            SupplierShapeFactory.getShape("circle");
        }
    }

}
