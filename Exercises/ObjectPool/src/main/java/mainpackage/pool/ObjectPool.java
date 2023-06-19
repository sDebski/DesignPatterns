package mainpackage.pool;

import java.util.HashSet;
import java.util.Set;

public abstract class ObjectPool<T> {
    protected T prototype;
    private final Set<T> available;
    private final Set<T> inUse;

    public ObjectPool(T prototype) {
        this.available = new HashSet<>();
        this.inUse = new HashSet<>();
        this.prototype = prototype;
    }

    public Set<T> getAvailable() {
        return this.available;
    }

    public Set<T> getInUse() {
        return this.inUse;
    }

    protected abstract T create();

    protected abstract void reset(T object);

    public synchronized T checkOut() {
        System.out.println("Number of objects in pool working: " + inUse.size());
        if (available.isEmpty()) {
            available.add(create());
        }
        T instance = available.iterator().next();
        available.remove(instance);
        inUse.add(instance);
        return instance;
    }

    public synchronized void checkIn(T instance) {
        inUse.remove(instance);
        reset(instance);
        available.add(instance);
    }
}