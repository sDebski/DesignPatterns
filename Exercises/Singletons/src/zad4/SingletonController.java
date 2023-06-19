package zad4;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class SingletonController {

    SingletonThread t1, t2, t3;

    @BeforeEach
    public void startThreads() {
        t1 = new SingletonThread();
        t1.start();

        t2 = new SingletonThread();
        t2.start();

        t3 = new SingletonThread();
        t3.start();
    }

    @AfterEach
    public void stopThreads() {
        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
        t1 = null;
        t2 = null;
        t3 = null;
    }

    @Test
    public void compareThreads() {
        assertAll(
                () -> assertNotEquals(t1.getInstance().hashCode(), t2.getInstance().hashCode()),
                () -> assertNotEquals(t1.getInstance().hashCode(), t3.getInstance().hashCode()),
                () -> assertNotEquals(t2.getInstance().hashCode(), t3.getInstance().hashCode())
                );
    }

}
