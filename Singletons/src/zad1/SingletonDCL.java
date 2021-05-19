package zad1;

public class SingletonDCL {
    private volatile static SingletonDCL uniqueInstance;

    private int number;

    private SingletonDCL() {
        number = 10;
        System.out.println("Singleton: Initializing Instance");
    }

    public static SingletonDCL getInstance() {
        if (uniqueInstance == null) {
            synchronized (SingletonDCL.class) {
                if (uniqueInstance == null) {
                    System.out.println("getInstance: First time");
                    uniqueInstance = new SingletonDCL();
                }
            }
        }
        return uniqueInstance;
    }

    public void increase() {
        number += 10;
    }
}
