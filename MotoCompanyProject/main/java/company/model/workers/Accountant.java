package company.model.workers;

import company.model.workers.composite.CompositeElement;
import company.model.workers.composite.TeamMember;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Accountant {
    private HashMap<String, WorkerValues> officeWorkersMap;
    private HashMap<String, WorkerValues> factoryWorkerMap;
    private HashMap<String, WorkerValues> foodBarWorkersMap;
    private String name;

    public Accountant(String name) {
        this.name = name;
        officeWorkersMap = new HashMap<>();
        foodBarWorkersMap = new HashMap<>();
        factoryWorkerMap = new HashMap<>();
    }

    public <T extends CompositeElement> void AddWorkersToLists(List<T> list_of_workers, String classOfWorker) {
        HashMap<String, WorkerValues> list;
        switch (classOfWorker.toLowerCase()) {
            case "office": list = this.officeWorkersMap; break;
            case "factory": list = this.factoryWorkerMap; break;
            case "foodbar": list = this.foodBarWorkersMap; break;
            default: throw new RuntimeException("No such class of workers");
        }

        for (CompositeElement tm: list_of_workers ) {
            list.put(tm.getName(), new WorkerValues(tm.getIncome(), tm.getVacationDays()));
        }
    }

    public void update(TeamMember worker, String classOfWorker) {
        switch (classOfWorker.toLowerCase()) {
            case "office": {
                this.officeWorkersMap.put(worker.getName(),  new WorkerValues(worker.getIncome(), worker.getVacationDays()));
            } break;
            case "foodbar": {
                this.foodBarWorkersMap.put(worker.getName(),  new WorkerValues(worker.getIncome(), worker.getVacationDays()));
            } break;
            case "factory": {
                this.factoryWorkerMap.put(worker.getName(),  new WorkerValues(worker.getIncome(), worker.getVacationDays()));
            } break;
            default: throw new RuntimeException("No such class of Worker");
        }

        System.out.println("Accountant got info update about worker: " + worker.getName()
                + "\n New values: \t Income: " + worker.getIncome() + "\tVacationDays: " + worker.getVacationDays());
    }

    @Getter
    @Setter
    public class WorkerValues {
        private int vacationDays;
        private double income;

        public WorkerValues(double income, int vacationDays) {
            this.income = income;
            this.vacationDays = vacationDays;
        }
    }

}
