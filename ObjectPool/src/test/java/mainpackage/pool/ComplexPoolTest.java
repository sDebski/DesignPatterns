package mainpackage.pool;

import mainpackage.model.calc.MathCalcComplex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComplexPoolTest {
    ComplexValuePool complexValuePool;

    @BeforeEach
    public void setUp() {
        MathCalcComplex complexPrototype = new MathCalcComplex( 2);
        complexValuePool = new ComplexValuePool(complexPrototype);
    }

    @Test
    public void checkOutTest() {
        complexValuePool.checkOut();
        complexValuePool.checkOut();
        complexValuePool.checkOut();
        assertThat(complexValuePool)
                .matches(e -> e.getInUse().size() == 3)
                .matches(e -> e.getAvailable().size() == 0);
    }

    @Test
    public void checkInTest() {
        MathCalcComplex p1, p2, p3;
        p1 = complexValuePool.checkOut();
        p2 = complexValuePool.checkOut();
        p3 = complexValuePool.checkOut();

        complexValuePool.checkIn(p1);
        complexValuePool.checkIn(p2);

        assertThat(complexValuePool)
                .matches(e -> e.getInUse().size() == 1)
                .matches(e -> e.getAvailable().size() == 2);
    }
}