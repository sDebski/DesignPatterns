package factories.unitTests;

import factories.factory.method.*;
import factories.model.animal.*;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertThat;


public class MethodFactoryTests {
    @Test
    void createMammals() {
        AnimalFactory mammalFactory = MammalFactory.getInstance();
        Animal dog = mammalFactory.getAnimal("dog");
        Animal cat = mammalFactory.getAnimal("cat");

        assertThat(dog, instanceOf(Mammal.class));
        assertThat(cat, instanceOf(Mammal.class));
        assertEquals("Dog", dog.getAnimalName());
        assertEquals("Cat", cat.getAnimalName());
    }

    @Test
    void createBirds(){
        AnimalFactory animalFactory = BirdFactory.getInstance();
        Animal duck = animalFactory.getAnimal("duck");
        Animal chicken = animalFactory.getAnimal("chicken");
        assertThat(duck, instanceOf(Bird.class));
        assertThat(chicken, instanceOf(Bird.class));
        assertEquals("Duck",duck.getAnimalName());
        assertEquals("Chicken",chicken.getAnimalName());
    }
    @Test
    void createMammalInsteadOfBird(){
        MammalFactory factory = MammalFactory.getInstance();
        assertThrows(IllegalStateException.class,() -> factory.getAnimal("duck"));
    }
}
