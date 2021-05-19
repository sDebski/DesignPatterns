package zad3;

import java.io.*;

public class SingletonController {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2;

        EnumSingleton enum1 = EnumSingleton.INSTANCE;
        EnumSingleton enum2;

        try (FileOutputStream fos = new FileOutputStream("./SerSingleton.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(singleton1);
        }
        try (FileOutputStream fos = new FileOutputStream("./SerEnumSingleton.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(enum1);
        }

        try (FileInputStream fis = new FileInputStream("./SerSingleton.ser");
             ObjectInputStream ois = new ObjectInputStream(fis);) {
            singleton2 = (Singleton) ois.readObject();
        }

        try (FileInputStream fis = new FileInputStream("./SerEnumSingleton.ser");
             ObjectInputStream ois = new ObjectInputStream(fis);) {
            enum2 = (EnumSingleton) ois.readObject();
        }

        System.out.println("Singleton");
        System.out.println(singleton1.getNumber() + " " + singleton2.getNumber());
        System.out.println(singleton1.equals(singleton2));

        System.out.println("Enum");
        System.out.println(enum1.equals(enum2));

    }
}
