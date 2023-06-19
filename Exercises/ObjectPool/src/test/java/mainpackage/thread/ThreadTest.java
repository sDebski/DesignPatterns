package mainpackage.thread;

import mainpackage.model.CalculationType;
import mainpackage.model.Value;
import mainpackage.model.calc.MathCalcComplex;
import mainpackage.model.calc.MathCalcSimple;
import mainpackage.pool.ComplexValuePool;
import mainpackage.pool.ObjectPool;
import mainpackage.pool.SimpleValuePool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

public class ThreadTest {
    ExecutorService es;
    Map<CalculationType, ObjectPool> map = new HashMap<>();

    @BeforeEach
    public void setUp() {
        map = new HashMap<>();
        map.put(CalculationType.SIMPLE, new SimpleValuePool(new MathCalcSimple(2)));
        map.put(CalculationType.COMPLEX, new ComplexValuePool(new MathCalcComplex(2)));
    }

    @Test
    public void checkFunctionReturnGoodResult() {
        CalcThread calcThread = CalcThread.Builder.builder()
                .withValue(new Value(2))
                .withCalculation(ObjectConfig.Builder.builder().
                        withType(CalculationType.COMPLEX).build())
                .withObjectPools(map).build();

        Value val = calcThread.call();
        assertThat(val.getValue()).isEqualTo((Math.pow(2, 3)*Math.pow(2, 4)));
    }

    @Test
    public void checkFunctionReturnGoodResultForTwoCalculations() {
        CalcThread calculationThread = CalcThread.Builder.builder()
                .withValue(new Value(2))
                .withCalculation(ObjectConfig.Builder.builder().
                        withType(CalculationType.SIMPLE).build())
                .withCalculation(ObjectConfig.Builder.builder().
                        withType(CalculationType.COMPLEX).build())
                .withObjectPools(map).build();
        Value val = calculationThread.call();
        double val_simple_complex = Math.sqrt(Math.pow(Math.pow(2, 3)*Math.pow(2, 4), 2));
        assertThat(val.getValue()).isEqualTo(val_simple_complex);

    }

    @Test
    public void executeThreadWithManyCalculations() {
        CalcThread calcThread = CalcThread.Builder.builder()
                .withValue(new Value(new Random().nextDouble()))
                .withCalculation(ObjectConfig.Builder.builder().
                        withType(CalculationType.SIMPLE).withNumberOfObjects(3).withIterations(100).build())
                .withCalculation(ObjectConfig.Builder.builder().
                        withType(CalculationType.COMPLEX).withNumberOfObjects(2).withIterations(100).build())
                .withCalculation(ObjectConfig.Builder.builder().
                        withType(CalculationType.SIMPLE).withNumberOfObjects(1).withIterations(100).build())
                .withCalculation(ObjectConfig.Builder.builder().
                        withType(CalculationType.COMPLEX).withNumberOfObjects(2).withIterations(100).build())
                .withObjectPools(map)
                .build();
        Value val = calcThread.call();
        assertThat(val)
                .isNotNull();
    }

    @Test
    public void execute10ThreadsSimpleType() throws InterruptedException {
        es = Executors.newFixedThreadPool(10);
        List<CalcThread> list = createThreadsWithSimpleCalc(1000);
        es.invokeAll(list);
        es.shutdown();
        assertThat(map.get(CalculationType.SIMPLE))
                .matches(e -> e.getInUse().size() == 0 && e.getAvailable().size() >= 1);    }

    @Test
    public void execute100ThreadsSimpleType() throws InterruptedException {
        es = Executors.newFixedThreadPool(100);
        List<CalcThread> list = createThreadsWithSimpleCalc(1000);
        es.invokeAll(list);
        es.shutdown();
        assertThat(map.get(CalculationType.SIMPLE))
                .matches(e -> e.getInUse().size() == 0 && e.getAvailable().size() >= 1);
    }

    private List<CalcThread> createThreadsWithSimpleCalc(int howMany) {
        List<CalcThread> threadList = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            CalcThread calcThread = CalcThread.Builder.builder()
                    .withValue(new Value(new Random().nextDouble()))
                    .withCalculation(ObjectConfig.Builder.builder().
                            withType(CalculationType.SIMPLE).
                            withNumberOfObjects(new Random().nextInt(5) + 1)
                            .withIterations(new Random().nextInt(100) + 1).build())
                    .withObjectPools(map)
                    .build();
            threadList.add(calcThread);
        }
        return threadList;
    }
}