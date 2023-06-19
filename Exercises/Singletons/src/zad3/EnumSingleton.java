package zad3;

public enum EnumSingleton {
    INSTANCE;

    private int number = 0;
    public int getNumber() {
        return number;
    }

    public void increment() {
        number += 1;
    }
}
