package mainpackage.builder;
import mainpackage.model.CalculationType;
import mainpackage.model.Value;
import mainpackage.pool.ComplexValuePool;
import mainpackage.pool.ObjectPool;
import mainpackage.pool.SimpleValuePool;
import mainpackage.thread.CalcThread;
import mainpackage.thread.ObjectConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CalcThreadBuilderTest {

    @Mock
    ComplexValuePool complexValuePool;
    @Mock
    SimpleValuePool simpleValuePool;
    Map<CalculationType, ObjectPool> map;

    @BeforeEach
    public void setUp() {
        map = new HashMap<>();
        map.put(CalculationType.SIMPLE, simpleValuePool);
        map.put(CalculationType.COMPLEX, complexValuePool);
    }

    @Test
    public void buildCorrectCalculationThread() {
        Value val = new Value(2);
        ObjectConfig objectConfig = ObjectConfig.Builder.builder().withType(CalculationType.SIMPLE).build();
        CalcThread calcThread = CalcThread.Builder.builder()
                .withCalculation(objectConfig)
                .withValue(val)
                .withObjectPools(map)
                .build();
        assertThat(calcThread)
                .isNotNull()
                .matches(e ->
                        objectConfig.equals(e.getCalculationsConfig().getFirst())
                                && val.equals(e.getVal())
                                && map.equals(e.getObjectPoolMap()));
    }

    @Test
    public void throwExceptionWhenObjectPoolIsWrong() {
        Value val = new Value(2);
        ObjectConfig objectConfig = ObjectConfig.Builder.builder().withType(CalculationType.SIMPLE).build();
        map.remove(CalculationType.SIMPLE);
        assertThatThrownBy(() -> CalcThread.Builder.builder()
                .withCalculation(objectConfig)
                .withValue(val)
                .withObjectPools(map)
                .build()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void throwExceptionWhenNoValue() {
        ObjectConfig objectConfig = ObjectConfig.Builder.builder().withType(CalculationType.SIMPLE).build();
        assertThatThrownBy( () -> CalcThread.Builder.builder()
                .withCalculation(objectConfig)
                .withObjectPools(map)
                .build()).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void throwExceptionWhenNoMapOfObjectPools() {
        ObjectConfig objectConfig = ObjectConfig.Builder.builder().withType(CalculationType.SIMPLE).build();
        Value val = new Value(2);
        assertThatThrownBy( () -> CalcThread.Builder.builder()
                .withCalculation(objectConfig)
                .withValue(val)
                .build()).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void throwExceptionWhenNoObjectConfig() {
        Value val = new Value(2);
        assertThatThrownBy( () -> CalcThread.Builder.builder()
                .withObjectPools(map)
                .withValue(val)
                .build()).isInstanceOf(RuntimeException.class);
    }
}