package mainpackage.model.calc;

import mainpackage.model.CalculationType;
import mainpackage.model.Value;

public class MathCalcComplex extends ValueCalc {

    public MathCalcComplex(double _value) {
        super(_value);
    }

    @Override
    public Value getCalculatedValue(Value v) {
        Value val = new Value(v.getValue());
        for (int i = 0; i < iterations; i++) {
            val.setValue(Math.pow(_value, 3)*Math.pow(_value, 4));
            _value = val.getValue();
        }
        return val;
    }

    @Override
    public CalculationType getType() {
        return CalculationType.COMPLEX;
    }
}