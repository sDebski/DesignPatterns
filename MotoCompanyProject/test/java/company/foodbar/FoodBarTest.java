package company.foodbar;

import company.foodbar.dessert.Dessert;
import company.foodbar.dessert.decorators.CocoaSprinklesDecorator;
import company.foodbar.dessert.decorators.VanillaIceCreamDecorator;
import company.foodbar.dessert.models.BakewellTart;
import company.foodbar.dessert.models.CherriesJubilee;
import company.foodbar.maincourse.MainCourseMeat;
import company.foodbar.maincourse.decorators.FruitSaladDecorator;
import company.foodbar.maincourse.decorators.PotatoesDecorator;
import company.foodbar.maincourse.meatsmodels.PorkNeck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class FoodBarTest {

    @Test
    public void MainCourseDecoratorDescriptionAndSumTest() {
        MainCourseMeat porkNeck = new PorkNeck();

        porkNeck = new PotatoesDecorator(porkNeck);
        porkNeck = new FruitSaladDecorator(porkNeck);

        System.out.println(porkNeck.getDescription() + " \t " + "Cost: " + porkNeck.Cost());

        Assertions.assertEquals(porkNeck.Cost(), (10.99 + 3.99 + 2.99));
    }

    @Test
    public void DessertDecoratorDescriptionAndSumTest() {
        Dessert cherriesJubilee = new CherriesJubilee();

        cherriesJubilee = new CocoaSprinklesDecorator(cherriesJubilee);
        cherriesJubilee = new VanillaIceCreamDecorator(cherriesJubilee);

        System.out.println(cherriesJubilee.getDescription() + " \t " + "Cost: " + cherriesJubilee.Cost());

        Assertions.assertEquals(cherriesJubilee.Cost(), (10.99 + 3.99 + 1.99));
    }

    @Test
    public void CheckIfFoodBarCanWorkWithNoWorkers() {
        FoodBar foodBar = new FoodBar("FoodBar");

        org.assertj.core.api.Assertions.assertThatThrownBy( () -> foodBar.areWorkersToWork())
                .isInstanceOf(NullPointerException.class);

        foodBar.hireWorker(5);

        Assertions.assertEquals(foodBar.areWorkersToWork(), true);
    }

    @Test
    public void checkFoodPreparation() {
        FoodBar foodBar = new FoodBar("FoodBar");

        foodBar.prepareFood();

        assertThat(foodBar
                .getMainCourseMeatList()
                .stream()
                .anyMatch(o -> o
                        .getDescription()
                        .equals("Schnitzel with: ")))
        .isNotNull();

        assertThat(foodBar
                .getDessertList()
                .stream()
                .anyMatch(o -> o
                        .getDescription()
                        .equals("Banoffee Pie with: ")))
                .isNotNull();
    }
}
