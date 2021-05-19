package mainpackage.model.calc;

import mainpackage.model.CalculationType;
import mainpackage.model.Value;



public abstract class ValueCalc implements Cloneable {
    protected double _value;
    protected int iterations = 1;
//    protected int multipleResults = 1;

    public ValueCalc(double value) {
        _value = value;
    }

    public int getIterations() {
        return iterations;
    }

    public void setValue(double _value) {
        this._value = _value;
    }

    public double getValue() {
        return _value;
    }
    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public abstract Value getCalculatedValue(Value v);

    public abstract CalculationType getType();

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();

        } catch ( CloneNotSupportedException e ) {
            e.printStackTrace();
        }

        return clone;
    }
    public void withIterations(int iterations) {
        this.iterations = iterations;
    }

//    public void withMultipleResults(int multipleResults) {
//        this.multipleResults = multipleResults;
//    }


}
