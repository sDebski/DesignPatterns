package company;


import company.factory.FactoryWithMethod;
import company.factory.MotoFactory;
import company.factory.ReflectionFactory;
import company.factory.SupplierFactory;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;

import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class PerformanceTest {
    @Param({"9999999"})
    int loops;

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    public void AbstractMotoFactoryTest() {
        MotoFactory factory = new MotoFactory("MotoFactory");
        for (int i = 0; i < loops; i++){
            factory.getCar();
            factory.getMotorbike();
            factory.getTruck();
        }
    }


    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    public void FactoryManufactureMethodTests() {
        FactoryWithMethod factoryWithMethod = FactoryWithMethod.getInstance();
        for (int i = 0; i < loops; i++){
            factoryWithMethod.getVehicle("truck");
            factoryWithMethod.getVehicle("car");
            factoryWithMethod.getVehicle("motorbike");
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    public void ReflectionFactoryTest() {
        for (int i = 0; i < loops; i++){
            ReflectionFactory.getVehicle("truck");
            ReflectionFactory.getVehicle("car");
            ReflectionFactory.getVehicle("motorbike");
        }
    }


    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    public void SupplierFactoryTest() {
        for (int i = 0; i < loops; i++){
            SupplierFactory.getVehicle("truck");
            SupplierFactory.getVehicle("car");
            SupplierFactory.getVehicle("motorbike");
        }
    }


}
