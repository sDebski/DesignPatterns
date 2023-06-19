package zad4;

public class SingletonThread extends Thread {
    private Singleton uniqueInstance;

    public Singleton getInstance() {
        return uniqueInstance;
    }

    @Override
    public void run() { uniqueInstance = Singleton.getInstance(); }

}
