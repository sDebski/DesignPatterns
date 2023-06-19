package mainpackage.model.calc;

import mainpackage.model.CalculationType;
import mainpackage.model.Value;

public class MathCalcSimple extends ValueCalc {

    public MathCalcSimple(double _value) {
        super(_value);
    }

    @Override
    public Value getCalculatedValue(Value v) {
        Value val = new Value(v.getValue());
        for (int i = 0; i < iterations; i++) {
            val.setValue(Math.sqrt(_value)*2);
            _value = val.getValue();
        }
        return val;
    }

    @Override
    public CalculationType getType() {
        return CalculationType.SIMPLE;
    }
}