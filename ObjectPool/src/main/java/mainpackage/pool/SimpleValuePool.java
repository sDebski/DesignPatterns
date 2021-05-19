package mainpackage.pool;

import mainpackage.model.calc.MathCalcSimple;

public class SimpleValuePool extends ObjectPool<MathCalcSimple> {

    public SimpleValuePool(MathCalcSimple prototype) {
        super(prototype);
    }

    @Override
    protected MathCalcSimple create() {
        return (MathCalcSimple) prototype.clone();
    }

    @Override
    protected void reset(MathCalcSimple object) {
        object.setValue(prototype.getValue());
        object.setIterations(1);
    }
}