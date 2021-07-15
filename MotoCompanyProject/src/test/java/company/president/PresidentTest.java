package company.president;

import company.model.workers.President;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PresidentTest {

    @Test
    public void checkPresidentConstructor() {
        President president = President.getInstance("Mr. President");

        Assertions.assertEquals(president.getIncome(), 15000.0);
        Assertions.assertEquals(president.getName(), "Mr. President");
        Assertions.assertEquals(president.getDaysOff(), 15);
    }

    @Test
    public void doNotLetCreatePresidentWithNewName() {
        President president = President.getInstance("Old name");

        President new_president = President.getInstance("New name");

        Assertions.assertEquals(president.getName(), new_president.getName());
    }

    @Test
    public void checkIfPresidentsInAllThreadsAreSame() {
        int number_of_threads = 10;

        final President[] list_of_presidents = new President[number_of_threads];

        for(int i = 0; i< number_of_threads; i++) {
            final int tmp = i;
            new Thread("" + i){
                public void run(){
                    list_of_presidents[tmp] = President.getInstance("President" + tmp);
                }
            }.start();
        }
        try { Thread.sleep(10);
        } catch (InterruptedException ex) {
            System.out.println("Error");
        }

        for(int i = 1; i < number_of_threads; i++) {
            System.out.println("Comparing: 0 and " + i);
            Assertions.assertEquals(list_of_presidents[0].hashCode(), list_of_presidents[i].hashCode());
        }
    }

}
