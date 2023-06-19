package zad4;

public final class Singleton {
    private static ThreadLocal<Singleton> threadLocal = new ThreadLocal<Singleton>(){
        @Override
        protected Singleton initialValue() {
            return null;
        }
    };

    private Singleton() {}

    public static Singleton getInstance() {
        if (threadLocal.get() == null)
            threadLocal.set(new Singleton());
        return threadLocal.get();
    }
}
