package mainpackage.builder;

import mainpackage.model.CalculationType;
import mainpackage.thread.ObjectConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ObjectConfigBuilderTest {

    @Test
    public void buildObjectConfigWithAllFields() {
    CalculationType type = CalculationType.SIMPLE;
    int numberOfObjects = 10;
    int iterations = 15;
    ObjectConfig objectConfig = ObjectConfig.Builder.builder()
            .withType(type)
            .withNumberOfObjects(numberOfObjects)
            .withIterations(iterations)
            .build();
    assertThat(objectConfig)
            .matches(e -> e.getNumberOfObjects() == numberOfObjects)
            .matches(e -> e.getIterations() == iterations)
            .matches(e -> CalculationType.SIMPLE.equals(e.getType()));
    }

    @Test
    public void buildObjectConfigWithWrongConfig() {
    CalculationType type = CalculationType.SIMPLE;
    ObjectConfig objectConfig = ObjectConfig.Builder.builder()
            .withType(type)
            .build();
    assertThat(objectConfig)
            .matches(e -> e.getNumberOfObjects() == 1)
            .matches(e -> e.getIterations() == 1)
            .matches(e -> CalculationType.SIMPLE.equals(e.getType()));
}

    @Test
    public void throwExceptionWhenTypeWrong() {
    Assertions.assertThatThrownBy( () -> ObjectConfig.Builder.builder().build())
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void throwExceptionWhenIterationsWrong() {
    CalculationType type = CalculationType.SIMPLE;
    int iterations = 0;
    Assertions.assertThatThrownBy( () -> ObjectConfig.Builder.builder()
            .withType(type).withIterations(iterations).build())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void throwExceptionWhenNumberOfObjectsWrong() {
    CalculationType type = CalculationType.SIMPLE;
    int numberOfObjects = 0;
    assertThatThrownBy( () -> ObjectConfig.Builder.builder()
            .withType(type).withIterations(numberOfObjects).build())
            .isInstanceOf(IllegalArgumentException.class);
    }
}