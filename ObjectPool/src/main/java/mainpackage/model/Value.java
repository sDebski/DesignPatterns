package mainpackage.model;

public class Value {
    private double _value;

    public Value() {};
    public Value(double value) {
        this._value = value;
    }
    public double getValue() {
        return _value;
    }

    public void setValue(double value) {
        this._value = value;
    }

    @Override
    public String toString() {
        return String.format("[%.4f]", _value);
    }
}
