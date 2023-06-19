package mainpackage.pool;

import mainpackage.model.calc.MathCalcComplex;
import mainpackage.model.calc.MathCalcSimple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimplePoolTest {
    SimpleValuePool simpleValuePool;

    @BeforeEach
    public void setUp() {
        MathCalcSimple simplePrototype = new MathCalcSimple(2);
        simpleValuePool = new SimpleValuePool(simplePrototype);
    }

    @Test
    public void checkOutTest() {
        simpleValuePool.checkOut();
        simpleValuePool.checkOut();
        simpleValuePool.checkOut();
        assertThat(simpleValuePool)
                .matches(e -> e.getInUse().size() == 3)
                .matches(e -> e.getAvailable().size() == 0);
    }

    @Test
    public void checkInTest() {
        MathCalcSimple p1, p2, p3;
        p1 = simpleValuePool.checkOut();
        p2 = simpleValuePool.checkOut();
        p3 = simpleValuePool.checkOut();
        simpleValuePool.checkIn(p1);
        simpleValuePool.checkIn(p2);
        assertThat(simpleValuePool)
                .matches(e -> e.getInUse().size() == 1)
                .matches(e -> e.getAvailable().size() == 2);
    }
}
