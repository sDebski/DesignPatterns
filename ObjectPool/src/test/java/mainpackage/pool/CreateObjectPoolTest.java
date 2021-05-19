package mainpackage.pool;

import mainpackage.model.calc.MathCalcComplex;
import mainpackage.model.calc.MathCalcSimple;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateObjectPoolTest {
    @Test
    public void createSimplePool() {
        MathCalcSimple simplePrototype = new MathCalcSimple(2);
        SimpleValuePool simpleValuePool = new SimpleValuePool(simplePrototype);
        assertThat(simpleValuePool)
                .isNotNull()
                .isInstanceOf(SimpleValuePool.class);
        assertThat(simpleValuePool.prototype)
                .isEqualTo(simplePrototype);
    }

    @Test
    public void createComplexPool() {
        MathCalcComplex complexPrototype = new MathCalcComplex(2);
        ComplexValuePool complexValuePool = new ComplexValuePool(complexPrototype);
        assertThat(complexValuePool)
                .isNotNull()
                .isInstanceOf(ComplexValuePool.class);
        assertThat(complexValuePool.prototype)
                .isEqualTo(complexPrototype);
    }
}