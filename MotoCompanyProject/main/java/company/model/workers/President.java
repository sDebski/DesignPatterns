package company.model.workers;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class President implements IWorker {
    private static President instance;
    private String name;
    private double income;
    private int daysOff;


    private President(String name){
        this.name = name;
        this.daysOff = 15;
        this.income = 15000.0;
    }

    public static President getInstance(String name) {
        if (instance == null) {
            synchronized (President.class) {
                if (instance == null) {
                    instance = new President(name);
                }
            }
        }
        return instance;
    }
}
