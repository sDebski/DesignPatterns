package mainpackage.pool;

import mainpackage.model.calc.MathCalcComplex;

public class ComplexValuePool extends ObjectPool<MathCalcComplex> {

    public ComplexValuePool(MathCalcComplex prototype) {
        super(prototype);
    }

    @Override
    protected MathCalcComplex create() {
        return (MathCalcComplex) prototype.clone();
    }

    @Override
    protected void reset(MathCalcComplex object) {
        object.setValue(prototype.getValue());
        object.setIterations(1);

    }
}