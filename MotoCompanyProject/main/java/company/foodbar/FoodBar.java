package company.foodbar;

import company.foodbar.dessert.Dessert;
import company.foodbar.dessert.models.BakewellTart;
import company.foodbar.dessert.models.BanoffeePie;
import company.foodbar.dessert.models.CherriesJubilee;
import company.foodbar.dessert.models.ChristmasPudding;
import company.foodbar.maincourse.MainCourseMeat;
import company.foodbar.maincourse.meatsmodels.ChickenKiev;
import company.foodbar.maincourse.meatsmodels.MeatChop;
import company.foodbar.maincourse.meatsmodels.PorkNeck;
import company.foodbar.maincourse.meatsmodels.Schnitzel;
import company.model.workers.FoodBarWorker;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class FoodBar {
    public List<FoodBarWorker> foodBarWorkerList;
    public String name;
    public boolean readyToWork;
    private List<Dessert> dessertList;
    private List<MainCourseMeat> mainCourseMeatList;


    public FoodBar(String name) {
        this.name = name;
        this.readyToWork = false;
        this.foodBarWorkerList = new ArrayList<>();
        this.dessertList = new ArrayList<>();
        this.mainCourseMeatList = new ArrayList<>();
    }

    public void hireWorker(int amount) {
        for( int i = 0; i < amount; i++) {
            FoodBarWorker worker = new FoodBarWorker("Worker " + i);
            this.foodBarWorkerList.add(worker);
        }
        this.setFoodBarReadyToWork();
    }

    public boolean areWorkersToWork () {
        if ( foodBarWorkerList.isEmpty()) {
            throw new NullPointerException("Food Bar can not work without workers.");
        }
        else return readyToWork;
    }

    private void setFoodBarReadyToWork() {
        this.readyToWork = true;
    }

    public void prepareFood() {
        if( this.dessertList.isEmpty() && this.mainCourseMeatList.isEmpty() ) {
            this.dessertList.add(new ChristmasPudding());
            this.dessertList.add(new BanoffeePie());
            this.dessertList.add(new CherriesJubilee());
            this.dessertList.add(new BakewellTart());

            this.mainCourseMeatList.add(new ChickenKiev());
            this.mainCourseMeatList.add(new PorkNeck());
            this.mainCourseMeatList.add(new Schnitzel());
            this.mainCourseMeatList.add(new MeatChop());

        } else {
            throw new RuntimeException("The food is already prepared");
        }

    }

}
