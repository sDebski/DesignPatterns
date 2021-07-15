package company.model;

import java.util.*;
import company.factory.MotoFactory;
import company.foodbar.FoodBar;
import company.model.workers.FactoryWorker;
import company.model.workers.FoodBarWorker;
import company.model.workers.OfficeWorker;
import company.model.workers.President;
import company.model.workers.composite.CompositeElement;
import company.model.workers.composite.ForSureNotTeamLeader;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class MotoCompany {

    private String name;
    private President president;
    private List<FactoryWorker> factoryWorkerList;
    private List<OfficeWorker> officeWorkerList;
    private List<FoodBarWorker> foodBarWorkerList;
    private List<MotoFactory> factoryList;
    private FoodBar foodBar;

    public MotoCompany(String name) {
        this.name = name;
        this.officeWorkerList = new ArrayList<>();
        this.factoryWorkerList = new ArrayList<>();
        this.foodBarWorkerList = new ArrayList<>();
    }

    public void createFoodBar(String name) {
        this.foodBar = new FoodBar(name);
    }

    public void hirePresident() {
        this.president = President.getInstance("Mr. President");
    }

    public static <T extends CompositeElement> void hireWorkers(Class<T> type, String typeOfWorker, int amount, List<T> list) {
        for (int i = 0; i < amount; i++) {
            CompositeElement worker = new CompositeElement(typeOfWorker.toLowerCase() +  "worker" + i);
            list.add((T) worker);
        }
    }

    public void hireFoodBarWorkers(int amount) {
        for (int i = 0; i < amount; i++) {
            FoodBarWorker worker = new FoodBarWorker("Food Bar worker: " + i);
            foodBarWorkerList.add(worker);
        }
    }

}
