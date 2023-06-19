package mainpackage.thread;

import mainpackage.model.CalculationType;
import mainpackage.model.Value;
import mainpackage.model.calc.ValueCalc;
import mainpackage.pool.ObjectPool;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Callable;

public class CalcThread implements Callable<Value> {

    private final LinkedList<ObjectConfig> calculationsConfig;
    private final Map<CalculationType, ObjectPool> objectPoolMap;
    private final LinkedList<ValueCalc> calculationsToExecute;
    private Value val;

    private CalcThread(Builder builder) {
        this.calculationsConfig = builder.calculationsConfig;
        this.objectPoolMap = builder.objectPoolMap;
        this.val = builder.val;
        this.calculationsToExecute = new LinkedList<>();
    }

    public LinkedList<ObjectConfig> getCalculationsConfig() {
        return this.calculationsConfig;
    }

    public Map<CalculationType, ObjectPool> getObjectPoolMap() {
        return this.objectPoolMap;
    }
    public Value getVal() {
        return val;
    }

    @Override
    public Value call() {
        for (ObjectConfig config : calculationsConfig) {
            ObjectPool objectPool = objectPoolMap.get(config.getType());
            for (int i = 0; i < config.getNumberOfObjects(); i++) {
                ValueCalc calc = (ValueCalc) objectPool.checkOut();
                calc.withIterations(config.getIterations());
                calculationsToExecute.addLast(calc);
            }
        }
        for (ValueCalc calc : calculationsToExecute) {
            this.val = calc.getCalculatedValue(this.val);
            objectPoolMap.get(calc.getType()).checkIn(calc);
        }
        return this.val;
    }

    public static class Builder {
        LinkedList<ObjectConfig> calculationsConfig = new LinkedList<>();
        Map<CalculationType, ObjectPool> objectPoolMap;
        Value val;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withValue(Value val) {
            this.val = val;
            return this;
        }

        public Builder withObjectPools(Map<CalculationType, ObjectPool> objectPoolMap) {
            if (!objectPoolMap.keySet().containsAll(Arrays.asList(CalculationType.values()))) {
                throw new IllegalArgumentException("Wrong objectPoolMap!");
            }
            this.objectPoolMap = objectPoolMap;
            return this;
        }

        public Builder withCalculation(ObjectConfig calculationConfig) {
            calculationsConfig.addLast(calculationConfig);
            return this;
        }

        public CalcThread build() {
            if (val == null) {
                throw new RuntimeException("Wrong value!");
            }
            if (objectPoolMap == null) {
                throw new RuntimeException("Wrong object pool!");
            }
            if (calculationsConfig.isEmpty()) {
                throw new RuntimeException("Wrong configuration!");
            }
            return new CalcThread(this);
        }
    }
}