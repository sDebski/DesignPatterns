package zad1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class SingletonController {
    public static final int number_of_threads = 100;

    @Test
    public void isOneSingletonForAllThreads() {
        final Singleton[] singleton = new Singleton[number_of_threads];
        final SingletonDCL[] singletonDCL = new SingletonDCL[number_of_threads];

        for(int i = 0; i< number_of_threads; i++) {
            final int tmp = i;
            new Thread("" + i){
                public void run(){
                    singleton[tmp] = Singleton.getInstance();
                    singletonDCL[tmp] = SingletonDCL.getInstance();
                }
            }.start();
        }
        try { Thread.sleep(10);
        } catch (InterruptedException ex) {
            System.out.println("Error");
        }

        for(int i = 2; i < number_of_threads; i++) {
            System.out.println("Comparing: 1 and " + i);
            assertEquals(singleton[1].hashCode(), singleton[i].hashCode());
            assertEquals(singletonDCL[1].hashCode(), singletonDCL[i].hashCode());
        }
    }

}
