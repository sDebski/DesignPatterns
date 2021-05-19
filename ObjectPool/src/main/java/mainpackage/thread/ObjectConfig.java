package mainpackage.thread;

import mainpackage.model.CalculationType;

public class ObjectConfig {
    private CalculationType type;
    private int iterations;
    private int numberOfObjects;

    private ObjectConfig(Builder builder) {
        this.type = builder.type;
        this.iterations = builder.iterations;
        this.numberOfObjects = builder.numberOfObjects;
    }

    public int getIterations() {
        return this.iterations;
    }

    public int getNumberOfObjects() {
        return this.numberOfObjects;
    }

    public CalculationType getType() {
        return this.type;
    }

    public static class Builder {
        CalculationType type;
        int iterations = 1;
        int numberOfObjects = 1;

        private Builder(){};

        public static Builder builder() {
            return new Builder();
        }

        public Builder withType(CalculationType type) {
            this.type = type;
            return this;
        }

        public Builder withNumberOfObjects(int numberOfObjects) {
            if (numberOfObjects < 1) {
                throw new IllegalArgumentException("Wrong objects number!");
            }
            this.numberOfObjects = numberOfObjects;
            return this;
        }
        public Builder withIterations(int iterations) {
            if (iterations < 1) {
                throw new IllegalArgumentException("Wrong iterations number!");
            }
            this.iterations = iterations;
            return this;
        }


        public ObjectConfig build(){
            if (type == null) {
                throw new RuntimeException("Wrong calc type!");
            }
            return new ObjectConfig(this);
        }
    }
}