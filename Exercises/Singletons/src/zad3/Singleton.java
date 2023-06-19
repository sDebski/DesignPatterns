package zad3;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton implements Serializable {
    private static  Singleton uniqueInstance;

    private long number = 0;

    private Singleton() {};

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
            uniqueInstance.number = System.currentTimeMillis();
        }

        return uniqueInstance;
    }

    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }

    public long getNumber() {
        return number;
    }
}
